package chapter11.code3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow = flow {
    for (number in 1..3) {
      println("[${getElapsedTime(startTime)}] $number 생성 시작")
      delay(200L)
      println("[${getElapsedTime(startTime)}] $number 생성 완료")
      emit(number)
    }
  }

  numberFlow.flowOn(Dispatchers.IO) // 코루틴 분리
    .collectLatest { number ->
      println("[${getElapsedTime(startTime)}] $number 처리 시작")
      delay(300L)
      println("[${getElapsedTime(startTime)}] $number 처리 완료")
    }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"