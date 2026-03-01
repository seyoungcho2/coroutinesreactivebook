package chapter18.code3

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

val counterFlow: Flow<Int> = callbackFlow {
  val timer = Timer()
  var count = 1

  timer.scheduleAtFixedRate(
    object : TimerTask() {
      override fun run() {
        println("$count 방출")
        trySend(count)
        count++
      }
    },
    0L, // 타이머 시작 지연 시간
    1000L // 1초마다 실행
  )

  awaitClose {
    println("수집이 종료돼 Timer를 해제합니다")
    timer.cancel()
  }
}

fun main() = runBlocking<Unit> {
  val job = launch {
    counterFlow.collect { count ->
      println("$count 수집")
    }
  }

  delay(2500L)
  println("counterFlow 수집 취소")
  job.cancel()
}
