package chapter17.code21

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED

// 이 두 Channel은 같은 동작을 한다.
val channel1 = Channel<String>(capacity = BUFFERED)
val channel2 = Channel<String>(capacity = 64)
