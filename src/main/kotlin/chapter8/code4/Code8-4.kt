package chapter8.code4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = (0..9).asFlow()

  val collectJob = launch(Dispatchers.IO) {
    numberFlow.collect {
      println("$it 수집")
      delay(300L)
    }
  }

  delay(1000L)
  collectJob.cancel()
}