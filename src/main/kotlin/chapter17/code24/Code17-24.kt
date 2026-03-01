package chapter17.code24

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<Int>(0)

  launch {
    repeat(100) {
      channel.send(it)
    }
  }

  val result = run {
    channel.consumeEach { data ->
      if (data == 10) {
        println("$data 수신됨: 원하는 데이터입니다")
        return@run "데이터 처리 성공"
      } else {
        println("$data 수신됨: 원하는 데이터가 아닙니다")
      }
    }
  }

  println(result)
}