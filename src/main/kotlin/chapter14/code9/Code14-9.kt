package chapter14.code9

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val mutableStateFlow: MutableStateFlow<String> = MutableStateFlow("초기 상태")
  mutableStateFlow.value = "상태1"

  launch {
    mutableStateFlow.collect { value ->
      println("MutableStateFlow에서 방출된 값: $value")
    }
  }

  delay(1000L)
  mutableStateFlow.value = "상태2"
  delay(1000L)
  mutableStateFlow.value = "상태2"
}
