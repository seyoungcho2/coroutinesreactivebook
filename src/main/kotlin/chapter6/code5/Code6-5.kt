package chapter6.code5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
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
  val firstValue = numberFlow.first() // 첫 번째 값 가져오기
  println(firstValue)
}