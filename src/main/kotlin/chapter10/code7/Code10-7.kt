package chapter10.code7

import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  emptyFlow<String>().onEmpty {
    println("Flow에서 방출된 원소가 없습니다")
  }.collect { value ->
    println("$value 수집")
  }
}