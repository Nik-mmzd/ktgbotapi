@file:Suppress("NOTHING_TO_INLINE", "unused")

package dev.inmo.tgbotapi.extensions.utils.shortcuts

import dev.inmo.tgbotapi.types.message.ChannelEventMessage
import dev.inmo.tgbotapi.types.message.ChatEvents.*
import dev.inmo.tgbotapi.types.message.ChatEvents.abstracts.*
import dev.inmo.tgbotapi.types.message.abstracts.*
import dev.inmo.tgbotapi.updateshandlers.FlowsUpdatesFilter
import dev.inmo.tgbotapi.utils.RiskFeature
import kotlinx.coroutines.flow.*

@RiskFeature("Use with caution")
inline fun FlowsUpdatesFilter.channelEvents(): Flow<ChannelEventMessage<*>> = channelPostFlow.mapNotNull {
    it.data as? ChannelEventMessage<*>
}

@RiskFeature("Use with caution")
inline fun <reified T: GroupEventMessage<*>> FlowsUpdatesFilter.groupEvents(): Flow<T> = messageFlow.mapNotNull {
    it.data as? T
}

@RiskFeature("Use with caution")
inline fun <reified T: ChatEvent, reified O: ChatEventMessage<T>> Flow<ChatEventMessage<*>>.filterByChatEvent(): Flow<O> = mapNotNull {
    if (it.chatEvent is T) {
        it as? O
    } else {
        null
    }
}

@RiskFeature("Use with caution")
inline fun <reified T : ChannelEvent> Flow<ChatEventMessage<*>>.channelEvents() = filterByChatEvent<T, ChannelEventMessage<T>>()
inline fun Flow<ChatEventMessage<*>>.channelCreatedEvents() = channelEvents<ChannelChatCreated>()
inline fun Flow<ChatEventMessage<*>>.deletedChannelPhotoEvents() = channelEvents<DeleteChatPhoto>()
inline fun Flow<ChatEventMessage<*>>.newChannelPhotoEvents() = channelEvents<NewChatPhoto>()
inline fun Flow<ChatEventMessage<*>>.newChannelTitleEvents() = channelEvents<NewChatTitle>()
inline fun Flow<ChatEventMessage<*>>.newChannelPinnedMessageEvents() = channelEvents<PinnedMessage>()
inline fun Flow<ChatEventMessage<*>>.allChannelEvents() = channelEvents<ChannelEvent>()

@RiskFeature("Use with caution")
inline fun <reified T : GroupEvent> Flow<ChatEventMessage<*>>.groupEvents() = filterByChatEvent<T, GroupEventMessage<T>>()
inline fun Flow<ChatEventMessage<*>>.groupCreatedEvents() = groupEvents<GroupChatCreated>()
inline fun Flow<ChatEventMessage<*>>.deletedGroupPhotoEvents() = groupEvents<DeleteChatPhoto>()
inline fun Flow<ChatEventMessage<*>>.newGroupMembersEvents() = groupEvents<NewChatMembers>()
inline fun Flow<ChatEventMessage<*>>.leftGroupMemberEvents() = groupEvents<LeftChatMember>()
inline fun Flow<ChatEventMessage<*>>.newGroupPhotoEvents() = groupEvents<NewChatPhoto>()
inline fun Flow<ChatEventMessage<*>>.newGroupTitleEvents() = groupEvents<NewChatTitle>()
inline fun Flow<ChatEventMessage<*>>.newGroupPinnedMessageEvents() = groupEvents<PinnedMessage>()
inline fun Flow<ChatEventMessage<*>>.proximityAlertTriggeredInGroupEvents() = groupEvents<ProximityAlertTriggered>()
inline fun Flow<ChatEventMessage<*>>.allGroupEvents() = groupEvents<GroupEvent>()


@RiskFeature("Use with caution")
inline fun <reified T : SupergroupEvent> Flow<ChatEventMessage<*>>.supergroupEvents() = filterByChatEvent<T, SupergroupEventMessage<T>>()
inline fun Flow<ChatEventMessage<*>>.supergroupCreatedEvents() = supergroupEvents<SupergroupChatCreated>()
inline fun Flow<ChatEventMessage<*>>.deletedSupergroupPhotoEvents() = supergroupEvents<DeleteChatPhoto>()
inline fun Flow<ChatEventMessage<*>>.newSupergroupMembersEvents() = supergroupEvents<NewChatMembers>()
inline fun Flow<ChatEventMessage<*>>.leftSupergroupMemberEvents() = supergroupEvents<LeftChatMember>()
inline fun Flow<ChatEventMessage<*>>.newSupergroupPhotoEvents() = supergroupEvents<NewChatPhoto>()
inline fun Flow<ChatEventMessage<*>>.newSupergroupTitleEvents() = supergroupEvents<NewChatTitle>()
inline fun Flow<ChatEventMessage<*>>.newSupergroupPinnedMessageEvents() = supergroupEvents<PinnedMessage>()
inline fun Flow<ChatEventMessage<*>>.proximityAlertTriggeredInSupergroupEvents() = supergroupEvents<ProximityAlertTriggered>()
inline fun Flow<ChatEventMessage<*>>.allSupergroupEvents() = supergroupEvents<SupergroupEvent>()
