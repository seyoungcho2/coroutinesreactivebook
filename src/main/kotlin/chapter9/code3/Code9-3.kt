package chapter9.code3

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    emit(1)
    emit(2)
    emit(3)
  }.map { value ->
    if (value == 2) {
      throw Exception("중간 연산자에서 2 처리 시 예외 발생")
    }
    value
  }

  try {
    numberFlow.collect { value ->
      println(value)
    }
  } catch (e: Exception) {
    println("Exception: $e")
  }
}