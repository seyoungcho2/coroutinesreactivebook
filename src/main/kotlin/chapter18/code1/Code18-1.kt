package chapter18.code1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val channelFlow: Flow<String> = channelFlow {
    launch { // 100밀리초 뒤에 데이터1 방출
      delay(100L)
      send("데이터1")
    }
    launch { // 200밀리초 뒤에 데이터2 방출
      delay(200L)
      send("데이터2")
    }
    launch { // 300밀리초 뒤에 데이터3 방출
      delay(300L)
      send("데이터3")
    }
  }

  channelFlow.collect { data ->
    println("$data 수집")
  }
}