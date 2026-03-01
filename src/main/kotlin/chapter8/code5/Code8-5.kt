package chapter8.code5

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow

fun main() = runBlocking<Unit> {
  val numberFlow = (0..9).asFlow()

  val collectJob = launch(Dispatchers.IO) {
    numberFlow.collect {
      ensureActive()
      println("$it 수집")
      Thread.sleep(300L)
    }
  }

  delay(1000L)
  collectJob.cancel()
}