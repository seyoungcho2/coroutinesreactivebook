package chapter14.code13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val mutableStateFlow: MutableStateFlow<Int> = MutableStateFlow(0)

  launch {
    mutableStateFlow.collect { value ->
      println("MutableStateFlow에서 방출된 값: $value")
    }
  }

  repeat(10) {
    launch(Dispatchers.IO) {
      repeat(100) {
        mutableStateFlow.update { previousValue ->
          previousValue + 1
        }
      }
    }
  }
}