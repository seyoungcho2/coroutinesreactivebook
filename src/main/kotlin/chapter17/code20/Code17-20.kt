package chapter17.code20

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>(capacity = CONFLATED)

  launch {
    channel.send("데이터1") // 버퍼에 저장됨, 버퍼: [데이터1]
    delay(100L)
    channel.send("데이터2") // 버퍼에 저장됨, 버퍼: [데이터2]
    delay(100L)
    channel.send("데이터3") // 버퍼의 데이터2 제거하고 저장됨, 버퍼: [데이터3]

    channel.close()
  }

  launch {
    for (data in channel) {
      delay(1000L)
      println("$data 수신")
    }
  }
}