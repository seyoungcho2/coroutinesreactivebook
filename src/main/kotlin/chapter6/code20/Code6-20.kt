package chapter6.code20

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val infiniteFlow: Flow<Int> = flow {
  while (true) {
    val randomValue = (1..10).random()
    emit(randomValue)
    delay(1000L)
  }
}

fun main() = runBlocking<Unit> {
  val count = infiniteFlow.count()
  println("count: $count")
}