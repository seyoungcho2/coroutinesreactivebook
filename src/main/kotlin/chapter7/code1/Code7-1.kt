package chapter7.code1

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    emit(1)
    emit(2)
  }

  numberFlow.collect { value ->
    println("$value 수집")
  }
}