package chapter10.code3

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking
import java.io.IOException

fun main() = runBlocking<Unit> {
  flow {
    emit(1)
    emit(2)
    throw IOException("입출력 도중 예외 발생")
    emit(3)
  }.onCompletion { cause ->
    if (cause == null) {
      println("Flow 수집이 완료됐습니다")
    } else {
      println("[${cause}] Flow 수집이 취소됐습니다")
    }
  }.collect { value ->
    println("$value 수집")
  }
}