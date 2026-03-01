package chapter5.code16

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val numberFlow: Flow<Int> = flow {
  println("1이 방출됩니다")
  emit(1)
  println("2이 방출됩니다")
  emit(2)
}

//fun main() = runBlocking<Unit> {
//  numberFlow.map {
//    println("${it}이 변환됩니다")
//    it * 2
//  }
//}

fun main() = runBlocking<Unit> {
  val doubledFlow = numberFlow.map {
    println("${it}이 변환됩니다")
    it * 2
  }.collect { }
}