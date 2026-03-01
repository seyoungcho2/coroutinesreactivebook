package chapter7.code4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow: Flow<Int> = flow {
    println("[${getElapsedTime(startTime)}] 1 방출")
    emit(1)
    println("[${getElapsedTime(startTime)}] 2 방출")
    emit(2)
  }

  numberFlow.collect { number ->
    delay(1000L)
    println("[${getElapsedTime(startTime)}] $number 수집")
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"