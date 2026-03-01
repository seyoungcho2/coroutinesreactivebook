package chapter13.code1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
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

val flattenedFlow: Flow<String> = flow { // 1. 새로운 Flow를 만든다.
  nestedFlow.collect { flow -> // 2. nestedFlow를 수집한다.
    // 3. nestedFlow에서 방출되는 각 Flow를 수집한다.
    flow.collect { value ->
      emit(value) // 4. 수집되는 값들을 새로운 Flow에 방출한다.
    }
  }
}

fun main() = runBlocking<Unit> {
  flattenedFlow.collect {
    println(it)
  }
}