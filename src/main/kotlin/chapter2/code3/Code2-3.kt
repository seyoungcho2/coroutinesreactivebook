package chapter2.code3

import kotlin.concurrent.thread

fun main() {
  fetchData { serverData ->
    processData(serverData) { processedData ->
      saveToDatabase(processedData) { isSuccess ->
        if (isSuccess) {
          println("저장 완료")
        } else {
          println("저장 실패")
        }
      }
    }
  }
}

fun fetchData(onSuccess: (String) -> Unit) {
  thread {
    Thread.sleep(1000L) // 서버에서 데이터를 가져오는 시간
    onSuccess("서버 데이터") // 데이터를 가져온 후 콜백 호출
  }
}

fun processData(serverData: String, onSuccess: (String) -> Unit) {
  thread {
    onSuccess("처리된 $serverData") // 서버 데이터를 처리한 후 콜백 호출
  }
}

fun saveToDatabase(processedData: String, onSuccess: (Boolean) -> Unit) {
  thread {
    onSuccess(true)
  }
}