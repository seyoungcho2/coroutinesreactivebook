package chapter13.code2

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flattenConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

val flow1 = flow {
  emit("[flow1] 원소1")
  delay(100L)
  emit("[flow1] 원소2")
}

val flow2 = flow {
  emit("[flow2] 원소1")
  delay(100L)
  emit("[flow2] 원소2")
}

val nestedFlow: Flow<Flow<String>> = flowOf(flow1, flow2)

@OptIn(ExperimentalCoroutinesApi::class)
val flattenedFlow: Flow<String> = nestedFlow.flattenConcat()

fun main() = runBlocking<Unit> {
  flattenedFlow.collect {
    println(it)
  }
}