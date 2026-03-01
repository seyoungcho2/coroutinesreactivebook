package chapter7.code3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow: Flow<Int> = flow {
    for (number in 1..3) {
      println("[${getElapsedTime(startTime)}] $number 방출")
      emit(number)
      delay(1000L)
    }
  }

  delay(500L) // 500밀리초 대기

  // numberFlow에 대한 collect 호출
  numberFlow.collect {}
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"