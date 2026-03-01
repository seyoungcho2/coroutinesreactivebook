package chapter17.code26

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
  val channel1 = produce {
    send("[channel1] 데이터1")
    send("[channel1] 데이터2")
  }

  val channel2 = produce {
    send("[channel2] 데이터1")
    send("[channel2] 데이터2")
  }

  val fanInChannel = produce<String>(context = Dispatchers.IO) {
    launch {
      for (data in channel1) {
        send(data)
      }
    }
    launch {
      for (data in channel2) {
        send(data)
      }
    }
  }

  fanInChannel.consumeEach { data ->
    println("$data 수신")
  }
}