package chapter18.code4

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
    0L,
    1000L
  )
  // awaitClose 호출 제거
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
