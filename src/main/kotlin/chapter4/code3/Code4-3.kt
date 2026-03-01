package chapter4.code3

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

val listFlow: Flow<Int> = listOf(1, 2, 3).asFlow()
val arrayFlow: Flow<Int> = arrayOf(1, 2, 3).asFlow()
val sequenceFlow: Flow<Int> = sequenceOf(1, 2, 3).asFlow()