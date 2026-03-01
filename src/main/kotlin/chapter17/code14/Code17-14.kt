package chapter17.code14

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
suspend fun calculateAndSendToChannel(channel: Channel<String>) {
  if(channel.isClosedForSend) {
    println("Channel이 이미 닫혔기 때문에 연산을 수행하지 않습니다.")
    return
  } else {
    // 오래 걸리는 연산 수행 후 송신
    Thread.sleep(10000L)
    channel.send("데이터")
  }
}
