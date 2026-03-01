package chapter4.code4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

val valueFlow: Flow<String> = ::getValue.asFlow()

suspend fun getValue(): String {
  delay(1000L)
  return "단일 값"
}

fun main() = runBlocking<Unit> {
  valueFlow.collect { value ->
    println("$value 수집 완료")
  }
}