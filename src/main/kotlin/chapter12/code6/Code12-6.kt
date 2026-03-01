package chapter12.code6

import chapter11.code5.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow = flow {
    for (number in 1..5) {
      println("[${getElapsedTime(startTime)}] $number 방출")
      emit(number)
      delay(200L)
    }
  }

  val charFlow = flow {
    delay(100L)
    for (char in 'A'..'C') {
      println("[${getElapsedTime(startTime)}] $char 방출")
      emit(char)
      delay(200L)
    }
  }

  numberFlow.combine(charFlow) { number, char ->
    "${number}${char}"
  }.collect {
    println(it)
  }
}
