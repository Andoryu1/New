package com.example.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.BeatlesGold
import com.example.ui.theme.BeatlesTeal
import com.example.ui.theme.VinylDarkBg
import com.example.ui.theme.VinylSurfaceVariant

@Composable
fun SpinningVinylRecord(
  modifier: Modifier = Modifier,
  size: Dp = 180.dp,
  isPlaying: Boolean = true,
  onClick: (() -> Unit)? = null
) {
  val infiniteTransition = rememberInfiniteTransition(label = "VinylSpin")
  val rotation by infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = 360f,
    animationSpec = infiniteRepeatable(
      animation = tween(durationMillis = if (isPlaying) 3200 else 18000, easing = LinearEasing),
      repeatMode = RepeatMode.Restart
    ),
    label = "VinylRotation"
  )

  Box(
    modifier = modifier
      .size(size)
      .clip(CircleShape)
      .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
      .testTag("spinning_vinyl_record"),
    contentAlignment = Alignment.Center
  ) {
    Canvas(
      modifier = Modifier
        .size(size)
        .rotate(rotation)
    ) {
      val center = Offset(this.size.width / 2f, this.size.height / 2f)
      val radius = this.size.width / 2f

      // Vinyl outer body
      drawCircle(
        color = Color(0xFF14111E),
        radius = radius,
        center = center
      )

      // Sheen / light reflections
      drawCircle(
        brush = Brush.sweepGradient(
          0.0f to Color(0x33FFFFFF),
          0.25f to Color(0x05000000),
          0.5f to Color(0x33FFFFFF),
          0.75f to Color(0x05000000),
          1.0f to Color(0x33FFFFFF),
          center = center
        ),
        radius = radius - 4f,
        center = center
      )

      // Vinyl concentric grooves
      val grooveCount = 7
      for (i in 1..grooveCount) {
        val r = radius * 0.42f + (radius * 0.52f * (i.toFloat() / grooveCount))
        drawCircle(
          color = Color(0x1AFFFFFF),
          radius = r,
          center = center,
          style = Stroke(width = 1.2f)
        )
      }

      // Center yellow label (Apple Records / Yellow Submarine vibe)
      val labelRadius = radius * 0.38f
      drawCircle(
        color = Color(0xFFFFB703),
        radius = labelRadius,
        center = center
      )
      drawCircle(
        color = Color(0xFFFB8500),
        radius = labelRadius,
        center = center,
        style = Stroke(width = 2.5f)
      )

      // Spindle center hole
      drawCircle(
        color = Color(0xFF0F0C1A),
        radius = radius * 0.08f,
        center = center
      )
    }

    // Static center text badge
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "THE",
        style = MaterialTheme.typography.labelSmall.copy(
          fontSize = 8.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF14111E),
          letterSpacing = 2.sp
        )
      )
      Text(
        text = "BEATLES",
        style = MaterialTheme.typography.labelSmall.copy(
          fontSize = 11.sp,
          fontWeight = FontWeight.ExtraBold,
          color = Color(0xFF14111E),
          letterSpacing = 1.sp
        )
      )
    }
  }
}

@Composable
fun AbbeyRoadHeader(
  modifier: Modifier = Modifier
) {
  Surface(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(20.dp))
      .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(20.dp)),
    color = MaterialTheme.colorScheme.surface
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = BeatlesGold,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "FAB FOUR CHRONICLES",
              style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp,
                color = BeatlesGold
              )
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "The Beatles: Невероятное",
            style = MaterialTheme.typography.headlineSmall.copy(
              fontWeight = FontWeight.ExtraBold,
              color = MaterialTheme.colorScheme.onSurface
            )
          )
        }

        SpinningVinylRecord(size = 54.dp, isPlaying = true)
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Stylized Abbey Road Zebra Crossing
      Canvas(
        modifier = Modifier
          .fillMaxWidth()
          .height(28.dp)
          .clip(RoundedCornerShape(6.dp))
          .background(Color(0xFF201A33))
      ) {
        val totalWidth = size.width
        val stripeWidth = totalWidth / 11f
        val gap = stripeWidth * 0.45f
        var currentX = gap

        while (currentX < totalWidth - stripeWidth) {
          drawRoundRect(
            color = Color(0xFFEDE9F5),
            topLeft = Offset(currentX, 4f),
            size = Size(stripeWidth * 0.65f, size.height - 8f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3f, 3f)
          )
          currentX += stripeWidth
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        QuickStatChip(label = "1960–1970", desc = "Золотая эпоха")
        QuickStatChip(label = "13 Альбомов", desc = "Революция звука")
        QuickStatChip(label = "Ливерпуль", desc = "Родина рока")
      }
    }
  }
}

@Composable
fun QuickStatChip(label: String, desc: String) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .clip(RoundedCornerShape(8.dp))
      .background(VinylSurfaceVariant)
      .padding(horizontal = 10.dp, vertical = 6.dp)
  ) {
    Text(
      text = label,
      style = MaterialTheme.typography.labelMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BeatlesTeal
      )
    )
    Text(
      text = desc,
      style = MaterialTheme.typography.labelSmall.copy(
        fontSize = 10.sp,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    )
  }
}
