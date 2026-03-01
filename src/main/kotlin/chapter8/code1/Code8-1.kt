package chapter8.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    repeat(10) { repeatTime ->
      emit(repeatTime)
      delay(300L)
    }
  }

  val collectJob = launch(Dispatchers.IO) {
    numberFlow.collect { value ->
      println("$value 수집")
    }
  }

  delay(1000L)
  collectJob.cancel()
}