package chapter2.code4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  launch {
    println("서버로부터 데이터 가져오기 시작")
    val serverData = fetchData()
    println("$serverData 가져오기 완료")
  }
  delay(500L)
  println("다른 작업 처리")
}

suspend fun fetchData(): String {
  delay(1000L)
  return "서버 데이터"
}