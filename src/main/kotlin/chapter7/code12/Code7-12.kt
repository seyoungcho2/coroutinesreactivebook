package chapter7.code12

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val coroutineContextA = CoroutineName("CoroutineContextA")
  val coroutineContextB = CoroutineName("CoroutineContextB") + Dispatchers.IO

  val flow = flowOf(1)
    .map { // coroutineContextB + coroutineContextA 를 사용해 실행
      println("[${Thread.currentThread().name}] map")
      it * 2
    }
    .flowOn(coroutineContextA)
    .filter { // coroutineContextB를 사용해 실행
      println("[${Thread.currentThread().name}] filter")
      it >= 2
    }
    .flowOn(coroutineContextB)
    .collect {
      println("[${Thread.currentThread().name}] collect")
    }
}