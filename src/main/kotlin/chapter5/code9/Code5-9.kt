package chapter5.code9

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

val currentPriceFlow = flowOf(1000, 1010, 1010, 1010, 1020, 1020)

//fun main() = runBlocking<Unit> {
//  currentPriceFlow.filter { it >= 1010 }
//    .collect { price ->
//      println("가격이 ${price}원에 도달했습니다.")
//    }
//}

fun main() = runBlocking<Unit> {
  currentPriceFlow.distinctUntilChanged()
    .filter { it >= 1010 }
    .collect { price ->
      println("가격이 ${price}원에 도달했습니다.")
    }
}