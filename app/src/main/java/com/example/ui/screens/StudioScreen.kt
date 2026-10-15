package com.example.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.BeatlesSynthesizer
import com.example.data.BeatlesDataRepository
import com.example.model.SoundPreset
import com.example.ui.components.SpinningVinylRecord
import com.example.ui.theme.BeatlesCoral
import com.example.ui.theme.BeatlesGold
import com.example.ui.theme.BeatlesPurple
import com.example.ui.theme.BeatlesTeal
import com.example.ui.theme.VinylDarkBg
import com.example.ui.theme.VinylSurfaceVariant
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StudioScreen(
  modifier: Modifier = Modifier
) {
  val soundPresets = BeatlesDataRepository.soundPresets
  var currentlyPlayingId by remember { mutableStateOf<String?>(null) }
  val scope = rememberCoroutineScope()

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    contentPadding = PaddingValues(top = 16.dp, bottom = 96.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // Header
    item {
      Surface(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(20.dp))
          .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(20.dp)),
        color = MaterialTheme.colorScheme.surface
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = "ABBEY ROAD STUDIO 2",
                style = MaterialTheme.typography.labelSmall.copy(
                  fontWeight = FontWeight.Bold,
                  letterSpacing = 1.5.sp,
                  color = BeatlesGold
                )
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "Звуковая Лаборатория",
                style = MaterialTheme.typography.headlineSmall.copy(
                  fontWeight = FontWeight.ExtraBold,
                  color = MaterialTheme.colorScheme.onSurface
                )
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "Нажмите на инструмент, чтобы услышать аутентичные синтезированные аккорды, свист для собак и разгадки тайн записи!",
                style = MaterialTheme.typography.bodySmall.copy(
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  lineHeight = 18.sp
                )
              )
            }

            Spacer(modifier = Modifier.width(12.dp))

            SpinningVinylRecord(
              size = 64.dp,
              isPlaying = currentlyPlayingId != null
            )
          }
        }
      }
    }

    // Interactive Hard Day's Night Opening Chord Spotlight
    item {
      val isThisPlaying = currentlyPlayingId == "sound_hard_days_night"
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(18.dp))
          .border(1.5.dp, BeatlesGold, RoundedCornerShape(18.dp))
          .clickable {
            scope.launch {
              currentlyPlayingId = "sound_hard_days_night"
              BeatlesSynthesizer.playSound("sound_hard_days_night")
              currentlyPlayingId = null
            }
          }
          .testTag("play_opening_chord_hero"),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surface
        )
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(
              Brush.verticalGradient(
                listOf(
                  BeatlesGold.copy(alpha = 0.15f),
                  Color.Transparent
                )
              )
            )
            .padding(18.dp)
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Box(
                modifier = Modifier
                  .size(44.dp)
                  .clip(CircleShape)
                  .background(BeatlesGold),
                contentAlignment = Alignment.Center
              ) {
                Icon(
                  imageVector = Icons.Default.Bolt,
                  contentDescription = null,
                  tint = VinylDarkBg,
                  modifier = Modifier.size(26.dp)
                )
              }
              Spacer(modifier = Modifier.width(12.dp))
              Column {
                Text(
                  text = "Главная Тайна Рок-Музыки",
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = BeatlesGold
                  )
                )
                Text(
                  text = "Вступительный аккорд «A Hard Day's Night»",
                  style = MaterialTheme.typography.labelSmall.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          Text(
            text = "Этот единственный удар по струнам 40 лет сводил с ума ученых. Нажмите, чтобы синтезировать резонанс Fadd9 гитары Rickenbacker, акустики Джона и басового удара Пола!",
            style = MaterialTheme.typography.bodyMedium.copy(
              color = MaterialTheme.colorScheme.onSurface,
              lineHeight = 20.sp
            )
          )

          Spacer(modifier = Modifier.height(14.dp))

          Button(
            onClick = {
              scope.launch {
                currentlyPlayingId = "sound_hard_days_night"
                BeatlesSynthesizer.playSound("sound_hard_days_night")
                currentlyPlayingId = null
              }
            },
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
              .testTag("btn_trigger_opening_chord"),
            colors = ButtonDefaults.buttonColors(
              containerColor = BeatlesGold
            )
          ) {
            Icon(
              imageVector = if (isThisPlaying) Icons.Default.VolumeUp else Icons.Default.PlayArrow,
              contentDescription = null,
              tint = VinylDarkBg
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = if (isThisPlaying) "ЗВУЧИТ АККОРД..." else "УДАРИТЬ ПО СТРУНАМ",
              style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.ExtraBold,
                color = VinylDarkBg,
                letterSpacing = 1.sp
              )
            )
          }
        }
      }
    }

    // Section Title
    item {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.GraphicEq, contentDescription = null, tint = BeatlesTeal)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Коллекция звуков & секретов",
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
          )
        )
      }
    }

    // List of sound presets
    items(soundPresets, key = { it.id }) { preset ->
      val isPlaying = currentlyPlayingId == preset.id
      SoundPresetCard(
        preset = preset,
        isPlaying = isPlaying,
        onPlay = {
          scope.launch {
            currentlyPlayingId = preset.id
            BeatlesSynthesizer.playSound(preset.id)
            currentlyPlayingId = null
          }
        }
      )
    }

    // Studio Inventions Info Block
    item {
      Surface(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(16.dp))
          .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(16.dp)),
        color = MaterialTheme.colorScheme.surface
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "4 Студийных изобретения The Beatles",
            style = MaterialTheme.typography.titleSmall.copy(
              fontWeight = FontWeight.Bold,
              color = BeatlesGold
            )
          )
          Spacer(modifier = Modifier.height(10.dp))
          StudioInventionRow(
            title = "ADT (Artificial Double Tracking)",
            desc = "Изобретено инженером Кеном Таунсендом, чтобы Джону не приходилось дважды перепевать одну и ту же партию для плотности звука."
          )
          Spacer(modifier = Modifier.height(8.dp))
          StudioInventionRow(
            title = "Реверсивные пленки (Backward Loops)",
            desc = "Впервые в рок-истории гитары и тарелки были пущены в обратную сторону на треках «Rain» и «I'm Only Sleeping»."
          )
          Spacer(modifier = Modifier.height(8.dp))
          StudioInventionRow(
            title = "Прямое подключение баса (Direct Injection)",
            desc = "Бас Пола включили прямо в микшерный пульт без микрофона перед колонкой, получив сверхмощный и чистый низкий регистр."
          )
          Spacer(modifier = Modifier.height(8.dp))
          StudioInventionRow(
            title = "Динамик Leslie для человеческого голоса",
            desc = "Вращающийся ротор органа Хаммонда использовали для обработки вокала Джона в «Tomorrow Never Knows»."
          )
        }
      }
    }
  }
}

