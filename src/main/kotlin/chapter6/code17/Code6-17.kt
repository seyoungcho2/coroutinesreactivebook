package chapter6.code17

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 3)

fun main() = runBlocking<Unit> {
  numberFlow
    .scan(initial = 0) { accumulator, value ->
      println("accumulator: $accumulator, value: $value")
      accumulator + value
    }
    .collect { result ->
      println("$result 수집")
    }
}