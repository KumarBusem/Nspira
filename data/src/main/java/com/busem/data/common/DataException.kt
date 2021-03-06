package com.busem.data.common

sealed class DataException : Exception() {

    abstract override val message: String

    class UnauthorizedException(override val message: String) : DataException()
    class SocketTimeoutException(override val message: String) : DataException()
    class ApiException(override val message: String) : DataException()
}
