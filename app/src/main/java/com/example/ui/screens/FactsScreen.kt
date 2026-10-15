package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.BeatlesSynthesizer
import com.example.data.BeatlesDataRepository
import com.example.model.BeatlesFact
import com.example.model.FactCategory
import com.example.ui.components.AbbeyRoadHeader
import com.example.ui.components.FactCard
import com.example.ui.components.SpinningVinylRecord
import com.example.ui.theme.BeatlesGold
import com.example.ui.theme.BeatlesTeal
import com.example.ui.theme.VinylDarkBg
import com.example.ui.theme.VinylSurfaceVariant
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactsScreen(
  bookmarkedIds: Set<String>,
  onToggleBookmark: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  var selectedCategory by remember { mutableStateOf<FactCategory?>(null) }
  var showOnlyBookmarks by remember { mutableStateOf(false) }
  var searchQuery by remember { mutableStateOf("") }
  var randomFactDialog by remember { mutableStateOf<BeatlesFact?>(null) }
  val scope = rememberCoroutineScope()

  val allFacts = BeatlesDataRepository.facts

  val filteredFacts = allFacts.filter { fact ->
    val matchesCategory = if (showOnlyBookmarks) {
      bookmarkedIds.contains(fact.id)
    } else {
      selectedCategory == null || fact.category == selectedCategory
    }
    val matchesSearch = searchQuery.isBlank() ||
      fact.title.contains(searchQuery, ignoreCase = true) ||
      fact.summary.contains(searchQuery, ignoreCase = true) ||
      fact.fullStory.contains(searchQuery, ignoreCase = true) ||
      fact.coolTag.contains(searchQuery, ignoreCase = true)

    matchesCategory && matchesSearch
  }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    contentPadding = PaddingValues(top = 16.dp, bottom = 96.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // Abbey Road Header & Intro
    item {
      AbbeyRoadHeader()
    }

    // Random Fact Generator Card (Vinyl Fortune Teller)
    item {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(16.dp))
          .background(
            androidx.compose.ui.graphics.Brush.horizontalGradient(
              listOf(
                ColorHex(0xFF2B1A42),
                ColorHex(0xFF1E152F)
              )
            )
          )
          .border(1.dp, BeatlesGold.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
          .clickable {
            scope.launch {
              BeatlesSynthesizer.playSound("sound_hard_days_night")
            }
            val random = allFacts.random()
            randomFactDialog = random
          }
          .padding(16.dp)
          .testTag("random_fact_button")
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.Casino,
                contentDescription = null,
                tint = BeatlesGold,
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "РУЛЕТКА СУДЬБЫ",
                style = MaterialTheme.typography.labelSmall.copy(
                  fontWeight = FontWeight.Bold,
                  color = BeatlesGold,
                  letterSpacing = 1.sp
                )
              )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "Встряхни винил для убойного факта!",
              style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
              )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "Жми сюда: услышишь аккорд и узнаешь дикую тайну",
              style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
              )
            )
          }

          Spacer(modifier = Modifier.width(12.dp))

          SpinningVinylRecord(size = 56.dp, isPlaying = true)
        }
      }
    }

    // Search bar
    item {
      OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text("Поиск по фактам, песням и курьёзам...") },
        leadingIcon = {
          Icon(Icons.Default.Search, contentDescription = null, tint = BeatlesGold)
        },
        trailingIcon = {
          if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { searchQuery = "" }) {
              Icon(Icons.Default.Clear, contentDescription = "Очистить")
            }
          }
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
          focusedContainerColor = MaterialTheme.colorScheme.surface,
          unfocusedContainerColor = MaterialTheme.colorScheme.surface,
          focusedBorderColor = BeatlesGold,
          unfocusedBorderColor = MaterialTheme.colorScheme.outline
        ),
        modifier = Modifier
          .fillMaxWidth()
          .testTag("search_facts_input")
      )
    }

    // Category Chips
    item {
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
      ) {
        item {
          FilterChip(
            selected = selectedCategory == null && !showOnlyBookmarks,
            onClick = {
              selectedCategory = null
              showOnlyBookmarks = false
            },
            label = { Text("Все истории") },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = BeatlesGold,
              selectedLabelColor = VinylDarkBg
            ),
            modifier = Modifier.testTag("filter_all")
          )
        }

        item {
          FilterChip(
            selected = showOnlyBookmarks,
            onClick = {
              showOnlyBookmarks = !showOnlyBookmarks
              if (showOnlyBookmarks) selectedCategory = null
            },
            leadingIcon = {
              Icon(
                Icons.Default.Bookmark,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
              )
            },
            label = { Text("Закладки (${bookmarkedIds.size})") },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = BeatlesTeal,
              selectedLabelColor = VinylDarkBg
            ),
            modifier = Modifier.testTag("filter_bookmarks")
          )
        }

        items(FactCategory.values().filter { it != FactCategory.ALL }) { cat ->
          FilterChip(
            selected = selectedCategory == cat && !showOnlyBookmarks,
            onClick = {
              selectedCategory = if (selectedCategory == cat) null else cat
              showOnlyBookmarks = false
            },
            label = { Text(cat.titleRu) },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = BeatlesGold,
              selectedLabelColor = VinylDarkBg
            ),
            modifier = Modifier.testTag("filter_${cat.name.lowercase()}")
          )
        }
      }
    }

    // Facts list
    if (filteredFacts.isEmpty()) {
      item {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(VinylSurfaceVariant)
            .padding(32.dp),
          contentAlignment = Alignment.Center
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
              imageVector = Icons.Default.Search,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.onSurfaceVariant,
              modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "Ничего не найдено",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
              )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "Попробуйте изменить запрос или категорию",
              style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            )
          }
        }
      }
    } else {
      items(filteredFacts, key = { it.id }) { fact ->
        FactCard(
          fact = fact,
          isBookmarked = bookmarkedIds.contains(fact.id),
          onToggleBookmark = onToggleBookmark
        )
      }
    }
  }

  // Random Fact Dialog Popup
  if (randomFactDialog != null) {
    val fact = randomFactDialog!!
    AlertDialog(
      onDismissRequest = { randomFactDialog = null },
      containerColor = MaterialTheme.colorScheme.surface,
      title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = BeatlesGold)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Случайный Факт!",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
          )
        }
      },
      text = {
        Column {
          Text(
            text = fact.title,
            style = MaterialTheme.typography.titleSmall.copy(
              fontWeight = FontWeight.Bold,
              color = BeatlesGold
            )
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = fact.fullStory,
            style = MaterialTheme.typography.bodyMedium.copy(
              color = MaterialTheme.colorScheme.onSurface,
              lineHeight = 22.sp
            )
          )
        }
      },
      confirmButton = {
        Button(
          onClick = {
            scope.launch {
              BeatlesSynthesizer.playSound("sound_hard_days_night")
            }
            randomFactDialog = allFacts.random()
          },
          colors = ButtonDefaults.buttonColors(containerColor = BeatlesGold)
        ) {
          Text("Ещё один!", color = VinylDarkBg, fontWeight = FontWeight.Bold)
        }
      },
      dismissButton = {
        TextButton(onClick = { randomFactDialog = null }) {
          Text("Закрыть", color = MaterialTheme.colorScheme.onSurface)
        }
      }
    )
  }
}

private fun ColorHex(hex: Long): androidx.compose.ui.graphics.Color {
  return androidx.compose.ui.graphics.Color(hex)
}
