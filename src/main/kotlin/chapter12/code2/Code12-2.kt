package chapter12.code2

import chapter11.code5.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow = flow {
    for (number in 1..3) {
      delay(100L)
      println("[${getElapsedTime(startTime)}] $number 방출")
      emit(number)
    }
  }

  val charFlow = flow {
    for (char in 'A'..'C') {
      delay(200L)
      println("[${getElapsedTime(startTime)}] $char 방출")
      emit(char)
    }
  }

  numberFlow.zip(charFlow) { number, char ->
    "${number}${char}"
  }.collect {
    println(it)
  }
}
