package chapter4.code7

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  for (number in 1..3) {
    println("[${Thread.currentThread().name}] $number 방출")
    emit(number)
    delay(1000L)
  }
}

fun main() = runBlocking<Unit> {
  numberFlow
    .flowOn(Dispatchers.IO) // 업스트림을 Dispatchers.IO를 사용하는 코루틴이 실행하도록 변경
    .collect { number ->
      println("[${Thread.currentThread().name}] $number 수집 완료")
    }
}