package me.ramos.guide.config

import jakarta.annotation.PreDestroy
import org.springframework.boot.test.context.TestConfiguration
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container

@TestConfiguration("TestMySQLContainer")
class TestMySQLContainer {

    @PreDestroy
    fun stop() {
        container.stop()
    }

    companion object {
        @Container
        @JvmStatic
        val container = MySQLContainer<Nothing>("mysql:8.0.19")
            .apply {
                withDatabaseName("test")
                withUsername("root")
                withPassword("root")
            }
            .apply {
                start()
            }
    }
}