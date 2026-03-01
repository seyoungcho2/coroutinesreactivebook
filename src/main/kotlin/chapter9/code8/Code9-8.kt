package chapter9.code8

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  flow<String> {
    throw Exception("flow 함수의 람다식에서 예외 발생")
  }.catch { exception ->
    println("첫 번째 catch >> $exception")
    throw exception
  }.map { value ->
    "변환된 데이터"
  }.catch { exception ->
    println("두 번째 catch >> $exception")
  }.collect { }
}