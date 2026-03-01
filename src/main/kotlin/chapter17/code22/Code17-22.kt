package chapter17.code22

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channel = Channel<String>(capacity = BUFFERED)

  repeat(65) { it ->
    val repeatTime = it + 1
    val result = channel.trySend("데이터")
    println("[${repeatTime} 번째 trySend] ${result.isSuccess}")
  }
}