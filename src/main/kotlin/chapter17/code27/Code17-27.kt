package chapter17.code27

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
  val sourceChannel = produce {
    repeat(5) {
      send("데이터${it + 1}")
    }
  }

  launch(Dispatchers.IO) {
    for (data in sourceChannel) {
      println("[launch 코루틴1] $data 처리")
    }
  }

  launch(Dispatchers.IO) {
    for (data in sourceChannel) {
      println("[launch 코루틴2] $data 처리")
    }
  }
}