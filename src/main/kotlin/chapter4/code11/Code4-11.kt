package chapter4.code11

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  for (number in 1..3) {
    println("[${Thread.currentThread().name}] Emitting: $number")
    emit(number)
    delay(1000L)
  }
}

fun main() = runBlocking<Unit> {
  numberFlow
    .flowOn(Job())
    .collect { value ->
      println("[${Thread.currentThread().name}] Collected: $value")
    }
}