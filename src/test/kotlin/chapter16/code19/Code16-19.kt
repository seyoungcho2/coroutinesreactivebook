package chapter16.code19

import app.cash.turbine.ReceiveTurbine
import app.cash.turbine.turbineScope
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `turbineScope과 testIn 사용해 테스트 구성하기`() = runTest {
    turbineScope {
      val turbine: ReceiveTurbine<String> = flowOf("원소").testIn(backgroundScope)
      assertEquals("원소", turbine.awaitItem())
      turbine.awaitComplete()
    }
  }

  @Test
  fun `여러 Flow 한 번에 테스트하기`() = runTest {
    turbineScope {
      val turbine1 = flowOf("첫 번째 Flow의 원소").testIn(backgroundScope)
      val turbine2 = flowOf("두 번째 Flow의 원소").testIn(backgroundScope)
      assertEquals("첫 번째 Flow의 원소", turbine1.awaitItem())
      assertEquals("두 번째 Flow의 원소", turbine2.awaitItem())
      turbine1.awaitComplete()
      turbine2.awaitComplete()
    }
  }
}