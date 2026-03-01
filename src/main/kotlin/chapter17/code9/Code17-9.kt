package chapter17.code9

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  // 버퍼의 크기가 2인 Channel 생성
  val channel = Channel<String>(
    capacity = 2,
    onUndeliveredElement = { data ->
      println("$data 버퍼에서 제거됨")
    }
  )

  // 데이터 두 번 송신 요청 후 곧바로 취소
  channel.send("데이터1")
  channel.send("데이터2")
  channel.cancel()
}
