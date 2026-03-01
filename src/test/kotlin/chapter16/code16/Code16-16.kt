package chapter16.code16

import app.cash.turbine.Event
import app.cash.turbine.test
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class TurbineTest {
  @Test
  fun `awaitEvent 사용해 이벤트 수신하기`() = runTest {
    flow<Int> {
      emit(1)
      emit(2)
    }.test {
      val itemEvent1 = awaitEvent()
      if (itemEvent1 is Event.Item<Int>) {
        println("${itemEvent1.value} Item Event 수신됨")
      }

      val itemEvent2 = awaitEvent()
      if (itemEvent2 is Event.Item<Int>) {
        println("${itemEvent2.value} Item Event 수신됨")
      }

      val completeEvent = awaitEvent()
      if (completeEvent is Event.Complete) {
        println("Complete Event 수신됨")
      }
    }
  }
}