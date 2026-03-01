package chapter14.code3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val sharedFlow: MutableSharedFlow<String> = MutableSharedFlow()

  sharedFlow.emit("collect 전에 방출되는 값")

  launch {
    sharedFlow.collect { value ->
      println("$value 처리")
    }
  }

  delay(1000L) // 1000밀리초간 대기
  sharedFlow.emit("collect 후에 방출되는 값")
}
