package chapter15.code11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
  val sharedFlow = MutableSharedFlow<String>(
    extraBufferCapacity = 1
  )

  println("구독자가 생기기 전 tryEmit: ${sharedFlow.tryEmit("데이터")}")

  launch {
    sharedFlow.collect { value ->
      delay(1000L) // 처리에 1000밀리초 걸림
      println("$value 처리 완료")
    }
  }

  yield()

  println("구독자가 생긴 후 첫 번째 tryEmit: ${sharedFlow.tryEmit("데이터1")}")
  delay(100L)
  println("구독자가 생긴 후 두 번째 tryEmit: ${sharedFlow.tryEmit("데이터2")}")
  delay(100L)
  println("구독자가 생긴 후 세 번째 tryEmit: ${sharedFlow.tryEmit("데이터3")}")
}