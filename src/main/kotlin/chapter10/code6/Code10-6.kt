package chapter10.code6

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    for (number in 1..3) {
      println("$number 방출")
      emit(number)
    }
  }

  numberFlow.onEach { number ->
    println("$number 처리 - onEach")
  }.collect { number ->
    println("$number 수집")
  }
}