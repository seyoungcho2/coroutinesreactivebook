package chapter16.code17

import app.cash.turbine.test
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `test에 name 설정하기`() = runTest {
    val singleFlow = flow {
      emit("데이터")
      emit("데이터")
    }

    singleFlow.test(
      name = "하나의 원소 방출 테스트"
    ) {
      assertEquals("데이터", awaitItem())
      awaitComplete()
    }
  }
}