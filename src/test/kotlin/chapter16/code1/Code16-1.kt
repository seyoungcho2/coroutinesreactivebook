package chapter16.code1

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlowTest {
  @Test
  fun `toList 사용해 Flow 테스트하기`() = runBlocking {
    val collectedElements = flowOf(1, 2, 3).toList()

    assertEquals(listOf(1, 2, 3), collectedElements)
  }
}
