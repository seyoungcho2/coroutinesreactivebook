package chapter16.code11

import app.cash.turbine.test
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `turbine 테스트 기초`() = runTest {
    flow {
      for (number in 1..3) {
        emit(number)
      }
    }.test {
      // validate 람다식에 테스트 작성
    }
  }
}