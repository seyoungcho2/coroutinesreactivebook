package chapter15.code14

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StateHolder {
  // 객체 내부에서는 변경 가능한 MutableStateFlow 사용
  private val mutableStateFlow: MutableStateFlow<String> = MutableStateFlow("초기 상태")

  // 외부에 노출 할 때는 변경 불가능한 StateFlow 사용
  val stateFlow: StateFlow<String> = mutableStateFlow.asStateFlow()

  // MutableStateFlow 데이터를 방출하기 위한 함수 정의
  // ...
}

