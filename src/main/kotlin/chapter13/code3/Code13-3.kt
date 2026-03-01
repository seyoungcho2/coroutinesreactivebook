package chapter13.code3

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

val userInputFlow = flowOf("노트북", "휴대폰")

fun search(userInput: String): Flow<List<String>> {
  return flow {
    val searchResult = when (userInput) {
      "노트북" -> listOf("A사 노트북", "B사 노트북")
      "휴대폰" -> listOf("A사 휴대폰", "B사 휴대폰")
      else -> listOf()
    }
    emit(searchResult)
  }
}

//val searchResultsNestedFlow: Flow<Flow<List<String>>> =
//  userInputFlow.map { search(it) }

//val searchResultsFlow: Flow<List<String>> =
//  userInputFlow.map { search(it) }
//    .flattenConcat()

@OptIn(ExperimentalCoroutinesApi::class)
val searchResultsFlow: Flow<List<String>> =
  userInputFlow.flatMapConcat { search(it) }

fun main() = runBlocking<Unit> {
  searchResultsFlow.collect { searchResults ->
    // 검색 결과 처리
    println("검색 결과: ${searchResults.joinToString(", ")}")
  }
}