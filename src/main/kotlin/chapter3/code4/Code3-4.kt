package chapter3.code4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime

fun main() = runBlocking<Unit> {
  val priceFlow: Flow<Int> = flow {
    emit(1000) // 1000 방출
    delay(1000L) // 1초간 대기
    emit(1010) // 1010 방출
    delay(1000L) // 1초간 대기
    emit(1020) // 1020 방출
  }

  priceFlow.collect { currentPrice ->
    println("[${LocalDateTime.now()}] ${currentPrice}원")
  }
}