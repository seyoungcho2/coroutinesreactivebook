package chapter5.code17

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 3)

val repeatedNumberFlow: Flow<Int> = numberFlow.transform { number ->
  repeat(number) {
    emit(number)
  }
}

fun main() = runBlocking<Unit> {
  repeatedNumberFlow.collect { value ->
    println(value)
  }
}