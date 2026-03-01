package chapter14.code6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val sharedFlow: MutableSharedFlow<Int> = MutableSharedFlow(replay = 2)

  sharedFlow.emit(0)
  println(sharedFlow.replayCache) // [0] 출력
  delay(1000L)
  sharedFlow.emit(1)
  println(sharedFlow.replayCache) // [0, 1] 출력
  delay(1000L)
  sharedFlow.emit(2)
  println(sharedFlow.replayCache) // [1, 2] 출력
  delay(1000L)
  sharedFlow.emit(3)
  println(sharedFlow.replayCache) // [2, 3] 출력
}