@Composable
fun SoundPresetCard(
  preset: SoundPreset,
  isPlaying: Boolean,
  onPlay: () -> Unit,
  modifier: Modifier = Modifier
) {
  val icon = when (preset.iconName) {
    "Bolt" -> Icons.Default.Bolt
    "SelfImprovement" -> Icons.Default.SelfImprovement
    "Pets" -> Icons.Default.Pets
    "WaterDrop" -> Icons.Default.WaterDrop
    else -> Icons.Default.MusicNote
  }

  Card(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(14.dp))
      .border(
        width = if (isPlaying) 1.5.dp else 1.dp,
        color = if (isPlaying) BeatlesGold else MaterialTheme.colorScheme.outline,
        shape = RoundedCornerShape(14.dp)
      )
      .clickable { onPlay() }
      .testTag("sound_card_${preset.id}"),
    colors = CardDefaults.cardColors(
      containerColor = if (isPlaying) VinylSurfaceVariant else MaterialTheme.colorScheme.surface
    )
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(46.dp)
          .clip(CircleShape)
          .background(if (isPlaying) BeatlesGold else VinylSurfaceVariant),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = if (isPlaying) Icons.Default.VolumeUp else icon,
          contentDescription = null,
          tint = if (isPlaying) VinylDarkBg else BeatlesGold,
          modifier = Modifier.size(24.dp)
        )
      }

      Spacer(modifier = Modifier.width(14.dp))

      Column(modifier = Modifier.weight(1f)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            text = preset.title,
            style = MaterialTheme.typography.titleSmall.copy(
              fontWeight = FontWeight.Bold,
              color = if (isPlaying) BeatlesGold else MaterialTheme.colorScheme.onSurface
            )
          )
        }
        Text(
          text = preset.subtitle,
          style = MaterialTheme.typography.labelSmall.copy(
            color = BeatlesTeal,
            fontWeight = FontWeight.SemiBold
          )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = preset.description,
          style = MaterialTheme.typography.bodySmall.copy(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 12.sp,
            lineHeight = 16.sp
          )
        )
      }

      Spacer(modifier = Modifier.width(8.dp))

      Box(
        modifier = Modifier
          .size(36.dp)
          .clip(CircleShape)
          .background(if (isPlaying) BeatlesTeal else VinylSurfaceVariant),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.PlayArrow,
          contentDescription = "Воспроизвести",
          tint = if (isPlaying) VinylDarkBg else MaterialTheme.colorScheme.onSurface,
          modifier = Modifier.size(20.dp)
        )
      }
    }
  }
}

@Composable
fun StudioInventionRow(title: String, desc: String) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(VinylSurfaceVariant)
      .padding(10.dp)
  ) {
    Text(
      text = title,
      style = MaterialTheme.typography.labelMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BeatlesTeal
      )
    )
    Spacer(modifier = Modifier.height(2.dp))
    Text(
      text = desc,
      style = MaterialTheme.typography.bodySmall.copy(
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        fontSize = 11.sp,
        lineHeight = 15.sp
      )
    )
  }
}
