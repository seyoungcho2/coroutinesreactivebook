package chapter7.code2

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.runBlocking

//fun main() = runBlocking<Unit> {
//  // Flow<Int>를 익명 객체로 구현
//  val numberFlow: Flow<Int> = object : Flow<Int> {
//    override suspend fun collect(collector: FlowCollector<Int>) {
//      // FlowCollector의 emit 메서드 사용
//      collector.emit(1)
//      collector.emit(2)
//    }
//  }
//
//  // FlowCollector<Int>를 익명 객체로 구현
//  numberFlow.collect(object : FlowCollector<Int> {
//    override suspend fun emit(value: Int) {
//      println("$value 수집")
//    }
//  })
//}

fun main() = runBlocking<Unit> {
  // 1. Flow<Int>를 익명 객체로 만들어 numberFlow에 할당한다.
  val numberFlow: Flow<Int> = object : Flow<Int> {
    // 3. collect 일시중단 함수가 실행된다.
    override suspend fun collect(collector: FlowCollector<Int>) {
      // 4. collector에 대해 emit(1)을 호출한다.
      collector.emit(1)
      // 6. collector에 대해 emit(2)을 호출한다.
      collector.emit(2)
    }
  }

  // 2. numberFlow의 collect 일시중단 함수를 호출한다.
  numberFlow.collect(object : FlowCollector<Int> {
    // 5. emit 일시중단 함수가 실행된다.
    // 7. emit 일시중단 함수가 실행된다.
    override suspend fun emit(value: Int) {
      println("$value 수집")
    }
  })
}