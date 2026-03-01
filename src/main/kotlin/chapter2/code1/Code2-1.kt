package chapter2.code1

fun main() {
  val serverData = fetchData()
  val processedData = processData(serverData)

  println(processedData)
}

fun fetchData(): String {
  Thread.sleep(1000L) // 서버에서 데이터를 가져오는 시간
  return "서버 데이터"
}

fun processData(serverData: String): String {
  return "처리된 $serverData"
}