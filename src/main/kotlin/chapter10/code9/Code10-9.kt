package chapter10.code9

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val dataFlow = flow {
    emit("데이터1")
    emit("데이터2")
    emit("데이터3")
  }

  val job: Job = dataFlow.onEach { data ->
    println("$data 처리")
  }.launchIn(this) // runBlocking 코루틴의 CoroutineScope에서 실행
}