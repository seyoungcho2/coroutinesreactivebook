package chapter4.code10

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

val numberFlow: Flow<Int> = flow {
  println("flow 함수의 람다식 실행 코루틴 ${coroutineContext[Job]}")
  println("flow 함수의 람다식 실행 코루틴의 부모 ${coroutineContext[Job]?.parent}")
  println("flow 함수의 람다식 실행 코루틴의 조상 ${coroutineContext[Job]?.parent?.parent}")
}

fun main() = runBlocking<Unit> {
  numberFlow
    .flowOn(Dispatchers.IO)
    .collect { }
  println("collect 일시 중단 함수 호출 코루틴 ${coroutineContext[Job]}")
}