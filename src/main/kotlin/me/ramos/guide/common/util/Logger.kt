package me.ramos.guide.common.util

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging

/**
 * Slf4j를 대신하여 Kotlin Logging을 사용할 Util class
 *
 * @see https://github.com/oshai/kotlin-logging
 */
class Logger {
    companion object {
        inline val <reified T> T.log: KLogger
            get() = KotlinLogging.logger(T::class.java.name)
    }
}