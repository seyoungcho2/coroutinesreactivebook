package chapter17.code19

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED

// 이 두 Channel은 같은 동작을 한다.
val channel1 = Channel<String>(capacity = CONFLATED)
val channel2 = Channel<String>(
  capacity = 1,
  onBufferOverflow = BufferOverflow.DROP_OLDEST
)
