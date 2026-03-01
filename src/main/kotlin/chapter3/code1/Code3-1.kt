package chapter3.code1

fun main() {
  val intList: List<Int> = listOf(1, 2, 3)

  // 데이터 변환
  val squaredIntList = intList.map { value ->
    value * value
  }

  println(squaredIntList) // [1, 4, 9] 출력

  // 데이터 필터링
  val filteredIntList = intList.filter { value ->
    value >= 2
  }

  println(filteredIntList) // [2, 3] 출력
}