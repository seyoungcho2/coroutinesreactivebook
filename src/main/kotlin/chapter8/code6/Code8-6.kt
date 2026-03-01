package chapter8.code6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = (0..9).asFlow()
    .cancellable() // Flow가 취소 가능하도록 설정

  val collectJob = launch(Dispatchers.IO) {
    numberFlow.collect {
      println("$it 수집")
      Thread.sleep(300L)
    }
  }

  delay(1000L)
  collectJob.cancel()
}