package chapter14.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val numberFlow: Flow<Int> = flow {
    for (number in 1..3) {
      println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] $number 방출")
      emit(number)
      delay(1000L)
    }
  }

  launch(CoroutineName("Launch 코루틴1")) {
    numberFlow.collect { number -> // numberFlow에 대한 collect 호출
      println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] $number 처리")
    }
  }

  delay(500L) // 500밀리초 대기

  launch(CoroutineName("Launch 코루틴2")) {
    numberFlow.collect { number -> // numberFlow에 대한 collect 호출
      println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] $number 처리")
    }
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"