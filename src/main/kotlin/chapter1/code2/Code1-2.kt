package chapter1.code2

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val flow = flow {
    println("[${Thread.currentThread().name}] Hello 데이터 생산")
    emit("Hello")
    println("[${Thread.currentThread().name}] Flow 데이터 생산")
    emit("Flow")
  }

  flow.collect {
    println("[${Thread.currentThread().name}] ${it} 데이터 소비")
    println(it)
  }
}