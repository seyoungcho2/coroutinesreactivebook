package chapter11.code7

import chapter11.code5.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow = flow {
    for (number in 1..100) {
      println("[${getElapsedTime(startTime)}][생산자 코루틴] $number 생성 시작")
      delay(10L)
      println("[${getElapsedTime(startTime)}][생산자 코루틴] $number 생성 완료")
      emit(number)
    }
  }

  numberFlow.buffer()
    .collect { number ->
      println("[${getElapsedTime(startTime)}][소비자 코루틴] $number 처리 시작")
      delay(2000L)
      println("[${getElapsedTime(startTime)}][소비자 코루틴] $number 처리 완료")
    }
}


fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"