package chapter15.code2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val dataFlow: Flow<String> = flow {
    while (true) {
      println("dataFlow에서 데이터가 방출됩니다")
      emit("데이터")
      delay(1000L)
    }
  }

  // 구독자가 없더라도 dataFlow 수집 시작
  val sharedDataFlow = dataFlow.shareIn(
    scope = this@runBlocking,
    started = SharingStarted.Eagerly,
    replay = 0
  )
}