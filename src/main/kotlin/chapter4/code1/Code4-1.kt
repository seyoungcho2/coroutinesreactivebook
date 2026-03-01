package chapter4.code1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  for (number in 1..3) {
    emit(number)
    delay(1000L)
  }
}

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  numberFlow.collect { value ->
    println("[${getElapsedTime(startTime)}] $value 수집 완료")
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"
