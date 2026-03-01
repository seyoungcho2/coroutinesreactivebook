package chapter6.code6

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

//val numberFlow: Flow<Int> = flow { }

val numberFlow: Flow<Int> = emptyFlow()

fun main() = runBlocking<Unit> {
  val firstValue: Int = numberFlow.first() // 첫 번째 값 가져오기
  println(firstValue)
}