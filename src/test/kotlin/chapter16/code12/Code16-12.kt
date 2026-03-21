package chapter16.code12

import app.cash.turbine.test
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `awaitItem이 호출됐지만 원소 방출 이벤트가 없어서 실패하는 테스트`() = runTest {
    flow {
      for (number in 1..3) {
        emit(number)
      }
    }.test {
      val item1 = awaitItem() // 원소가 방출되기 때문에 단언 통과
      assertEquals(1, item1) // 단언 통과
      val item2 = awaitItem() // 원소가 방출되기 때문에 단언 통과
      assertEquals(2, item2) // 단언 통과
      val item3 = awaitItem() // 원소가 방출되기 때문에 단언 통과
      assertEquals(3, item3) // 단언 통과
      val item4 = awaitItem() // 원소가 방출되지 않으므로 단언 실패
    }
  }

  @Test
  fun `완료 이벤트가 소비되지 않아 실패하는 테스트`() = runTest {
    flow {
      for (number in 1..3) {
        emit(number)
      }
    }.test {
      val item1 = awaitItem()
      assertEquals(1, item1)
      val item2 = awaitItem()
      assertEquals(2, item2)
      val item3 = awaitItem()
      assertEquals(3, item3)
    }
  }

  @Test
  fun `awaitItem, awaitComplete 사용해 테스트하기`() = runTest {
    flow {
      for (number in 1..3) {
        emit(number)
      }
    }.test {
      val item1 = awaitItem()
      assertEquals(1, item1)
      val item2 = awaitItem()
      assertEquals(2, item2)
      val item3 = awaitItem()
      assertEquals(3, item3)
      awaitComplete() // awaitComplete으로 완료 이벤트 소비
    }
  }
}