package chapter16.code14

import app.cash.turbine.test
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `expectMostRecentItem 사용해 특정 시점의 최신 원소 테스트하기`() = runTest {
    flow<Int> {
      var number = 1
      while (true) {
        emit(number)
        number += 1
        delay(100L)
      }
    }.test {
      delay(950L)
      assertEquals(10, expectMostRecentItem())
      cancelAndIgnoreRemainingEvents()
    }
  }
}