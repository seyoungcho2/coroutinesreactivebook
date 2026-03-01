package chapter13.code5

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun searchCoroutinesBookPrice(bookstore: String): Flow<Int> {
  return flow {
    delay(1000L)
    println("[${Thread.currentThread().name}] ${bookstore}의 가격이 방출됩니다")
    when (bookstore) {
      "A서점" -> {
        emit(35000)
      }

      "B서점" -> {
        emit(35000)
      }

      "C서점" -> {
        emit(31500)
      }
    }
  }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()

  val bookStoreFlow = flowOf("A서점", "B서점", "C서점")

  val priceResultsFlow: Flow<Int> =
    bookStoreFlow.flatMapMerge {
      searchCoroutinesBookPrice(it)
    }

  val prices = priceResultsFlow.toList()

  println("최저가: ${prices.min()}원")
  println("검색에 걸린 시간: ${getElapsedTime(startTime)}")
}


fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"