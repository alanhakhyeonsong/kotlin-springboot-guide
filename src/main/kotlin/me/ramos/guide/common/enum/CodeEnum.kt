package me.ramos.guide.common.enum

import org.springframework.http.HttpStatus

/**
 * HttpResponse 공통 응답 코드
 *
 * @property code HttpStatus code
 * @property message Response Message
 * @constructor Create empty Code enum
 */
enum class CodeEnum(val code: Int, val message: String) {
    // 에러
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "잘못된 요청입니다"),
    PLAYER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "선수를 찾을 수 없습니다"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 에러"),
    // 정상 응답
    OK(HttpStatus.OK.value(), "success")
}