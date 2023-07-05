package com.candledle.safeteen.data.network

import retrofit2.http.Body
import retrofit2.http.POST

interface SafeteenApi {
    @POST(SafeTeenUrl.login)
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse

    @POST(SafeTeenUrl.signUp)
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest,
    )
}

data class LoginRequest(
    val email: String,
    val password: String,
)

data class LoginResponse(
    val accessToken: String,
)

data class SignUpRequest(
    val nickname: String,
    val email: String,
    val password: String,
)