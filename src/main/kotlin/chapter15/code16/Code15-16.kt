package chapter15.code16

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.runBlocking

private val mutableSharedFlow = MutableSharedFlow<String>()
val sharedFlow: SharedFlow<String> = mutableSharedFlow.asSharedFlow()

fun main() = runBlocking<Unit> {
  (sharedFlow as MutableSharedFlow).emit("임의의 값 방출")
}