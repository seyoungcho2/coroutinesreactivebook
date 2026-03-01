package chapter17.code5

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()

  // 버퍼의 크기가 1인 Channel 생성
  val channel = Channel<String>(capacity = 1)

  // 데이터 두 번 송신 요청
  launch {
    repeat(2) {
      println("[${getElapsedTime(startTime)}] 데이터${it} 송신 요청됨")
      channel.send("데이터${it}")
      println("[${getElapsedTime(startTime)}] 데이터${it} 송신 완료")
    }
  }

  // 데이터 두 번 수신 요청
  launch {
    repeat(2) {
      delay(1000L) // 1000밀리초 일시중단
      println("[${getElapsedTime(startTime)}] 수신 준비됨")
      val data = channel.receive()
      println("[${getElapsedTime(startTime)}] $data 수신 완료")
    }
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"