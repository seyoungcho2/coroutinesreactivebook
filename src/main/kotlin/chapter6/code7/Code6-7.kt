package chapter6.code7

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = emptyFlow()

fun main() = runBlocking<Unit> {
  val firstValue: Int? = try {
    numberFlow.first()
  } catch (e: NoSuchElementException) {
    null
  }
  println(firstValue)
}