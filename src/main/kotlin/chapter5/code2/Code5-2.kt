package chapter5.code2

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

// 데이터 레이어
data class UserEntity(val id: Int, val username: String)

val userEntityFlow: Flow<UserEntity> = flow {
  emit(UserEntity(id = 1, username = "홍길동"))
  emit(UserEntity(id = 2, username = "조세영"))
}

// 도메인 레이어
data class User(val id: Int, val user: String)

val userFlow: Flow<User> = userEntityFlow.map { userEntity ->
  User(id = userEntity.id, user = userEntity.username)
}