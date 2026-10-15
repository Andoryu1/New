package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
  primary = BeatlesGold,
  onPrimary = VinylDarkBg,
  primaryContainer = BeatlesGoldDark,
  onPrimaryContainer = TextPrimaryDark,
  secondary = BeatlesTeal,
  onSecondary = VinylDarkBg,
  secondaryContainer = VinylSurfaceVariant,
  onSecondaryContainer = BeatlesTeal,
  tertiary = BeatlesCoral,
  onTertiary = TextPrimaryDark,
  background = VinylDarkBg,
  onBackground = TextPrimaryDark,
  surface = VinylSurface,
  onSurface = TextPrimaryDark,
  surfaceVariant = VinylSurfaceVariant,
  onSurfaceVariant = TextSecondaryDark,
  outline = VinylCardBorder
)

private val LightColorScheme = lightColorScheme(
  primary = BeatlesGoldDark,
  onPrimary = RetroPaperSurface,
  secondary = BeatlesBlue,
  onSecondary = RetroPaperSurface,
  tertiary = BeatlesCoral,
  onTertiary = RetroPaperSurface,
  background = RetroPaperBg,
  onBackground = RetroTextPrimary,
  surface = RetroPaperSurface,
  onSurface = RetroTextPrimary,
  surfaceVariant = RetroPaperSurfaceVariant,
  onSurfaceVariant = RetroTextSecondary,
  outline = BeatlesGoldDark.copy(alpha = 0.3f)
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = true, // Default to stunning vinyl dark theme
  dynamicColor: Boolean = false, // Keep distinct Beatles aesthetic
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}
