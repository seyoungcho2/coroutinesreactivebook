package chapter4.code2

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flowOf(1, 2, 3)

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  numberFlow.collect { value ->
    println("[${getElapsedTime(startTime)}] $value 수집 완료")
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"
