package chapter5.code6

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

// 로그 레벨을 나타내는 Enum
enum class LogLevel {
  DEBUG, INFO, WARN, ERROR, FATAL
}

// 로그 데이터를 나타내는 데이터 클래스
data class LogMessage(val level: LogLevel, val message: String)

val logStream: Flow<LogMessage> = flowOf(
  LogMessage(LogLevel.DEBUG, "[Debug] 시스템을 시작합니다"),
  LogMessage(LogLevel.INFO, "[Info] 시스템이 정상 작동 중입니다"),
  LogMessage(LogLevel.WARN, "[Warning] 메모리 사용량이 증가하고 있습니다"),
  LogMessage(LogLevel.ERROR, "[Error] 데이터베이스 연결 실패"),
  LogMessage(LogLevel.FATAL, "[Fatal] 시스템 크래시가 감지됐습니다"),
)

val productionLogStream: Flow<LogMessage> = logStream
  .filter { it.level >= LogLevel.ERROR } // ERROR 이상 레벨만 필터링

fun main() = runBlocking {
  productionLogStream.collect {
    println(it.message)
  }
}