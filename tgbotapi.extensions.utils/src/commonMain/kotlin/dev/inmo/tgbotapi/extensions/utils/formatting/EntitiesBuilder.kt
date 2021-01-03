@file:Suppress("NOTHING_TO_INLINE", "unused")

package dev.inmo.tgbotapi.extensions.utils.formatting

import dev.inmo.tgbotapi.CommonAbstracts.TextSource
import dev.inmo.tgbotapi.types.User

fun buildEntities(init: EntitiesBuilder.() -> Unit): List<TextSource> = EntitiesBuilder().apply(init).build()

/**
 * This builder can be used to provide building of [TextSource]s [List]
 *
 * @see buildEntities
 */
class EntitiesBuilder internal constructor(
    private val entitiesList: MutableList<TextSource> = mutableListOf()
) {
    /**
     * It is not safe field which contains potentially changeable [List]
     */
    val entities: List<TextSource>
        get() = entitiesList

    /**
     * @return New immutable list which will be deattached from this builder
     */
    fun build(): List<TextSource> = entities.toList()

    fun add(source: TextSource) { entitiesList.add(source) }

    operator fun TextSource.unaryPlus() = add(this)
    operator fun List<TextSource>.unaryPlus() = entitiesList.addAll(this)
    operator fun invoke(vararg source: TextSource) = entitiesList.addAll(source)

    operator fun String.unaryPlus() {
        add(dev.inmo.tgbotapi.types.MessageEntity.textsources.regular(this))
    }
}

inline fun EntitiesBuilder.bold(parts: List<TextSource>) = add(dev.inmo.tgbotapi.types.MessageEntity.textsources.bold(parts))

inline fun EntitiesBuilder.bold(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.bold(*parts))

inline fun EntitiesBuilder.bold(text: String) = add(dev.inmo.tgbotapi.types.MessageEntity.textsources.bold(text))

inline fun EntitiesBuilder.botCommand(command: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.botCommand(command))

inline fun EntitiesBuilder.cashTag(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.cashTag(parts))

inline fun EntitiesBuilder.cashTag(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.cashTag(*parts))

inline fun EntitiesBuilder.cashTag(text: String) = add(dev.inmo.tgbotapi.types.MessageEntity.textsources.cashTag(text))

inline fun EntitiesBuilder.code(code: String) = add(dev.inmo.tgbotapi.types.MessageEntity.textsources.code(code))

inline fun EntitiesBuilder.email(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.email(parts))

inline fun EntitiesBuilder.email(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.email(*parts))

inline fun EntitiesBuilder.email(emailAddress: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.email(emailAddress))

inline fun EntitiesBuilder.hashtag(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.hashtag(parts))

inline fun EntitiesBuilder.hashtag(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.hashtag(*parts))

inline fun EntitiesBuilder.hashtag(hashtag: String) = add(dev.inmo.tgbotapi.types.MessageEntity.textsources.hashtag(hashtag))

inline fun EntitiesBuilder.italic(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.italic(parts))

inline fun EntitiesBuilder.italic(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.italic(*parts))

inline fun EntitiesBuilder.italic(text: String) = add(dev.inmo.tgbotapi.types.MessageEntity.textsources.italic(text))

inline fun EntitiesBuilder.mention(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.mention(parts))

inline fun EntitiesBuilder.mention(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.mention(*parts))

inline fun EntitiesBuilder.mention(whoToMention: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.mention(whoToMention))

inline fun EntitiesBuilder.mention(parts: List<TextSource>, user: User) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.mention(parts, user))

inline fun EntitiesBuilder.mention(user: User, vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.mention(user, *parts))

inline fun EntitiesBuilder.mention(text: String, user: User) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.mention(text, user))

inline fun EntitiesBuilder.phone(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.phone(parts))

inline fun EntitiesBuilder.phone(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.phone(*parts))

inline fun EntitiesBuilder.phone(number: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.phone(number))

inline fun EntitiesBuilder.pre(code: String, language: String?) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.pre(code, language))

inline fun EntitiesBuilder.regular(text: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.regular(text))

inline fun EntitiesBuilder.strikethrough(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.strikethrough(parts))

inline fun EntitiesBuilder.strikethrough(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.strikethrough(*parts))

inline fun EntitiesBuilder.strikethrough(text: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.strikethrough(text))

inline fun EntitiesBuilder.link(text: String, url: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.link(text, url))

inline fun EntitiesBuilder.link(url: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.link(url))

inline fun EntitiesBuilder.underline(parts: List<TextSource>) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.underline(parts))

inline fun EntitiesBuilder.underline(vararg parts: TextSource) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.underline(*parts))

inline fun EntitiesBuilder.underline(text: String) =
    add(dev.inmo.tgbotapi.types.MessageEntity.textsources.underline(text))