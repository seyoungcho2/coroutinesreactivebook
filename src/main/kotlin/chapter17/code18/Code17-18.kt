package chapter17.code18

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.onClosed
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.onSuccess
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
  val channel = Channel<String>(capacity = 1)

  val result1 = channel.trySendBlocking("데이터1")
  println("데이터1 송신 결과 ${result1.isSuccess}")
  val result2 = channel.trySendBlocking("데이터2") // 스레드 블로킹
  println("데이터2 송신 결과 ${result2.isSuccess}") // 출력되지 않음
}
