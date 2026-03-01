package chapter16.code4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlowTest {
  @Test
  fun `toList 일시 중단 함수 사용해 첫 번째로 방출되는 값 테스트하기`() = runBlocking {
    val numberFlow = flow {
      for (number in 1..3) {
        emit(number)
        delay(1000L)
      }
    }

    val firstElement = numberFlow.toList()[0]

    assertEquals(1, firstElement)
  }
}