package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.BeatlesSynthesizer
import com.example.data.BeatlesDataRepository
import com.example.ui.components.SpinningVinylRecord
import com.example.ui.theme.BeatlesCoral
import com.example.ui.theme.BeatlesGold
import com.example.ui.theme.BeatlesTeal
import com.example.ui.theme.VinylDarkBg
import com.example.ui.theme.VinylSurfaceVariant
import kotlinx.coroutines.launch

@Composable
fun QuizScreen(
  modifier: Modifier = Modifier
) {
  val questions = BeatlesDataRepository.quizQuestions
  var currentQuestionIndex by remember { mutableStateOf(0) }
  var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
  var score by remember { mutableStateOf(0) }
  var isQuizFinished by remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

  val currentQuestion = questions.getOrNull(currentQuestionIndex)

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    contentPadding = PaddingValues(top = 16.dp, bottom = 96.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    if (isQuizFinished) {
      item {
        val rankTitle = when {
          score == questions.size -> "👑 Пятый Битл (The 5th Beatle)"
          score >= 6 -> "🎸 Завсегдатай клуба Cavern"
          score >= 3 -> "🚢 Капитан Жёлтой Подлодки"
          else -> "🚶 Случайный прохожий с Abbey Road"
        }
        val rankDesc = when {
          score == questions.size -> "Невероятно! Вы знаете The Beatles лучше, чем звукорежиссеры на Abbey Road. Брайан Эпстайн гордился бы вами!"
          score >= 6 -> "Отличный результат! Вы настоящий ценитель классического рока и рок-н-ролльных историй."
          score >= 3 -> "Хороший старт! Вы точно слышали хиты, но впереди еще столько безумных историй о великолепной четверке!"
          else -> "Похоже, вы только начинаете знакомство с Fab Four. Почитайте факты в соседней вкладке — там полно открытий!"
        }

        Card(
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.5.dp, BeatlesGold, RoundedCornerShape(20.dp))
            .testTag("quiz_result_card"),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Box(
              modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(BeatlesGold.copy(alpha = 0.2f)),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.EmojiEvents,
                contentDescription = null,
                tint = BeatlesGold,
                modifier = Modifier.size(40.dp)
              )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
              text = "Тест Завершён!",
              style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold,
                color = BeatlesTeal,
                letterSpacing = 1.5.sp
              )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = "$score из ${questions.size} верных ответов",
              style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onSurface
              )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
              modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(VinylSurfaceVariant)
                .padding(horizontal = 14.dp, vertical = 6.dp)
            ) {
              Text(
                text = rankTitle,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold,
                  color = BeatlesGold
                )
              )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = rankDesc,
              style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 22.sp
              ),
              modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
              onClick = {
                currentQuestionIndex = 0
                selectedOptionIndex = null
                score = 0
                isQuizFinished = false
              },
              modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("quiz_restart_button"),
              colors = ButtonDefaults.buttonColors(containerColor = BeatlesGold)
            ) {
              Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = null,
                tint = VinylDarkBg
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "Пройти тест снова",
                style = MaterialTheme.typography.labelLarge.copy(
                  fontWeight = FontWeight.Bold,
                  color = VinylDarkBg
                )
              )
            }
          }
        }
      }
    } else if (currentQuestion != null) {
      // Header & Progress
      item {
        Surface(
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(16.dp)),
          color = MaterialTheme.colorScheme.surface
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.HelpOutline,
                  contentDescription = null,
                  tint = BeatlesGold,
                  modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "БИТЛО-ТЕСТ",
                  style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = BeatlesGold,
                    letterSpacing = 1.sp
                  )
                )
              }

              Text(
                text = "Вопрос ${currentQuestionIndex + 1} из ${questions.size}",
                style = MaterialTheme.typography.labelSmall.copy(
                  color = BeatlesTeal,
                  fontWeight = FontWeight.Bold
                )
              )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
              progress = { (currentQuestionIndex.toFloat() + 1) / questions.size },
              modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp)),
              color = BeatlesGold,
              trackColor = VinylSurfaceVariant
            )
          }
        }
      }

      // Question Card
      item {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(18.dp)),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(18.dp)
          ) {
            Text(
              text = currentQuestion.questionRu,
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 24.sp
              )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Options
            currentQuestion.optionsRu.forEachIndexed { index, optionText ->
              val isSelected = selectedOptionIndex == index
              val isAnswered = selectedOptionIndex != null
              val isCorrect = index == currentQuestion.correctOptionIndex

              val backgroundColor = when {
                !isAnswered -> VinylSurfaceVariant
                isCorrect -> BeatlesTeal.copy(alpha = 0.25f)
                isSelected -> BeatlesCoral.copy(alpha = 0.25f)
                else -> VinylSurfaceVariant.copy(alpha = 0.5f)
              }

              val borderColor = when {
                !isAnswered -> if (isSelected) BeatlesGold else MaterialTheme.colorScheme.outline
                isCorrect -> BeatlesTeal
                isSelected -> BeatlesCoral
                else -> MaterialTheme.colorScheme.outline
              }

              Box(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 4.dp)
                  .clip(RoundedCornerShape(12.dp))
                  .background(backgroundColor)
                  .border(1.2.dp, borderColor, RoundedCornerShape(12.dp))
                  .clickable(enabled = !isAnswered) {
                    selectedOptionIndex = index
                    if (index == currentQuestion.correctOptionIndex) {
                      score++
                      scope.launch {
                        BeatlesSynthesizer.playSound("sound_hard_days_night")
                      }
                    }
                  }
                  .padding(14.dp)
                  .testTag("quiz_option_$index")
              ) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Box(
                    modifier = Modifier
                      .size(28.dp)
                      .clip(CircleShape)
                      .background(
                        when {
                          !isAnswered -> MaterialTheme.colorScheme.surface
                          isCorrect -> BeatlesTeal
                          isSelected -> BeatlesCoral
                          else -> MaterialTheme.colorScheme.surface
                        }
                      ),
                    contentAlignment = Alignment.Center
                  ) {
                    if (isAnswered) {
                      if (isCorrect) {
                        Icon(
                          imageVector = Icons.Default.CheckCircle,
                          contentDescription = null,
                          tint = VinylDarkBg,
                          modifier = Modifier.size(18.dp)
                        )
                      } else if (isSelected) {
                        Icon(
                          imageVector = Icons.Default.Close,
                          contentDescription = null,
                          tint = Color.White,
                          modifier = Modifier.size(18.dp)
                        )
                      } else {
                        Text(
                          text = "${'A' + index}",
                          style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                          )
                        )
                      }
                    } else {
                      Text(
                        text = "${'A' + index}",
                        style = MaterialTheme.typography.labelSmall.copy(
                          fontWeight = FontWeight.Bold,
                          color = BeatlesGold
                        )
                      )
                    }
                  }

                  Spacer(modifier = Modifier.width(12.dp))

                  Text(
                    text = optionText,
                    style = MaterialTheme.typography.bodyMedium.copy(
                      fontWeight = if (isSelected || (isAnswered && isCorrect)) FontWeight.Bold else FontWeight.Normal,
                      color = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.weight(1f)
                  )
                }
              }
            }

            // Explanation & Next Button
            AnimatedVisibility(visible = selectedOptionIndex != null) {
              Column(modifier = Modifier.padding(top = 14.dp)) {
                Box(
                  modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(VinylSurfaceVariant)
                    .padding(12.dp)
                ) {
                  Column {
                    Text(
                      text = if (selectedOptionIndex == currentQuestion.correctOptionIndex) "Верно! 🎉" else "Не совсем так...",
                      style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = if (selectedOptionIndex == currentQuestion.correctOptionIndex) BeatlesTeal else BeatlesCoral
                      )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = currentQuestion.explanationRu,
                      style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 18.sp
                      )
                    )
                  }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                  onClick = {
                    if (currentQuestionIndex + 1 < questions.size) {
                      currentQuestionIndex++
                      selectedOptionIndex = null
                    } else {
                      isQuizFinished = true
                    }
                  },
                  modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("quiz_next_button"),
                  colors = ButtonDefaults.buttonColors(containerColor = BeatlesGold)
                ) {
                  Text(
                    text = if (currentQuestionIndex + 1 < questions.size) "Следующий вопрос" else "Узнать результат",
                    style = MaterialTheme.typography.labelLarge.copy(
                      fontWeight = FontWeight.Bold,
                      color = VinylDarkBg
                    )
                  )
                }
              }
            }
          }
        }
      }
    }
  }
}
