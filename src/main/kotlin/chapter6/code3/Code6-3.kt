package chapter6.code3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val infiniteFlow: Flow<Int> = flow {
  while (true) {
    val randomValue = (1..10).random()
    emit(randomValue)
    delay(1000L)
  }
}

//fun main() = runBlocking<Unit> {
//  infiniteFlow.collect { value ->
//    println(value)
//  }
//  println("Flow collect 완료")
//}

fun main() = runBlocking<Unit> {
  // launch 코루틴이 infiniteFlow를 collect
  launch {
    infiniteFlow.collect { value ->
      println(value)
    }
  }
  // runBlocking 코루틴이 다른 작업 실행
  delay(500L)
  println("다른 작업 실행")
}