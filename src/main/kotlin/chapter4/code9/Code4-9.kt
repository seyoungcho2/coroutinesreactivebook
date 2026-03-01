package chapter4.code9

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

fun main() = runBlocking<Unit>(Dispatchers.IO) {
  numberFlow
    .flowOn(Dispatchers.IO)
    .collect { number ->
      println("[${Thread.currentThread().name}] $number 수집 완료")
    }
}