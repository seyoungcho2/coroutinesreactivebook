package chapter7.code15

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow: Flow<Int> = flow {
    emit(1) // 허용
    coroutineScope {
      // 실행 컨텍스트가 바뀌지 않기 때문에 허용
      emit(2)
    }
  }

  numberFlow.collect { number ->
    println("$number 수집")
  }
}