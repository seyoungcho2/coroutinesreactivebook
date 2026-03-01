package chapter5.code5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

sealed class Message {
  data class TextMessage(val text: String) : Message()
  data class ImageMessage(val imageUrl: String) : Message()
}

val recentMessageFlow: Flow<Message> = flow {
  emit(Message.TextMessage("안녕하세요."))
  delay(1000L)
  emit(Message.ImageMessage("https://coroutine.info/example.jpg"))
  delay(1000L)
  emit(Message.TextMessage("반갑습니다."))
}

//@Suppress("UNCHECKED_CAST")
//val recentTextMessageFlow: Flow<Message.TextMessage> = recentMessageFlow
//  .filter { it is Message.TextMessage } as Flow<Message.TextMessage>

val recentTextMessageFlow: Flow<Message.TextMessage> =
  recentMessageFlow.filterIsInstance<Message.TextMessage>()

fun main() = runBlocking<Unit> {
  recentTextMessageFlow.collect { message ->
    // text 프로퍼티 직접 사용
    println("새로운 메시지가 도착했습니다: ${message.text}")
  }
}
