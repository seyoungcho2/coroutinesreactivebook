package chapter10.code8

import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  flowOf(1, 2, 3).filter {
    it > 5
  }.onEmpty {
    emit(-1)
  }.collect { value ->
    if (value == -1) {
      println("조건을 만족하는 값이 없습니다.")
    }
  }
}