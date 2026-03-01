package chapter15.code10

import chapter15.code5.getElapsedTime
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()

  val sharedFlow = MutableSharedFlow<String>()

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