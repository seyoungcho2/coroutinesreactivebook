package chapter14.code10

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val stateFlow: MutableStateFlow<Int> = MutableStateFlow(0)

  // 방출
  launch {
    delay(100L)
    repeat(3) {
      stateFlow.value = stateFlow.value + 1
      delay(100L)
    }
  }

  // 수집
  launch {
    stateFlow.collect { value ->
      delay(400L) // 처리에 걸리는 시간
      println("$value 처리 완료")
    }
  }
}