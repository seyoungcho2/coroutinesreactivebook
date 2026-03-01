package chapter17.code16

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>(capacity = 1)

  val result1 = channel.trySend("데이터1")
  println("데이터1 송신 결과 ${result1.isSuccess}")
  val result2 = channel.trySend("데이터2")
  println("데이터2 송신 결과 ${result2.isSuccess}")
}
