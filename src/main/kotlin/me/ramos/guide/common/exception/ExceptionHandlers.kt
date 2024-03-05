package me.ramos.guide.common.exception

import me.ramos.guide.common.enum.CodeEnum
import me.ramos.guide.common.response.CommonResponse
import me.ramos.guide.common.util.Logger.Companion.log
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlers {

    @ExceptionHandler(BaseException::class)
    fun handleCustomException(e: BaseException): ResponseEntity<CommonResponse<Nothing>> {
        // TODO: log format 정의할 것
        log.error { "message: ${e.returnMessage}, code: ${e.returnCode}"}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(CommonResponse(e.returnCode, e.returnMessage))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<CommonResponse<Nothing>> {
        // TODO: log format 정의할 것
        log.error { "message: ${e.message}, code: ${HttpStatus.INTERNAL_SERVER_ERROR.value()}"}
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(CommonResponse(CodeEnum.INTERNAL_SERVER_ERROR.code, CodeEnum.INTERNAL_SERVER_ERROR.message))
    }
}