package chapter5.code13

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val nullableStringFlow: Flow<String?> = flow {
  emit("Hello")
  emit("Reactive Programming")
  emit(null)
}

//fun main() = runBlocking<Unit> {
//  nullableStringFlow.collect {
//    println(it)
//  }
//}

fun main() = runBlocking<Unit> {
  nullableStringFlow.collect {
    if (it == null) return@collect
    println(it) // null이 아닐 경우에만 출력
  }
}