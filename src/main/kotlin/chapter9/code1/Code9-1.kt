package chapter9.code1

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    emit(1)
    throw Exception("2 생성 도중 예외 발생")
    emit(2)
  }

  try {
    numberFlow.collect { value ->
      println("$value 수집")
    }
  } catch (e: Exception) {
    println("Exception: $e")
  }
}