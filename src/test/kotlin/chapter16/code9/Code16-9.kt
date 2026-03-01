package chapter16.code9

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlowTest {
  @Test
  fun `원소가 무한히 방출되는 Flow 테스트 통과`() = runTest {
    val infiniteNumberFlow = flow {
      var number = 0
      while (true) {
        delay(2000L)
        number += 1
        emit(number)
      }
    }

    val collectedElements = mutableListOf<Int>()

    val job = launch {
      infiniteNumberFlow.collect {
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
    job.cancel() // 취소 호출
  }
}