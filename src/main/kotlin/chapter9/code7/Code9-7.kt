package chapter9.code7

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  flow {
    emit("데이터1")
    emit("데이터2")
  }.catch {
    println("Exception : $it")
  }.collect { value ->
    throw Exception("$value 처리 도중 예외 발생")
  }
}