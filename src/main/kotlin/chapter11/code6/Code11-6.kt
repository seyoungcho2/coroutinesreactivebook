package chapter11.code6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    for (number in 1..3) {
      println("[${Thread.currentThread().name}] $number 생성 시작")
      delay(200L)
      println("[${Thread.currentThread().name}] $number 생성 완료")
      emit(number)
    }
  }

  numberFlow.conflate() // 코루틴 분리
    .collect { number ->
      println("[${Thread.currentThread().name}] $number 처리 시작")
      delay(500L)
      println("[${Thread.currentThread().name}] $number 처리 완료")
    }
}
