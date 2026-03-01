package chapter6.code8

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 3)
val emptyFlow: Flow<Int> = emptyFlow()

fun main() = runBlocking<Unit> {
  val numberFlowFirstValue: Int? = numberFlow.firstOrNull()
  println("numberFlowFirstValue: $numberFlowFirstValue")
  val emptyFlowFirstValue: Int? = emptyFlow.firstOrNull()
  println("emptyFlowFirstValue: $emptyFlowFirstValue")
}