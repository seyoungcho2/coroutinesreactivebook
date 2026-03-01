package chapter9.code6

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  flow {
    emit("데이터1")
    throw Exception("데이터2 생성 도중 예외 발생")
    emit("데이터2")
  }.catch {
    println("Exception : $it")
  }.collect { value ->
    println(value)
  }
}