package chapter1.code1

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val flow = flow {
    emit("Hello")
    emit("Flow")
  }

  flow.collect {
    println(it)
  }
}