package chapter5.code8

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  emit(1)
  emit(1) // 중복된 값
  emit(2)
  emit(2) // 중복된 값
  emit(1)
}

val distinctNumberFlow: Flow<Int> =
  numberFlow.distinctUntilChanged()

fun main() = runBlocking {
  distinctNumberFlow.collect { value ->
    println(value)
  }
}