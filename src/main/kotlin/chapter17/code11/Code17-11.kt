package chapter17.code11

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>(capacity = 2)

  // 데이터 두 번 송신 요청 후 곧바로 Channel 취소
  launch {
    channel.send("데이터1")
    channel.send("데이터2")
    channel.cancel()
  }

  launch {
    delay(1000L) // 1000밀리초 일시중단
    repeat(2) {
      val data = channel.receive()
      println("$data 수신 완료")
    }
  }
}