package chapter17.code10

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  // 버퍼의 크기가 2인 Channel 생성
  val channel = Channel<String>(capacity = 2)

  // 데이터 두 번 송신 요청 후 곧바로 Channel 닫기
  launch {
    channel.send("데이터1")
    channel.send("데이터2")
    channel.close()
  }

  // 1000밀리초 일시중단 후 수신 요청
  launch {
    delay(1000L)
    repeat(2) {
      val data = channel.receive()
      println("$data 수신 완료")
    }
  }
}