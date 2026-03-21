package chapter16.code20

import app.cash.turbine.ReceiveTurbine
import app.cash.turbine.testIn
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `turbineScope를 사용하지 않고 testIn 함수 호출시 예외가 발생한다`() = runTest {
    val turbine: ReceiveTurbine<String> = flowOf("원소").testIn(backgroundScope)
    assertEquals("원소", turbine.awaitItem())
    turbine.awaitComplete()
  }
}