package chapter16.code6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlowTest {
  @Test
  fun `시간의 흐름에 따라 변화하는 Flow 테스트`() = runBlocking {
    val numberFlow = flow {
      for (number in 1..3) {
        delay(2000L)
        emit(number)
      }
    }

    val collectedElements = mutableListOf<Int>()

    launch {
      numberFlow.collect {
        collectedElements.add(it)
      }
    }

    assertEquals(emptyList<Int>(), collectedElements) // 0초
    delay(3000L)
    assertEquals(listOf(1), collectedElements) // 3초
    delay(2000L)
    assertEquals(listOf(1, 2), collectedElements) // 5초
    delay(2000L)
    assertEquals(listOf(1, 2, 3), collectedElements) // 7초
  }
}