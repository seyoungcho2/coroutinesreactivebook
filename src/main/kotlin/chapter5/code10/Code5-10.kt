package chapter5.code10

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.distinctUntilChanged(): Flow<T> =
  // 1. 새로운 Flow를 생성한다.
  flow {
    var previousValue: T? = null // 2. 이전 값을 저장할 변수를 만든다.
    collect { currentValue -> // 3. 기존 Flow를 collect 한다.
      // 4. 이전 값과 현재 값을 비교한다.
      if (previousValue == null || previousValue != currentValue) {
        // 5-1. 이전 값과 현재 값이 다르면 방출한다.
        emit(currentValue)
        // 5-2. 새로운 값이 방출될 경우 이전 값을 갱신한다.
        previousValue = currentValue
      }
    }
  }