package chapter8.code3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = (0..9).asFlow()

  val collectJob = launch(Dispatchers.IO) {
    numberFlow.collect { value ->
      println("$value 수집")
      Thread.sleep(300L)
    }
  }

  delay(1000L)
  collectJob.cancel()
}