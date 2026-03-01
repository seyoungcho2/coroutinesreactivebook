package chapter7.code11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val infiniteFlow: Flow<Int> = flow {
  while (true) {
    val randomValue = (1..10).random()
    emit(randomValue)
    delay(1000L)
  }
}

fun main() = runBlocking<Unit> {
  launch {
    infiniteFlow.collect { value ->
      println("$value 수집")
    }
  }
  println("다른 작업 실행")
}