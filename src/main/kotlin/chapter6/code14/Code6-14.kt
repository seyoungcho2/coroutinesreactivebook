package chapter6.code14

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.runBlocking
import java.util.LinkedList

val numberFlow: Flow<Int> = flowOf(1, 2, 3)

fun main() = runBlocking<Unit> {
  val numberLinkedList: LinkedList<Int> =
    numberFlow.toCollection(LinkedList())
  println(numberLinkedList) // [1, 2, 3] 출력
}