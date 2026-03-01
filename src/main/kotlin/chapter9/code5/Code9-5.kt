package chapter9.code5

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  flow {
    emit("데이터")
  }.handleException { e ->
    println("Exception: $e")
  }.collect { value ->
    throw Exception("수집 시 예외 발생")
  }
}

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