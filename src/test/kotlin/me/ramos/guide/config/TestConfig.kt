package me.ramos.guide.config

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.boot.test.context.TestConfiguration

@TestConfiguration
class TestConfig(
    @PersistenceContext private val em: EntityManager
) {

    // TODO: QueryDSL 의존성 추가 시 Bean 등록
}