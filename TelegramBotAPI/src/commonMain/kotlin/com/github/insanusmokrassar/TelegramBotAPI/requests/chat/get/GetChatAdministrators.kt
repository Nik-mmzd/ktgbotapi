package com.github.insanusmokrassar.TelegramBotAPI.requests.chat.get

import com.github.insanusmokrassar.TelegramBotAPI.CommonAbstracts.types.ChatRequest
import com.github.insanusmokrassar.TelegramBotAPI.bot.RequestsExecutor
import com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts.SimpleRequest
import com.github.insanusmokrassar.TelegramBotAPI.types.ChatIdentifier
import com.github.insanusmokrassar.TelegramBotAPI.types.ChatMember.abstracts.AdministratorChatMember
import com.github.insanusmokrassar.TelegramBotAPI.types.ChatMember.abstracts.AdministratorChatMemberSerializerWithoutDeserialization
import com.github.insanusmokrassar.TelegramBotAPI.types.chat.abstracts.PublicChat
import com.github.insanusmokrassar.TelegramBotAPI.types.chatIdField
import kotlinx.serialization.*
import kotlinx.serialization.internal.ArrayListSerializer

private val chatMembersListSerializer = ArrayListSerializer(
    AdministratorChatMemberSerializerWithoutDeserialization
)

@Serializable
data class GetChatAdministrators(
    @SerialName(chatIdField)
    override val chatId: ChatIdentifier
): ChatRequest, SimpleRequest<List<AdministratorChatMember>> {
    override fun method(): String = "getChatAdministrators"
    override val resultDeserializer: DeserializationStrategy<List<AdministratorChatMember>>
        get() = chatMembersListSerializer
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()
}

suspend fun RequestsExecutor.getChatAdministrators(
    chatId: ChatIdentifier
) = execute(GetChatAdministrators(chatId))

suspend fun RequestsExecutor.getChatAdministrators(
    chat: PublicChat
) = getChatAdministrators(chat.id)