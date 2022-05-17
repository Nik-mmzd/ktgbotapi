package dev.inmo.tgbotapi.types.chat

import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.chat.ExtendedChat
import dev.inmo.tgbotapi.types.message.abstracts.Message
import dev.inmo.tgbotapi.types.message.abstracts.TelegramBotAPIMessageDeserializeOnlySerializer
import kotlinx.serialization.Serializable

@Serializable(ExtendedChatSerializer::class)
sealed interface ExtendedChannelChat : ChannelChat, ExtendedPublicChat {
    val linkedGroupChatId: ChatId?
}

@Serializable(ExtendedChatSerializer::class)
sealed interface ExtendedGroupChat : GroupChat, ExtendedPublicChat {
    val permissions: ChatPermissions
}

@Serializable(ExtendedChatSerializer::class)
sealed interface ExtendedPrivateChat : PrivateChat, ExtendedChat {
    val bio: String
    val hasPrivateForwards: Boolean

    val allowCreateUserIdLink: Boolean
        get() = hasPrivateForwards
}

sealed interface ExtendedPublicChat : ExtendedChat, PublicChat {
    val description: String
    val inviteLink: String?
    @Serializable(TelegramBotAPIMessageDeserializeOnlySerializer::class)
    val pinnedMessage: Message?
}

@Serializable(ExtendedChatSerializer::class)
sealed interface ExtendedSupergroupChat : SupergroupChat, ExtendedGroupChat {
    val slowModeDelay: Long?
    val stickerSetName: StickerSetName?
    val canSetStickerSet: Boolean
    val linkedChannelChatId: ChatId?
    val location: ChatLocation?
}

@Serializable(ExtendedChatSerializer::class)
sealed interface ExtendedChat : Chat {
    val chatPhoto: ChatPhoto?
}