package dev.inmo.tgbotapi.requests.bot

import dev.inmo.tgbotapi.CommonAbstracts.WithOptionalLanguageCode
import dev.inmo.tgbotapi.requests.abstracts.SimpleRequest
import dev.inmo.tgbotapi.types.commands.BotCommandScope

sealed interface MyCommandsRequest<T : Any> : SimpleRequest<T>, WithOptionalLanguageCode {
    val scope: BotCommandScope
}
