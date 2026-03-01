package chapter17.code23

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>()

  launch {
    repeat(3) {
      try {
        channel.send("데이터")
      } catch (e: Exception) {
        println("데이터 송신 실패: $e")
      }
    }
  }

  channel.consume {
    val data = receive()
    println("$data 수신")
  }
}