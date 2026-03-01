package chapter7.code13

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow: Flow<Int> = flow {
    launch { // 방출 시 실행 코루틴 변경 금지
      emit(1)
    }
  }

  numberFlow.collect { number ->
    println("$number 수집")
  }
}