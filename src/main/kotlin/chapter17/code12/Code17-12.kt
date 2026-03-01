package chapter17.code12

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>(capacity = 2)

  channel.send("데이터1")
  channel.send("데이터2")
  channel.close() // Channel 닫기
  channel.send("데이터3") // 예외 발생
}
