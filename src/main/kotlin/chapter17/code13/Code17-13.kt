package chapter17.code13

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking<Unit> {
  val channel = Channel<String>()

  println("[close 호출 이전] isClosedForSend: ${channel.isClosedForSend}")
  channel.close() // Channel 닫기
  println("[close 호출 이후] isClosedForSend: ${channel.isClosedForSend}")
}