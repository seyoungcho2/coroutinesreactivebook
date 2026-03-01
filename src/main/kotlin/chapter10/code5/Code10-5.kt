package chapter10.code5

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.io.IOException

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    emit(1)
    emit(2)
    throw IOException("입출력 도중 예외 발생")
    emit(3)
  }

  var cause: Throwable? = null
  try {
    numberFlow.collect { value ->
      println("$value 수집")
    }
  } catch (e: Throwable) {
    cause = e // 예외 발생 시 cause에 할당
    throw e
  } finally {
    if (cause == null) { // cause가 null일 경우의 동작
      println("Flow 수집이 완료 되었습니다")
    } else { // cause가 null이 아닐 경우의 동작
      println("[${cause}] Flow 수집이 취소 되었습니다")
    }
  }
}