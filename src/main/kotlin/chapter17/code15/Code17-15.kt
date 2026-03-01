package chapter17.code15

import chapter17.code4.getElapsedTime
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()

  val channel = Channel<String>() // 버퍼 없는 Channel 생성

  launch {
    println("[${getElapsedTime(startTime)}] 데이터 송신 요청됨")
    channel.send("데이터")
    println("[${getElapsedTime(startTime)}] 데이터 송신 완료")
  }

  launch {
    delay(1000L) // 1000밀리초 일시중단
    channel.receive()
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"