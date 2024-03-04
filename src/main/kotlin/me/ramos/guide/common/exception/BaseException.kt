package me.ramos.guide.common.exception

import me.ramos.guide.common.enum.CodeEnum

/**
 * Runtime Exception을 상속받은 공통 에러 포멧
 *
 * @param codeEnum error code, message의 enum
 */
class BaseException(codeEnum: CodeEnum) : RuntimeException(codeEnum.message) {
    val returnCode: Int;
    val returnMessage: String;

    init {
        this.returnCode = codeEnum.code
        this.returnMessage = codeEnum.message
    }
}