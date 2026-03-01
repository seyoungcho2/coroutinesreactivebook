package chapter15.code8

import chapter15.code5.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()

  // 총 버퍼의 크기 1
  val sharedFlow = MutableSharedFlow<String>(
    replay = 0,
    extraBufferCapacity = 1
  )

  launch {
    sharedFlow.collect { value ->
      delay(1000L) // 처리에 1000밀리초 걸림
      println("[${getElapsedTime(startTime)}] $value 처리 완료")
    }
  }

  yield()

  println("[${getElapsedTime(startTime)}] 데이터1 방출 시작")
  sharedFlow.emit("데이터1")
  println("[${getElapsedTime(startTime)}] 데이터1 방출 완료")

  println("[${getElapsedTime(startTime)}] 데이터2 방출 시작")
  sharedFlow.emit("데이터2")
  println("[${getElapsedTime(startTime)}] 데이터2 방출 완료")

  println("[${getElapsedTime(startTime)}] 데이터3 방출 시작")
  sharedFlow.emit("데이터3")
  println("[${getElapsedTime(startTime)}] 데이터3 방출 완료")
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"