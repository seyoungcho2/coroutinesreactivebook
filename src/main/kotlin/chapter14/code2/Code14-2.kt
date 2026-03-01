package chapter14.code2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  // 서버 인스턴스 생성
  val mockServer = MockServer()

  // 서버 실행
  launch(Dispatchers.IO) {
    mockServer.start()
  }

  // 서버 데이터를 가져오는 Flow 정의
  val serverDataFlow = flow {
    while (true) {
      val serverData = mockServer.fetchServerData()
      emit(serverData)
      delay(500L)
    }
  }

  // launch 코루틴1 생성 후 serverDataFlow 수집
  launch {
    serverDataFlow.collect {
      println("[launch 코루틴1] 서버 데이터 $it")
    }
  }

  delay(100L) // 100밀리초 대기

  // launch 코루틴2 생성 후 serverDataFlow 수집
  launch {
    serverDataFlow.collect {
      println("[launch 코루틴2] 서버 데이터 $it")
    }
  }
}

class MockServer() {
  private var serverData = 1

  suspend fun start() {
    while (true) {
      serverData = (1..10).random()
      delay(100L)
    }
  }

  suspend fun fetchServerData(): Int {
    return serverData
  }
}