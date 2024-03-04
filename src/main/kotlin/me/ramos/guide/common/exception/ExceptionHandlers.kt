package me.ramos.guide.common.exception

import me.ramos.guide.common.enum.CodeEnum
import me.ramos.guide.common.response.CommonResponse
import me.ramos.guide.common.util.Logger.Companion.log
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlers {

    @ExceptionHandler(BaseException::class)
    fun handleCustomException(e: BaseException): CommonResponse<Nothing> {
        // TODO: log format 정의할 것
        log.error { "message: ${e.returnMessage}, code: ${e.returnCode}"}
        return CommonResponse(e.returnCode, e.returnMessage);
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: Exception): CommonResponse<Nothing> {
        // TODO: log format 정의할 것
        log.error { "message: ${e.message}, code: ${HttpStatus.INTERNAL_SERVER_ERROR.value()}"}
        return CommonResponse(CodeEnum.INTERNAL_SERVER_ERROR.code, CodeEnum.INTERNAL_SERVER_ERROR.message);
    }
}