package chapter4.code5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = object : Flow<Int> {
  override suspend fun collect(collector: FlowCollector<Int>) {
    for (number in 1..3) {
      delay(1000L)
      collector.emit(number)
    }
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
