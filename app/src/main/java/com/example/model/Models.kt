package com.example.model

enum class FactCategory(val titleRu: String, val iconName: String) {
  ALL("Все", "Stars"),
  STUDIO("Студия и Звук", "MusicNote"),
  SCANDAL("Курьёзы и Скандалы", "FlashOn"),
  SECRETS("Тайные послания", "Search"),
  FAB_FOUR("Личности", "Group"),
  LIFESTYLE("Эпоха 60-х", "LocalFireDepartment")
}

data class BeatlesFact(
  val id: String,
  val title: String,
  val category: FactCategory,
  val summary: String,
  val fullStory: String,
  val year: String,
  val quote: String? = null,
  val quoteAuthor: String? = null,
  val coolTag: String = "Топ Факт"
)

data class BeatlesAlbum(
  val id: String,
  val title: String,
  val year: Int,
  val recordedAt: String,
  val descriptionRu: String,
  val innovationRu: String,
  val secretFactRu: String,
  val primaryColorHex: Long,
  val secondaryColorHex: Long,
  val keyTracks: List<String>
)

data class BeatlesMember(
  val id: String,
  val name: String,
  val nicknameRu: String,
  val roleRu: String,
  val instrumentsRu: String,
  val bioHighlightRu: String,
  val quirkyFactRu: String,
  val famousQuoteRu: String,
  val iconBadge: String,
  val signatureColorHex: Long
)

data class QuizQuestion(
  val id: Int,
  val questionRu: String,
  val optionsRu: List<String>,
  val correctOptionIndex: Int,
  val explanationRu: String
)

data class SoundPreset(
  val id: String,
  val title: String,
  val subtitle: String,
  val description: String,
  val iconName: String,
  val durationMs: Int
)
