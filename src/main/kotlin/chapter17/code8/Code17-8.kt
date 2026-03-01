package chapter17.code8

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>(
    capacity = 1,
    onBufferOverflow = BufferOverflow.DROP_OLDEST,
    onUndeliveredElement = { data ->
      println("$data 처리되지 못함") // 처리되지 못한 데이터 로깅
    }
  )

  launch {
    channel.send("데이터1")
    delay(100L)
    channel.send("데이터2")
    delay(100L)
    channel.send("데이터3")

    channel.close()
  }

  launch {
    for (data in channel) {
      println("$data 수신")
      delay(1000L)
    }
  }
}