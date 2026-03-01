package chapter17.code17

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.onClosed
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.onSuccess
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>(capacity = 1)

  channel.trySend("데이터")
    .onSuccess {
      println("데이터 송신에 성공했습니다")
    }.onFailure {
      println("데이터 송신에 실패했습니다")
    }.onClosed {
      println("Channel이 닫혀 데이터 송신에 실패했습니다")
    }
}
