package chapter14.code8

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val mutableStateFlow: MutableStateFlow<String> = MutableStateFlow("초기 상태")

  launch {
    mutableStateFlow.collect { value ->
      println("MutableStateFlow에서 방출된 값: $value")
    }
  }
}
