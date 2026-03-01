package chapter11.code1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow = flow {
    for (number in 1..3) {
      println("[${getElapsedTime(startTime)}] $number 생성 시작")
      delay(200L) // 데이터 생성에 걸리는 시간 200밀리초
      println("[${getElapsedTime(startTime)}] $number 생성 완료")
      emit(number) // 데이터 방출
    }
  }

  numberFlow
    .collect { number ->
      println("[${getElapsedTime(startTime)}] $number 처리 시작")
      delay(300L) // 데이터 처리에 걸리는 시간 300밀리초
      println("[${getElapsedTime(startTime)}] $number 처리 완료")
    }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"