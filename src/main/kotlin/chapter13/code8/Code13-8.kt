package chapter13.code8

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun searchMessage(userInput: String): Flow<List<String>> {
  return flow {
    delay(300L) // 검색 실행 시간
    val searchResult = when (userInput) {
      "약" -> listOf("아프니까 약국에서 약 사와", "약속은 7시 30분이야")
      "약속" -> listOf("약속은 7시 30분이야")
      else -> listOf()
    }
    emit(searchResult)
  }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
  val userInputFlow = flow {
    emit("약")
    delay(200L)
    emit("약속")
  }

  val searchResultsFlow: Flow<List<String>> =
    userInputFlow.flatMapConcat {
      searchMessage(it)
    }

  searchResultsFlow.collect { searchResults ->
    // 검색 결과 처리
    println("검색 결과: ${searchResults.joinToString(", ")}")
  }
}