package com.candledle.safeteen.data.network

import java.net.SocketTimeoutException

class HttpRequester {
    suspend fun<T> sendRequest(
        httpRequest: suspend () -> T,
    ) {
        try {
            httpRequest()
        } catch (e: retrofit2.HttpException) {
            val code = e.code()
            throw when (code) {
                400 -> BadRequestException()
                401 -> UnAuthorizationException()
                403 -> ForbiddenException()
                404 -> NotFoundException()
                409 -> ConflictException()
                in 500..599 -> OnServerException()
                else -> UnknownException()
            }
        } catch (e: KotlinNullPointerException) {
            throw e
        } catch (e: SocketTimeoutException) {
            throw TimeoutException()
        } catch (e: Throwable) {
            throw UnknownException()
        }
    }
}

class BadRequestException(): Throwable() // 400
class UnAuthorizationException(): Throwable() // 401
class ForbiddenException(): Throwable() // 403
class NotFoundException(): Throwable() // 404
class ConflictException(): Throwable() // 409
class OnServerException(): Throwable() // 500..599
class TimeoutException(): Throwable() // Timeout
class UnknownException(): Throwable() // UnknownException