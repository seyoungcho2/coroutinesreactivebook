package chapter16.code3

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlowTest {
  @Test
  fun `take 함수 사용해 원소를 무한히 방출하는 Flow 테스트하기`() = runBlocking {
    val infiniteNumberFlow = flow {
      var count = 1
      while (true) {
        emit(count)
        count += 1
      }
    }

    val collectedElements = infiniteNumberFlow.take(3).toList()

    assertEquals(listOf(1, 2, 3), collectedElements)
  }
}