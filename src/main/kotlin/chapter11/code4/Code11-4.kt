package chapter11.code4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

  numberFlow.flowOn(Dispatchers.IO) // 코루틴 분리
    .collectLatest { number ->
      println("[${Thread.currentThread().name}] $number 처리 시작")
      delay(300L)
      println("[${Thread.currentThread().name}] $number 처리 완료")
    }
}
