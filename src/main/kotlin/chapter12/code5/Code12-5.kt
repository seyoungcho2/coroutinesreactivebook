package chapter12.code5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val userInputFlow = flow {
    emit("노트북")
    delay(200L)
    emit("우유")
  }

  val categoryFlow = flow {
    emit("디지털")
    delay(500L)
    emit("신선식품")
  }

  val sortOrderFlow = flow {
    emit("높은 가격순")
    delay(1000L)
    emit("낮은 가격순")
  }

  combine(
    userInputFlow,
    categoryFlow,
    sortOrderFlow
  ) { input, category, sortOrder ->
    println("input: ${input}, category: ${category}, sortOrder: ${sortOrder} 으로 검색이 실행됩니다")
    // 검색 수행 후 결과 반환
  }.collect {
    // 결과 표시
  }
}