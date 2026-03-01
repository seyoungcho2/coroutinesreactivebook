package chapter5.code4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  emit(1)
  delay(1000L)
  emit(2)
  delay(1000L)
  emit(3)
  delay(1000L)
  emit(4)
}

val evenNumberFlow: Flow<Int> = numberFlow.filter { it % 2 == 0 }

fun main() = runBlocking<Unit> {
  evenNumberFlow.collect { value ->
    println(value)
  }
}