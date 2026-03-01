package chapter9.code2

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    emit(1)
    emit(2)
    emit(3)
  }

  try {
    numberFlow.collect { value ->
      if (value == 3) {
        throw Exception("3 처리 중 예외 발생")
      }
      println("$value 수집")
    }
  } catch (e: Exception) {
    println("Exception: $e")
  }
}