package chapter17.code2

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>()

  launch {
    channel.send("데이터1")
    channel.send("데이터2")
  }

  launch {
    // for문 사용해 데이터 반복 수신
    for (data in channel) {
      println("$data 수신")
    }
  }
}