package chapter6.code2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
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
  numberFlow.collect { value ->
    println("$value 처리")
  }
  println("Flow collect 완료")
}