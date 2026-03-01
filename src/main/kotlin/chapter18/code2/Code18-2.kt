package chapter18.code2

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
  val flow = channelFlow<String> {
    awaitClose {
      println("리소스 정리")
    }
  }

  // 수집 코루틴 실행
  val job = launch {
    flow.collect { }
  }

  // 수집 코루틴 취소
  delay(100L)
  job.cancel()
}