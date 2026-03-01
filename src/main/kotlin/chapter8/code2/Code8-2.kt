package chapter8.code2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    repeat(10) { repeatTime ->
      emit(repeatTime)
      Thread.sleep(300L) // Thread.sleep으로 변경
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