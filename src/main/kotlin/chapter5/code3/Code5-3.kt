package chapter5.code3

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//fun <T, R> Flow<T>.map(
//  transform: suspend (value: T) -> R
//): Flow<R> = flow { // 1. 새로운 Flow를 만든다.
//  collect { value -> // 2. 기존 Flow를 collect 한다.
//    // 3. 수집된 원소에 변환 로직을 적용한다.
//    val transformedValue = transform(value)
//    // 4. 변환된 원소를 새로운 Flow에 방출한다.
//    emit(transformedValue)
//  }
//}

inline fun <T, R> Flow<T>.map(
  crossinline transform: suspend (value: T) -> R
): Flow<R> = flow { // 1. 새로운 Flow를 만든다.
  collect { value -> // 2. 기존 Flow를 collect 한다.
    // 3. 수집된 원소에 변환 로직을 적용한다.
    val transformedValue = transform(value)
    // 4. 변환된 원소를 새로운 Flow에 방출한다.
    emit(transformedValue)
  }
}