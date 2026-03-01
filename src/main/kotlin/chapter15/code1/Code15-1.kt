package chapter15.code1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val numberFlow = flow {
    for (number in 0..3) {
      println("$number 방출")
      emit(number)
      delay(1000L)
    }
  }

  // SharedFlow로 변환 수행
  val sharedNumberFlow: SharedFlow<Int> =
    numberFlow.shareIn(
      scope = this@runBlocking,
      replay = 0
    )

  delay(500L)

  // 500밀리초 시점에 collect 수행
  launch {
    sharedNumberFlow.collect { number ->
      println("$number 수집")
    }
  }

  delay(1000L)

  // 1500밀리초 시점에 collect 수행
  launch {
    sharedNumberFlow.collect { number ->
      println("$number 수집")
    }
  }
}

fun <T> Flow<T>.shareIn(
  scope: CoroutineScope,
  replay: Int
): SharedFlow<T> {
  // 1. MutableSharedFlow 객체를 만든다.
  val sharedFlow = MutableSharedFlow<T>(replay = replay)

  // 2. launch 코루틴을 만들어 차가운 Flow를 수집한다.
  scope.launch {
    this@shareIn.collect {
      // 3. 수집된 원소를 MutableSharedFlow에 방출한다.
      sharedFlow.emit(it)
    }
  }

  return sharedFlow
}

