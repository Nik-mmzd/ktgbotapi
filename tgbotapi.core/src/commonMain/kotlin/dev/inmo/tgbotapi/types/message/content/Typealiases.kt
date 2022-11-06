package dev.inmo.tgbotapi.types.message.content

import dev.inmo.tgbotapi.types.message.abstracts.CommonMessage

typealias InvoiceMessage = CommonMessage<InvoiceContent>
typealias VenueMessage = CommonMessage<VenueContent>
typealias GameMessage = CommonMessage<GameContent>
typealias DiceMessage = CommonMessage<DiceContent>
typealias ContactMessage = CommonMessage<ContactContent>
typealias PollMessage = CommonMessage<PollContent>
typealias TextMessage = CommonMessage<TextContent>

typealias LocationMessage = CommonMessage<LocationContent>
typealias LiveLocationMessage = CommonMessage<LiveLocationContent>
typealias StaticLocationMessage = CommonMessage<StaticLocationContent>

typealias MediaCollectionMessage<T> = CommonMessage<MediaCollectionContent<T>>
typealias MediaMessage = CommonMessage<MediaContent>
typealias VideoNoteMessage = CommonMessage<VideoNoteContent>
typealias StickerMessage = CommonMessage<StickerContent>
typealias TextedMediaMessage = CommonMessage<TextedMediaContent>
typealias VoiceMessage = CommonMessage<VoiceContent>
typealias MediaGroupMessage = CommonMessage<MediaGroupPartContent>
typealias AudioMediaGroupMessage = CommonMessage<AudioMediaGroupPartContent>
typealias AudioMessage = CommonMessage<AudioContent>
typealias DocumentMediaGroupMessage = CommonMessage<DocumentMediaGroupPartContent>
typealias DocumentMessage = CommonMessage<DocumentContent>
typealias VisualMediaGroupMessage = CommonMessage<VisualMediaGroupPartContent>
typealias VideoMessage = CommonMessage<VideoContent>
typealias PhotoMessage = CommonMessage<PhotoContent>
typealias AnimationMessage = CommonMessage<AnimationContent>


