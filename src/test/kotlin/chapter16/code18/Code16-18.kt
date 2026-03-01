package chapter16.code18

import app.cash.turbine.test
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.time.Duration.Companion.seconds

class TurbineTest {
  @Test
  fun `기본 타임아웃으로 실패하는 테스트`() = runBlocking {
    val slowFlow = flow {
      delay(5000L)  // 5초 지연 후 데이터 방출
      emit("지연 데이터")
    }

    slowFlow.test {
      awaitItem() // 기본 타임아웃이 3초 이므로 실패
      awaitComplete()
    }
  }

  @Test
  fun `test에 timeout 설정해 타임아웃 시간 늘리기`() = runBlocking {
    val slowFlow = flow {
      delay(5000L)  // 5초 지연 후 데이터 방출
      emit("지연 데이터")
    }

    slowFlow.test(timeout = 10.seconds) {
      awaitItem() // 타임아웃이 10초 이므로 성공
      awaitComplete()
    }
  }

  @Test
  fun `runTest 가상 시간을 무시하는 타임아웃`() = runTest {
    val slowFlow = flow {
      delay(5000L)  // 5초 지연 후 데이터 방출
      emit("지연 데이터")
    }

    // 타임아웃이 1초이고 5초 지연 후 방출되지만, runTest의 가상 시간을 무시하므로 성공
    slowFlow.test(timeout = 1.seconds) {
      awaitItem()
      awaitComplete()
    }
  }
}