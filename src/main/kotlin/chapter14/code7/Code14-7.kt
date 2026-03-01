package chapter14.code7

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val sharedFlow: MutableSharedFlow<String> = MutableSharedFlow()

  val collectJob = launch {
    sharedFlow.collect { value ->
      println("MutableSharedFlow에서 방출된 값: $value")
    }
  }

  delay(1000L)
  collectJob.cancel() // launch 코루틴 취소
}
