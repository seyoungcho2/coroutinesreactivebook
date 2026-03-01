package chapter16.code2

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlowTest {
  @Test
  fun `원소를 무한히 방출하는 Flow에 toList를 사용하면 실패한다`() = runBlocking {
    val infiniteNumberFlow = flow {
      var count = 1
      while (true) {
        emit(count)
        count += 1
      }
    }

    val collectedElements = infiniteNumberFlow.toList()

    assertEquals(listOf(1, 2, 3), collectedElements)
  }
}