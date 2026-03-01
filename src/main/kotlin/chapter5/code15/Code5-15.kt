package chapter5.code15

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val nullableNumberFlow: Flow<Int?> = flow {
  emit(1)
  emit(2)
  emit(null)
}

val numberFlow: Flow<Int> = nullableNumberFlow
  .filterNotNull() // null이 아닌 값만 필터링

fun main() = runBlocking<Unit> {
  numberFlow.collect {
    println(it)
  }
}