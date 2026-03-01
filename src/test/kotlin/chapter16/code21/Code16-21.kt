package chapter16.code21

import app.cash.turbine.test
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `SharedFlow 테스트`() = runTest {
    val sharedFlow = MutableSharedFlow<Int>()

    sharedFlow.test {
      sharedFlow.emit(1)
      assertEquals(1, awaitItem())
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun `StateFlow 테스트`() = runTest {
    val stateFlow = MutableStateFlow<Int>(0)

    stateFlow.test {
      assertEquals(0, awaitItem()) // 초기 상태 수신
      stateFlow.update { 1 }
      assertEquals(1, awaitItem())
      cancelAndIgnoreRemainingEvents()
    }
  }
}