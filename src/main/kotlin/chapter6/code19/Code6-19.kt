package chapter6.code19

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 3)

fun main() = runBlocking<Unit> {
  // 방출되는 원소 중 짝수의 개수만 확인
  val count = numberFlow.count { it % 2 == 0 }
  println(count)
}