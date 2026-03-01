package chapter11.code11

import chapter11.code5.getElapsedTime
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow = flow {
    for (number in 1..5) {
      println("[${getElapsedTime(startTime)}] $number 생성 시작")
      delay(200L) // 생성 간격
      println("[${getElapsedTime(startTime)}] $number 생성 완료")
      emit(number)
    }
  }

  numberFlow.buffer(capacity = 2, onBufferOverflow = BufferOverflow.DROP_LATEST)
    .collect { number ->
      println("[${getElapsedTime(startTime)}] $number 처리 시작")
      delay(1000L) // 소비 간격
      println("[${getElapsedTime(startTime)}] $number 처리 완료")
    }
}


fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"