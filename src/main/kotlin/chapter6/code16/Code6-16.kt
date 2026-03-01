package chapter6.code16

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 3)

fun main() = runBlocking<Unit> {
  val sum = numberFlow.fold(initial = 0) { accumulator, value ->
    println("accumulator: $accumulator, value: $value")
    accumulator + value
  }
  println("sum: $sum")
}