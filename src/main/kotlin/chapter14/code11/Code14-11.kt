package chapter14.code11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val mutableStateFlow: MutableStateFlow<String> = MutableStateFlow("초기 상태")

  val collectJob = launch {
    mutableStateFlow.collect { value ->
      println("MutableStateFlow에서 방출된 값: $value")
    }
  }

  delay(1000L)
  collectJob.cancel() // launch 코루틴 취소
}
