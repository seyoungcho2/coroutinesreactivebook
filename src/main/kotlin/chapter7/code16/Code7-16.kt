package chapter7.code16

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
  unsafeFlow {
    withContext(Dispatchers.IO) {
      emit(1)
    }
    emit(2)
    emit(3)
  }.collect {
    println("$it 수집")
  }
}

// 코루틴 라이브러리 내부의 unsafeFlow는 internal로 선언돼 있어 복사해 가져온다.
inline fun <T> unsafeFlow(crossinline block: suspend FlowCollector<T>.() -> Unit): Flow<T> {
  return object : Flow<T> {
    override suspend fun collect(collector: FlowCollector<T>) {
      collector.block()
    }
  }
}