package chapter15.code5

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

  // 마지막 방출 2000밀리초 후에 replayCache 제거
  val sharedDataFlow = dataFlow.shareIn(
    scope = this@runBlocking,
    started = SharingStarted.WhileSubscribed(
      stopTimeoutMillis = 1000L,
      replayExpirationMillis = 2000L
    ),
    replay = 2 // replayCache 크기 2로 설정
  )

  val collectJob = launch {
    delay(500L)
    sharedDataFlow.collect {
      println("[${getElapsedTime(startTime)}] 데이터가 수집됐습니다")
    }
  }

  // 1000밀리초마다 replayCache에 저장된 원소 출력
  launch {
    while (true) {
      delay(1000L)
      println("[${getElapsedTime(startTime)}] replayCache: ${sharedDataFlow.replayCache}")
    }
  }

  // 2000밀리초에 sharedDataFlow 수집 취소
  delay(2000L)
  println("[${getElapsedTime(startTime)}] sharedDataFlow 수집이 취소됩니다")
  collectJob.cancel()
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"