package chapter15.code13

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class DataBroadcaster {
  // 객체 내부에서는 변경 가능한 MutableSharedFlow를 사용
  private val dataMutableSharedFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)

  // 외부에는 읽기 전용 SharedFlow로 노출
  val dataSharedFlow: SharedFlow<String> = dataMutableSharedFlow.asSharedFlow()

  // MutableSharedFlow에 데이터를 방출하기 위한 함수 정의
  // ...
}