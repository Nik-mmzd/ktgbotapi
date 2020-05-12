# TelegramBotAPI Util  Extensions

[![Download](https://api.bintray.com/packages/insanusmokrassar/StandardRepository/TelegramBotAPI-extensions-utils/images/download.svg) ](https://bintray.com/insanusmokrassar/StandardRepository/TelegramBotAPI-extensions-utils/_latestVersion)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.insanusmokrassar/TelegramBotAPI-extensions-utils/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.insanusmokrassar/TelegramBotAPI-extensions-utils)

## What is it?

It is wrapper library for [TelegramBotAPI](../TelegramBotAPI/README.md). Currently, this library contains some usefull filters for commands, updates types and different others.

## How to implement library?

Common ways to implement this library are presented here. In some cases it will require additional steps
like inserting of additional libraries (like `kotlin stdlib`). In the examples will be used variable
`telegrambotapi-extensions-utils_version`, which must be set up by developer. Available versions are presented on
[bintray](https://bintray.com/insanusmokrassar/StandardRepository/TelegramBotAPI-extensions-utils), next version is last published:

[![Download](https://api.bintray.com/packages/insanusmokrassar/StandardRepository/TelegramBotAPI-extensions-utils/images/download.svg) ](https://bintray.com/insanusmokrassar/StandardRepository/TelegramBotAPI-extensions-utils/_latestVersion)

### Maven

Dependency config presented here:

```xml
<dependency>
  <groupId>com.github.insanusmokrassar</groupId>
  <artifactId>TelegramBotAPI-extensions-utils</artifactId>
  <version>${telegrambotapi-extensions-utils_version}</version>
</dependency>
```

### Gradle

To use last versions you will need to add one line in repositories block of your `build.gradle`:

`jcenter()` or `mavenCentral()`

And add next line to your dependencies block:

```groovy
implementation "com.github.insanusmokrassar:TelegramBotAPI-extensions-utils:$telegrambotapi-extensions-utils_version"
```

or for old gradle:

```groovy
compile "com.github.insanusmokrassar:TelegramBotAPI-extensions-utils:$telegrambotapi-extensions-utils_version"
```

## How to use?

Here will be presented several examples of usage. In all cases it is expected that you have created your bot and filter:

```kotlin
val bot: RequestsExecutor = KtorRequestsExecutor(
    TelegramAPIUrlsKeeper(BOT_TOKEN)
)
val filter = FlowsUpdatesFilter(64)
```

Alternative way to use the things below:

```kotlin
val filter = bot.startGettingUpdates(
    scope = CoroutineScope(Dispatchers.Default)
) {
    // place code from examples here with replacing of `filter` by `this`
}
```

### Filters

There are several filters for flows.

#### Sent messages

All sent messages can be filtered for three types:

| Type | Description | Flow extension |
|:---- |:----------- |:-------------- |
| Common messages | Simple messages with text, media, location, etc. | `asContentMessagesFlow` |
| Chat actions | New chat member, rename of chat, etc. | `asChatEventsFlow` |
| Unknown events | Any other messages, that contain unsupported data | `asUnknownMessagesFlow` |

##### Common messages

Unfortunately, due to the erasing of generic types, when you are using `asContentMessagesFlow` you will retrieve
data with type `ContentMessage<*>`. For correct filtering of content type for retrieved objects, was created special
filters:

| Content type | Result type | Flow extension |
|:---- |:----------- |:-------------- |
| Animation | `ContentMessage<AnimationContent>`| `onlyAnimationContentMessages` |
| Audio | `ContentMessage<AudioContent>` | `onlyAudioContentMessages` |
| Contact | `ContentMessage<ContactContent>` | `onlyContactContentMessages` |
| Dice | `ContentMessage<DiceContent>` | `onlyDiceContentMessages` |
| Document | `ContentMessage<DocumentContent>` | `onlyDocumentContentMessages` |
| Game | `ContentMessage<GameContent>` | `onlyGameContentMessages` |
| Invoice | `ContentMessage<InvoiceContent>` | `onlyInvoiceContentMessages` |
| Location | `ContentMessage<LocationContent>` | `onlyLocationContentMessages` |
| Photo | `ContentMessage<PhotoContent>` | `onlyPhotoContentMessages` |
| Poll | `ContentMessage<PollContent>` | `onlyPollContentMessages` |
| Sticker | `ContentMessage<StickerContent>` | `onlyStickerContentMessages` |
| Text | `ContentMessage<TextContent>` | `onlyTextContentMessages` |
| Venue | `ContentMessage<VenueContent>` | `onlyVenueContentMessages` |
| Video | `ContentMessage<VideoContent>` | `onlyVideoContentMessages` |
| VideoNote | `ContentMessage<VideoNoteContent>` | `onlyVideoNoteContentMessages` |
| Voice | `ContentMessage<VoiceContent>` | `onlyVoiceContentMessages` |

For example, if you wish to get only photo messages from private chats of groups, you should call next code:

```kotlin
filter.messageFlow.asContentMessagesFlow().onlyPhotoContentMessages().onEach {
    println(it.content)
}.launchIn(
    CoroutineScope(Dispatchers.Default)
)
```

##### Chat actions

Chat actions can be divided for three types of events source:

| Type | Flow extension |
|:---- |:-------------- |
| Channel events | `onlyChannelEvents` |
| Group events | `onlyGroupEvents` |
| Supergroup events | `onlySupergroupEvents` |

According to this table, if you want to add filtering by supergroup events, you will use code like this:

```kotlin
filter.messageFlow.asChatEventsFlow().onlySupergroupEvents().onEach {
    println(it.chatEvent)
}.launchIn(
    CoroutineScope(Dispatchers.Default)
)
```

## Shortcuts

With shortcuts you are able to use simple factories for several things.

### ScheduledCloseInfo

In case if you are creating some poll, you able to use next shortcuts.

Next sample will use info with closing at the 10 seconds after now:

```kotlin
closePollExactAt(DateTime.now() + TimeSpan(10000.0))
```

In this example we will do the same, but in another way:

```kotlin
closePollExactAfter(10)
```

Here we have passed `10` seconds and will get the same result object.

In opposite to previous shortcuts, the next one will create `approximate` closing schedule:

```kotlin
closePollAfter(10)
```

The main difference here is that the last one will be closed after 10 seconds since the sending. With first samples
will be created **exact** time for closing of poll