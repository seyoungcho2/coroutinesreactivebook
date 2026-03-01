package chapter5.code1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  emit(1)
  delay(1000L)
  emit(2)
  delay(1000L)
  emit(3)
}

val doubledFlow: Flow<Int> = numberFlow.map { it * 2 }

fun main() = runBlocking<Unit> {
  doubledFlow.collect { value ->
    println(value)
  }
}