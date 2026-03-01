package chapter7.code14

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
  val numberFlow: Flow<Int> = flow {
    withContext(Dispatchers.IO) { // 방출 시 실행 컨텍스트 변경 금지
      emit(1)
    }
  }

  numberFlow.collect { number ->
    println("$number 수집")
  }
}