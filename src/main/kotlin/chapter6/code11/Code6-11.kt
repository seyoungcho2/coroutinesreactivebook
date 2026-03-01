package chapter6.code11

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 3)
val emptyFlow: Flow<Int> = emptyFlow()

fun main() = runBlocking<Unit> {
  val numberFlowLastValue: Int? = numberFlow.lastOrNull() // 마지막 값 가져오기
  println("numberFlowLastValue: $numberFlowLastValue")
  val emptyFlowLastValue: Int? = emptyFlow.lastOrNull() // 마지막 값 가져오기
  println("emptyFlowLastValue: $emptyFlowLastValue")
}