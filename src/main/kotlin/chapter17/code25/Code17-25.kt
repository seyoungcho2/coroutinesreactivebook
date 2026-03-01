package chapter17.code25

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
  val channel: ReceiveChannel<String> = produce(
    context = Dispatchers.IO, // 코루틴이 IO 스레드에서 실행되도록 설정
    capacity = 1 // 버퍼 크기 1로 설정
  ) { // block 람다식에서 send, trySend 사용해 데이터 송신
    println("[${Thread.currentThread().name}] 데이터1 송신")
    trySend("데이터1")
    println("[${Thread.currentThread().name}] 데이터2 송신")
    trySend("데이터2")
  }

  channel.consumeEach { data ->
    println("[${Thread.currentThread().name}] $data 수신")
  }
}