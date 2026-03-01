package chapter5.code14

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  emit(1)
  emit(2)
  emit(3)
}

val processedOddNumberFlow: Flow<String> =
  numberFlow.mapNotNull { it ->
    // 짝수일 경우 처리가 불가해 null 반환
    if (it % 2 == 0) return@mapNotNull null

    // 홀수일 경우 처리된 결과 반환
    return@mapNotNull "처리된 $it"
  }

fun main() = runBlocking<Unit> {
  processedOddNumberFlow.collect {
    println(it)
  }
}