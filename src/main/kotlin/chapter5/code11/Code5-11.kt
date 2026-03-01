package chapter5.code11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

val numberFlow = flow {
  for (number in 1..5) {
    emit(number)
    delay(1000L)
  }
}

// 첫 두 개의 원소만 사용
val take2NumberFlow = numberFlow.take(2)

fun main() = runBlocking<Unit> {
  take2NumberFlow.collect { value ->
    println(value)
  }
}