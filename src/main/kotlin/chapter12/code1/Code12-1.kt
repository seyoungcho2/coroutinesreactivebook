package chapter12.code1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    for (number in 1..3) {
      delay(100L)
      emit(number)
    }
  }

  val charFlow = flow {
    for (char in 'A'..'C') {
      delay(200L)
      emit(char)
    }
  }

  numberFlow.zip(charFlow) { number, char ->
    "${number}${char}" // transform 람다식
  }.collect {
    println(it)
  }
}
