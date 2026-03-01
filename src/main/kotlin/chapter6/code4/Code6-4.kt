package chapter6.code4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  emit(1)
  delay(1000L)
  emit(2)
  delay(1000L)
  emit(3)
}

fun main() = runBlocking<Unit> {
  numberFlow.collectIndexed { index, value ->
    println("index:${index} value:${value}")
  }
}