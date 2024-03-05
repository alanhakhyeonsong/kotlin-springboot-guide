package me.ramos.guide.common.exception

import me.ramos.guide.common.enum.CodeEnum
import me.ramos.guide.common.response.ApiResponse
import me.ramos.guide.common.util.Logger.Companion.log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlers {

    @ExceptionHandler(BaseException::class)
    fun handleCustomException(e: BaseException): ResponseEntity<ApiResponse<Nothing>> {
        // TODO: log format 정의할 것
        log.error { "message: ${e.returnMessage}, code: ${e.returnCode}"}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ApiResponse(e.returnCode, e.returnMessage))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Nothing>> {
        // TODO: log format 정의할 것
        log.error { "message: ${e.message}, code: ${HttpStatus.INTERNAL_SERVER_ERROR.value()}"}
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse(CodeEnum.INTERNAL_SERVER_ERROR.code, CodeEnum.INTERNAL_SERVER_ERROR.message))
    }
}