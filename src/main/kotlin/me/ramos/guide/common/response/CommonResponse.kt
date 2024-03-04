package me.ramos.guide.common.response

/**
 * API 공통 응답 class
 *
 * @param T
 * @property returnCode
 * @property returnMessage
 * @property data
 * @constructor Create empty Common response
 */
data class CommonResponse<T>(
    val returnCode: Int,
    val returnMessage: String,
    val data: T? = null) {
}