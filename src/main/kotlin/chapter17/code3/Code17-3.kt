package chapter17.code3

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>()

  launch {
    channel.send("데이터1")
    channel.send("데이터2")
    channel.close() // Channel 닫기
  }

  launch {
    for (data in channel) {
      println("$data 수신")
    }
  }
}