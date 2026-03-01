package chapter9.code11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.runBlocking
import java.io.IOException

fun main() = runBlocking<Unit> {
  val serverDataFlow = flow {
    emit("데이터")
    throw IllegalArgumentException("예외")
  }

  serverDataFlow.retry(2) { cause ->
    println("$cause 발생")
    if (cause is IOException) {
      println("200밀리초 후에 다시 시도합니다")
      delay(200L)
      true
    } else {
      println("다시 시도하지 않습니다")
      false
    }
  }.collect { value ->
    println("방출된 데이터 >> $value")
  }
}