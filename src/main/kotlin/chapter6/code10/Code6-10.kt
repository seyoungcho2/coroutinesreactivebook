package chapter6.code10

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  emit(1)
  delay(1000L)
  emit(2)
  delay(1000L)
  emit(3)
}

fun main() = runBlocking<Unit> {
  val lastValue: Int = numberFlow.last() // 마지막 값 가져오기
  println(lastValue)
}