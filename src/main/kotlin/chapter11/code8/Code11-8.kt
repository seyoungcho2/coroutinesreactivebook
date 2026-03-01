package chapter11.code8

import chapter11.code5.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow = flow {
    for (number in 1..3) {
      println("[${getElapsedTime(startTime)}][생산자 코루틴] $number 생성 시작")
      delay(200L) // 데이터 생산 간격 200밀리초
      println("[${getElapsedTime(startTime)}][생산자 코루틴] $number 생성 완료")
      emit(number)
    }
  }

  numberFlow.buffer(capacity = 0) // capacity 0으로 설정
    .collect { number ->
      println("[${getElapsedTime(startTime)}][소비자 코루틴] $number 처리 시작")
      delay(600L) // 데이터 소비 간격 600밀리초
      println("[${getElapsedTime(startTime)}][소비자 코루틴] $number 처리 완료")
    }
}


fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"