package chapter10.code10

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val dataFlow = flow {
    while (true) {
      emit("데이터")
      delay(100L)
    }
  }

  dataFlow.onEach { data ->
    println("[${Thread.currentThread().name}] $data 처리")
  }.launchIn(this)

  dataFlow.onEach { data ->
    println("[${Thread.currentThread().name}] $data 처리")
  }.launchIn(this)
}