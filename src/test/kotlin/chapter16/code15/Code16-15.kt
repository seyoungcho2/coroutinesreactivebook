package chapter16.code15

import app.cash.turbine.test
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `awaitError 사용해 예외 테스트하기`() = runTest {
    flow<Int> {
      throw IllegalStateException("Test Exception")
    }.test {
      val throwable = awaitError() // 예외 발생 단언
      assert(throwable is IllegalStateException) // 발생된 예외 검증
    }
  }
}