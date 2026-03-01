package chapter16.code13

import app.cash.turbine.test
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `cancelAndIgnoreRemainingEvents 사용해 Flow 수집 취소하고 남은 이벤트 무시하기`() = runTest {
    flow {
      var number = 1
      while (true) {
        emit(number)
        number += 1
        delay(100L)
      }
    }.test {
      assertEquals(1, awaitItem())
      assertEquals(2, awaitItem())
      assertEquals(3, awaitItem())
      cancelAndIgnoreRemainingEvents() // Flow 취소 후 남은 이벤트 무시
    }
  }
}