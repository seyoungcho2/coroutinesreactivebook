package chapter6.code9

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

val emptyFlow: Flow<Int> = emptyFlow()

fun main() = runBlocking<Unit> {
  val firstValue: Int = emptyFlow.firstOrNull() ?: return@runBlocking
  println(firstValue)
}