package com.example.audio

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sin

data class SoundWaveConfig(
  val frequencies: List<Double>,
  val durationSec: Double,
  val decayFactor: Double,
  val harmonicWeights: List<Double>,
  val isDistorted: Boolean
)

object BeatlesSynthesizer {

  private const val SAMPLE_RATE = 44100

  suspend fun playSound(soundId: String) = withContext(Dispatchers.Default) {
    try {
      val config = when (soundId) {
        "sound_hard_days_night" -> {
          // Fadd9 chord strike + D2 bass + 12-string chime
          SoundWaveConfig(
            frequencies = listOf(73.42, 174.61, 220.0, 261.63, 349.23, 392.0, 440.0, 523.25),
            durationSec = 2.8,
            decayFactor = 1.5,
            harmonicWeights = listOf(1.2, 1.0, 0.9, 0.9, 0.8, 0.8, 0.6, 0.5),
            isDistorted = false
          )
        }
        "sound_let_it_be_piano" -> {
          // Warm C Major Piano (C3, G3, C4, E4, G4, C5)
          SoundWaveConfig(
            frequencies = listOf(130.81, 196.0, 261.63, 329.63, 392.0, 523.25),
            durationSec = 2.5,
            decayFactor = 1.8,
            harmonicWeights = listOf(1.0, 0.8, 1.0, 0.7, 0.7, 0.4),
            isDistorted = false
          )
        }
        "sound_sitar_drone" -> {
          // Indian sitar drone in E (82.4Hz + overtones)
          SoundWaveConfig(
            frequencies = listOf(82.41, 123.47, 164.81, 246.94, 329.63, 411.9, 493.88),
            durationSec = 3.0,
            decayFactor = 1.1,
            harmonicWeights = listOf(1.0, 0.8, 0.9, 0.7, 0.6, 0.5, 0.4),
            isDistorted = false
          )
        }
        "sound_rooftop_rock" -> {
          // Epiphone Casino blues crunch chord (E, B, E, G#, D)
          SoundWaveConfig(
            frequencies = listOf(164.81, 246.94, 329.63, 415.30, 587.33),
            durationSec = 2.2,
            decayFactor = 2.0,
            harmonicWeights = listOf(1.0, 0.9, 0.8, 0.7, 0.6),
            isDistorted = true
          )
        }
        "sound_dog_whistle" -> {
          // Ultra-high 14.5 kHz tone for dogs
          SoundWaveConfig(
            frequencies = listOf(14500.0),
            durationSec = 1.8,
            decayFactor = 1.2,
            harmonicWeights = listOf(1.0),
            isDistorted = false
          )
        }
        "sound_submarine_sonar" -> {
          // High-frequency reverberant sonar ping
          SoundWaveConfig(
            frequencies = listOf(1050.0, 2100.0),
            durationSec = 2.2,
            decayFactor = 2.5,
            harmonicWeights = listOf(1.0, 0.3),
            isDistorted = false
          )
        }
        else -> {
          SoundWaveConfig(
            frequencies = listOf(440.0),
            durationSec = 1.0,
            decayFactor = 2.0,
            harmonicWeights = listOf(1.0),
            isDistorted = false
          )
        }
      }

      val numSamples = (SAMPLE_RATE * config.durationSec).toInt()
      val buffer = ShortArray(numSamples)

      for (i in 0 until numSamples) {
        val t = i.toDouble() / SAMPLE_RATE
        val envelope = exp(-config.decayFactor * t)

        var sample = 0.0
        config.frequencies.forEachIndexed { index, freq ->
          val weight = config.harmonicWeights.getOrElse(index) { 0.5 }
          val modFreq = if (soundId == "sound_sitar_drone") freq + sin(2 * PI * 8.0 * t) * 4.0 else freq
          sample += weight * sin(2 * PI * modFreq * t)
        }

        if (config.isDistorted) {
          sample = sample * 1.8
          if (sample > 1.0) sample = 1.0
          if (sample < -1.0) sample = -1.0
        }

        val normalized = (sample / (config.frequencies.size.coerceAtLeast(1) * 0.5)) * envelope
        val clamped = normalized.coerceIn(-0.95, 0.95)
        buffer[i] = (clamped * Short.MAX_VALUE).toInt().toShort()
      }

      val audioTrack = AudioTrack.Builder()
        .setAudioAttributes(
          AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        )
        .setAudioFormat(
          AudioFormat.Builder()
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setSampleRate(SAMPLE_RATE)
            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
            .build()
        )
        .setBufferSizeInBytes(buffer.size * 2)
        .setTransferMode(AudioTrack.MODE_STATIC)
        .build()

      audioTrack.write(buffer, 0, buffer.size)
      audioTrack.play()

      delay((config.durationSec * 1000).toLong() + 200)
      try {
        audioTrack.stop()
        audioTrack.release()
      } catch (_: Exception) {}
    } catch (_: Exception) {
      // Audio playback failsafe
    }
  }
}
