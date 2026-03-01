package chapter3.code5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val priceFlow: Flow<Int> = flow {
    emit(1000) // 1000 방출
    delay(1000L) // 1초간 대기
    emit(1010) // 1010 방출
    delay(1000L) // 1초간 대기
    emit(1020) // 1020 방출
  }

  val filteredPriceFlow: Flow<Int> = priceFlow
    .filter { price -> price >= 1010 } // 1010 이상만 필터링

  filteredPriceFlow.collect { price ->
    println("주식의 가격이 ${price}원에 도달했습니다")
  }
}
