package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.GraphicEq
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.screens.AlbumsScreen
import com.example.ui.screens.FactsScreen
import com.example.ui.screens.MembersScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.screens.StudioScreen
import com.example.ui.theme.BeatlesGold
import com.example.ui.theme.BeatlesTeal
import com.example.ui.theme.VinylDarkBg
import com.example.ui.theme.VinylSurface

enum class BeatlesNavDestination(
  val labelRu: String,
  val filledIcon: androidx.compose.ui.graphics.vector.ImageVector,
  val outlinedIcon: androidx.compose.ui.graphics.vector.ImageVector,
  val tag: String
) {
  FACTS("Факты", Icons.Filled.Lightbulb, Icons.Outlined.Lightbulb, "nav_tab_facts"),
  STUDIO("Студия", Icons.Filled.GraphicEq, Icons.Outlined.GraphicEq, "nav_tab_studio"),
  ALBUMS("Альбомы", Icons.Filled.Album, Icons.Outlined.Album, "nav_tab_albums"),
  MEMBERS("Четвёрка", Icons.Filled.Group, Icons.Outlined.Group, "nav_tab_members"),
  QUIZ("Тест", Icons.Filled.HelpOutline, Icons.Outlined.HelpOutline, "nav_tab_quiz")
}

@Composable
fun BeatlesMainApp() {
  var currentDestination by remember { mutableStateOf(BeatlesNavDestination.FACTS) }
  var bookmarkedFactIds by remember { mutableStateOf(setOf<String>()) }

  // Handle system back gesture
  BackHandler(enabled = currentDestination != BeatlesNavDestination.FACTS) {
    currentDestination = BeatlesNavDestination.FACTS
  }

  Scaffold(
    modifier = Modifier
      .fillMaxSize()
      .background(VinylDarkBg),
    contentWindowInsets = WindowInsets.safeDrawing,
    bottomBar = {
      NavigationBar(
        modifier = Modifier
          .windowInsetsPadding(WindowInsets.navigationBars)
          .testTag("beatles_bottom_nav"),
        containerColor = VinylSurface,
        tonalElevation = 8.dp
      ) {
        BeatlesNavDestination.values().forEach { destination ->
          val isSelected = currentDestination == destination
          NavigationBarItem(
            selected = isSelected,
            onClick = { currentDestination = destination },
            icon = {
              Icon(
                imageVector = if (isSelected) destination.filledIcon else destination.outlinedIcon,
                contentDescription = destination.labelRu
              )
            },
            label = {
              Text(
                text = destination.labelRu,
                style = MaterialTheme.typography.labelSmall.copy(
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
              )
            },
            colors = NavigationBarItemDefaults.colors(
              selectedIconColor = VinylDarkBg,
              selectedTextColor = BeatlesGold,
              indicatorColor = BeatlesGold,
              unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
              unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier.testTag(destination.tag)
          )
        }
      }
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      Crossfade(
        targetState = currentDestination,
        label = "ScreenTransition"
      ) { dest ->
        when (dest) {
          BeatlesNavDestination.FACTS -> FactsScreen(
            bookmarkedIds = bookmarkedFactIds,
            onToggleBookmark = { id ->
              bookmarkedFactIds = if (bookmarkedFactIds.contains(id)) {
                bookmarkedFactIds - id
              } else {
                bookmarkedFactIds + id
              }
            }
          )
          BeatlesNavDestination.STUDIO -> StudioScreen()
          BeatlesNavDestination.ALBUMS -> AlbumsScreen()
          BeatlesNavDestination.MEMBERS -> MembersScreen()
          BeatlesNavDestination.QUIZ -> QuizScreen()
        }
      }
    }
  }
}
