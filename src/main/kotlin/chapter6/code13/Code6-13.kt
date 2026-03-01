package chapter6.code13

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 2, 3)

fun main() = runBlocking<Unit> {
  val numberSet: Set<Int> = numberFlow.toSet()
  println(numberSet) // [1, 2, 3] 출력
}