package chapter15.code6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()

  val dataFlow: Flow<String> = flow {
    while (true) {
      delay(1000L) // 초기 상태 확인을 위해 첫 데이터 방출 전 delay 호출
      println("[${getElapsedTime(startTime)}] dataFlow에서 데이터가 방출됩니다")
      emit("데이터")
    }
  }

  val stateFlow = dataFlow.stateIn(
    scope = this@runBlocking,
    started = SharingStarted.Eagerly,
    initialValue = "초기 데이터"
  )

  // stateFlow 수집
  launch {
    stateFlow.collect { data ->
      println("[${getElapsedTime(startTime)}] ${data}가 수집됐습니다")
    }
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"