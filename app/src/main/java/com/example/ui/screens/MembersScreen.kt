package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BeatlesDataRepository
import com.example.model.BeatlesMember
import com.example.ui.components.SpinningVinylRecord
import com.example.ui.theme.BeatlesGold
import com.example.ui.theme.BeatlesTeal
import com.example.ui.theme.VinylSurfaceVariant

@Composable
fun MembersScreen(
  modifier: Modifier = Modifier
) {
  val members = BeatlesDataRepository.members

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    contentPadding = PaddingValues(top = 16.dp, bottom = 96.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
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
                text = "THE FAB FOUR",
                style = MaterialTheme.typography.labelSmall.copy(
                  fontWeight = FontWeight.Bold,
                  letterSpacing = 1.5.sp,
                  color = BeatlesGold
                )
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "Великолепная Четвёрка",
                style = MaterialTheme.typography.headlineSmall.copy(
                  fontWeight = FontWeight.ExtraBold,
                  color = MaterialTheme.colorScheme.onSurface
                )
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "Характеры, причуды, любимые гитары и знаменитые остроты каждого из легенд.",
                style = MaterialTheme.typography.bodySmall.copy(
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              )
            }

            Spacer(modifier = Modifier.width(12.dp))

            SpinningVinylRecord(size = 56.dp, isPlaying = true)
          }
        }
      }
    }

    items(members, key = { it.id }) { member ->
      MemberCard(member = member)
    }
  }
}

@Composable
fun MemberCard(
  member: BeatlesMember,
  modifier: Modifier = Modifier
) {
  val signatureColor = Color(member.signatureColorHex)

  Card(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(18.dp))
      .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(18.dp))
      .testTag("member_card_${member.id}"),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surface
    )
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      // Header: Avatar badge and Name
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(54.dp)
            .clip(CircleShape)
            .background(signatureColor.copy(alpha = 0.2f))
            .border(2.dp, signatureColor, CircleShape),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = member.iconBadge,
            style = MaterialTheme.typography.headlineSmall
          )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column {
          Text(
            text = member.name,
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.ExtraBold,
              color = MaterialTheme.colorScheme.onSurface
            )
          )
          Text(
            text = member.nicknameRu,
            style = MaterialTheme.typography.labelSmall.copy(
              color = signatureColor,
              fontWeight = FontWeight.Bold
            )
          )
          Text(
            text = member.roleRu,
            style = MaterialTheme.typography.bodySmall.copy(
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              fontSize = 11.sp
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Instruments
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(8.dp))
          .background(VinylSurfaceVariant)
          .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "Инструменты: ",
          style = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Bold,
            color = BeatlesGold
          )
        )
        Text(
          text = member.instrumentsRu,
          style = MaterialTheme.typography.bodySmall.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 11.sp
          )
        )
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Bio highlight
      Text(
        text = member.bioHighlightRu,
        style = MaterialTheme.typography.bodyMedium.copy(
          color = MaterialTheme.colorScheme.onSurface,
          lineHeight = 20.sp
        )
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Quirky Fact
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(10.dp))
          .background(signatureColor.copy(alpha = 0.08f))
          .border(1.dp, signatureColor.copy(alpha = 0.25f), RoundedCornerShape(10.dp))
          .padding(12.dp)
      ) {
        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = signatureColor,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Любопытная причуда",
              style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Bold,
                color = signatureColor
              )
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = member.quirkyFactRu,
            style = MaterialTheme.typography.bodySmall.copy(
              color = MaterialTheme.colorScheme.onSurface,
              lineHeight = 18.sp
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Famous Quote
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(8.dp))
          .background(VinylSurfaceVariant)
          .padding(10.dp),
        verticalAlignment = Alignment.Top
      ) {
        Icon(
          imageVector = Icons.Default.FormatQuote,
          contentDescription = null,
          tint = signatureColor,
          modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
          text = "«${member.famousQuoteRu}»",
          style = MaterialTheme.typography.bodySmall.copy(
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 12.sp,
            lineHeight = 16.sp
          )
        )
      }
    }
  }
}
