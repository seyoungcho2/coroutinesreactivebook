package chapter10.code1

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  flowOf(1, 2, 3).onStart {
    println("Flow 수집을 시작합니다")
  }.collect { value ->
    println("$value 수집")
  }
}