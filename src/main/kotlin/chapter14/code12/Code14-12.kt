package chapter14.code12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberStateFlow: MutableStateFlow<Int> = MutableStateFlow(0)

  launch {
    numberStateFlow.collect { value ->
      println("numberStateFlow에서 방출된 값: $value")
    }
  }

  repeat(10) {
    launch(Dispatchers.IO) {
      repeat(100) {
        numberStateFlow.value = numberStateFlow.value + 1
      }
    }
  }
}
