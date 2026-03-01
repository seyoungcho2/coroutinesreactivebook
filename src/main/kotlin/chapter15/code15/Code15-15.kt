package chapter15.code15

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.runBlocking

private val mutableSharedFlow = MutableSharedFlow<String>()
val sharedFlow: SharedFlow<String> = mutableSharedFlow

fun main() = runBlocking<Unit> {
  (sharedFlow as MutableSharedFlow).emit("임의의 값")
}
