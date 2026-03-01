package chapter9.code4

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun <T> Flow<T>.handleException(
  onException: (Exception) -> Unit
): Flow<T> = flow {
  try {
    collect { value ->
      emit(value)
    }
  } catch (e: Exception) {
    onException(e)
  }
}

fun main() = runBlocking<Unit> {
  val stringFlow = flow<String> {
    emit("데이터1")
    throw Exception("데이터2 생성 도중 예외 발생")
    emit("데이터2")
  }

  stringFlow.handleException { e ->
    println("Exception: $e")
  }.collect { value ->
    println(value)
  }
}