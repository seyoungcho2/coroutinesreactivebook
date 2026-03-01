package chapter7.code15

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow: Flow<Int> = flow {
    emit(1) // 허용
    coroutineScope {
      // runBlocking 코루틴에서 실행됨
      emit(2)
    }
  }

  numberFlow.collect { number ->
    println("$number 수집")
  }
}