package dev.inmo.tgbotapi.extensions.api.send.media

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.abstracts.InputFile
import dev.inmo.tgbotapi.requests.send.media.SendSticker
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.business_connection.BusinessConnectionId
import dev.inmo.tgbotapi.types.buttons.KeyboardMarkup
import dev.inmo.tgbotapi.types.chat.Chat
import dev.inmo.tgbotapi.types.files.Sticker
import dev.inmo.tgbotapi.types.message.abstracts.ContentMessage
import dev.inmo.tgbotapi.types.message.content.StickerContent

/**
 * @param replyMarkup Some of [KeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.replyKeyboard] or
 * [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard] as a builders for that param
 */
public suspend fun TelegramBot.sendSticker(
    chatId: ChatIdentifier,
    sticker: InputFile,
    threadId: MessageThreadId? = chatId.threadId,
    businessConnectionId: BusinessConnectionId? = chatId.businessConnectionId,
    emoji: String? = null,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    effectId: EffectId? = null,
    replyParameters: ReplyParameters? = null,
    replyMarkup: KeyboardMarkup? = null
): ContentMessage<StickerContent> = execute(
    SendSticker(chatId, sticker, threadId, businessConnectionId, emoji, disableNotification, protectContent, effectId, replyParameters, replyMarkup)
)

/**
 * @param replyMarkup Some of [KeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.replyKeyboard] or
 * [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard] as a builders for that param
 */
public suspend fun TelegramBot.sendSticker(
    chat: Chat,
    sticker: InputFile,
    threadId: MessageThreadId? = chat.id.threadId,
    businessConnectionId: BusinessConnectionId? = chat.id.businessConnectionId,
    emoji: String? = null,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    effectId: EffectId? = null,
    replyParameters: ReplyParameters? = null,
    replyMarkup: KeyboardMarkup? = null
): ContentMessage<StickerContent> = sendSticker(chat.id, sticker, threadId, businessConnectionId, emoji, disableNotification, protectContent, effectId, replyParameters, replyMarkup)

/**
 * @param replyMarkup Some of [KeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.replyKeyboard] or
 * [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard] as a builders for that param
 */
public suspend fun TelegramBot.sendSticker(
    chatId: ChatIdentifier,
    sticker: Sticker,
    threadId: MessageThreadId? = chatId.threadId,
    businessConnectionId: BusinessConnectionId? = chatId.businessConnectionId,
    emoji: String? = null,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    effectId: EffectId? = null,
    replyParameters: ReplyParameters? = null,
    replyMarkup: KeyboardMarkup? = null
): ContentMessage<StickerContent> = sendSticker(chatId, sticker.fileId, threadId, businessConnectionId, emoji, disableNotification, protectContent, effectId, replyParameters, replyMarkup)

/**
 * @param replyMarkup Some of [KeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.replyKeyboard] or
 * [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard] as a builders for that param
 */
public suspend fun TelegramBot.sendSticker(
    chat: Chat,
    sticker: Sticker,
    threadId: MessageThreadId? = chat.id.threadId,
    businessConnectionId: BusinessConnectionId? = chat.id.businessConnectionId,
    emoji: String? = null,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    effectId: EffectId? = null,
    replyParameters: ReplyParameters? = null,
    replyMarkup: KeyboardMarkup? = null
): ContentMessage<StickerContent> = sendSticker(chat, sticker.fileId, threadId, businessConnectionId, emoji, disableNotification, protectContent, effectId, replyParameters, replyMarkup)
