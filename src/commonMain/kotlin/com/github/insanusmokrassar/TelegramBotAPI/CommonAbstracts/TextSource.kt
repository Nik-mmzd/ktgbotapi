package com.github.insanusmokrassar.TelegramBotAPI.CommonAbstracts

interface TextSource {
    val asMarkdownSource: String
    val asMarkdownV2Source: String
    val asHtmlSource: String
}


interface MultilevelTextSource : TextSource {
    val textParts: List<TextPart>
}

data class TextPart(
    val range: IntRange,
    val source: TextSource
)