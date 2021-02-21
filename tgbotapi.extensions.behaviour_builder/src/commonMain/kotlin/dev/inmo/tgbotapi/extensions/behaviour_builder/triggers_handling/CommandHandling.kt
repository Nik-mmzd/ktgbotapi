package dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling

import dev.inmo.tgbotapi.CommonAbstracts.textSources
import dev.inmo.tgbotapi.extensions.behaviour_builder.*
import dev.inmo.tgbotapi.extensions.utils.*
import dev.inmo.tgbotapi.types.message.abstracts.CommonMessage
import dev.inmo.tgbotapi.types.message.content.TextContent
import kotlinx.coroutines.Job

suspend fun BehaviourContext.command(
    commandRegex: Regex,
    requireOnlyCommandInMessage: Boolean = true,
    includeFilterByChatInBehaviourSubContext: Boolean = true,
    scenarioReceiver: BehaviourContextAndTypeReceiver<Unit, CommonMessage<TextContent>>
): Job = onText(
    includeFilterByChatInBehaviourSubContext,
    { message ->
        val content = message.content
        val textSources = content.textSources
        val sizeRequirement = if (requireOnlyCommandInMessage) {
            textSources.size == 1
        } else {
            true
        }
        sizeRequirement && textSources.any { commandRegex.matches(it.asBotCommandTextSource() ?.command ?: return@any false) }
    },
    scenarioReceiver
)
suspend fun BehaviourContext.command(
    command: String,
    requireOnlyCommandInMessage: Boolean = true,
    includeFilterByChatInBehaviourSubContext: Boolean = true,
    scenarioReceiver: BehaviourContextAndTypeReceiver<Unit, CommonMessage<TextContent>>
) = command(command.toRegex(), requireOnlyCommandInMessage, includeFilterByChatInBehaviourSubContext, scenarioReceiver)

suspend inline fun BehaviourContext.onCommand(
    commandRegex: Regex,
    requireOnlyCommandInMessage: Boolean = true,
    includeFilterByChatInBehaviourSubContext: Boolean = true,
    noinline scenarioReceiver: BehaviourContextAndTypeReceiver<Unit, CommonMessage<TextContent>>
): Job = command(commandRegex, requireOnlyCommandInMessage, includeFilterByChatInBehaviourSubContext, scenarioReceiver)

suspend inline fun BehaviourContext.onCommand(
    command: String,
    requireOnlyCommandInMessage: Boolean = true,
    includeFilterByChatInBehaviourSubContext: Boolean = true,
    noinline scenarioReceiver: BehaviourContextAndTypeReceiver<Unit, CommonMessage<TextContent>>
): Job = onCommand(command.toRegex(), requireOnlyCommandInMessage, includeFilterByChatInBehaviourSubContext, scenarioReceiver)