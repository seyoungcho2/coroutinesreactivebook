package chapter15.code4

import chapter15.code3.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()

  val dataFlow: Flow<String> = flow {
    while (true) {
      println("[${getElapsedTime(startTime)}] dataFlow에서 데이터가 방출됩니다")
      emit("데이터")
      delay(1000L)
    }
  }

  // 3000밀리초간 데이터 생성 및 방출 유지
  val sharedDataFlow = dataFlow.shareIn(
    scope = this@runBlocking,
    started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 3000L),
    replay = 0
  )

  val collectJob = launch {
    delay(500L)
    sharedDataFlow.collect {
      println("[${getElapsedTime(startTime)}] 데이터가 수집됐습니다")
    }
  }

  // 2000밀리초에 sharedDataFlow 수집 취소
  delay(2000L)
  println("[${getElapsedTime(startTime)}] sharedDataFlow 수집이 취소됩니다")
  collectJob.cancel()
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"