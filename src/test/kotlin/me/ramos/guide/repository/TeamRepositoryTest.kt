package me.ramos.guide.repository

import me.ramos.guide.config.DataSourceConfig
import me.ramos.guide.config.TestConfig
import me.ramos.guide.config.TestMySQLContainer
import me.ramos.guide.domain.Team
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.Import
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
@Import(TestConfig::class, TestMySQLContainer::class, DataSourceConfig::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class TeamRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val teamRepository: TeamRepository
) {

    @Test
    internal fun findById() {
        val team = Team("Real Madrid C.F", "La Liga")
        entityManager.persist(team)
        entityManager.flush()

        val found = teamRepository.findByIdOrNull(team.id)

        assertThat(found).isEqualTo(team)
        assertThat(found?.name).isEqualTo(team.name)
        assertThat(found?.league).isEqualTo(team.league)
    }
}