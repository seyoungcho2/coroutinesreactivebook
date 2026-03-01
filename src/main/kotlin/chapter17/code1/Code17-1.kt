package chapter17.code1

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  // Channel 생성
  val channel = Channel<String>()

  // 데이터 송신 코루틴
  launch {
    channel.send("데이터1")
    channel.send("데이터2")
  }

  // 데이터 수신 코루틴
  launch {
    repeat(2) {
      val data = channel.receive()
      println("$data 수신")
    }
  }
}