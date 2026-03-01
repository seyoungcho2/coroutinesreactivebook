package chapter5.code7

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

inline fun <T> Flow<T>.filter(
  crossinline predicate: suspend (T) -> Boolean
): Flow<T> = flow { // 1. 새로운 Flow를 생성한다.
  collect { value -> // 2. 기존 Flow를 collect 한다.
    if (predicate(value)) { // 3. 수집된 원소가 조건을 만족하는지 확인한다.
      emit(value) // 4. 조건을 만족하면 새로운 Flow에 원소를 방출한다.
    }
  }
}