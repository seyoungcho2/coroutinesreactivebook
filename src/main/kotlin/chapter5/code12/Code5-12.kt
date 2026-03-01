package chapter5.code12

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val numberFlow = flow {
  for (number in 1..5) {
    emit(number)
    delay(1000L)
  }
}

val drop2NumberFlow = numberFlow.drop(2)

fun main() = runBlocking<Unit> {
  drop2NumberFlow.collect { value ->
    println(value)
  }
}