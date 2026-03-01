package chapter14.code5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val sharedFlow: MutableSharedFlow<Int> = MutableSharedFlow(replay = 2)

  launch {
    sharedFlow.emit(0) // 시작하자마자 0 방출 - replayCache: [0]
    delay(1000L)
    sharedFlow.emit(1) // 1000밀리초 후에 1 방출 - replayCache: [0, 1]
    delay(1000L)
    sharedFlow.emit(2) // 2000밀리초 후에 2 방출 - replayCache: [1, 2]
    delay(1000L)
    sharedFlow.emit(3) // 3000밀리초 후에 3 방출 - replayCache: [2, 3]
  }

  launch {
    delay(500L)
    sharedFlow.collect { value -> // 500밀리초에 첫 collect 호출
      println("첫 번째 collect를 통해 수집된 값: $value")
    }
  }

  launch {
    delay(1500L)
    sharedFlow.collect { value -> // 1500밀리초에 둘째 collect 호출
      println("두 번째 collect를 통해 수집된 값: $value")
    }
  }
}