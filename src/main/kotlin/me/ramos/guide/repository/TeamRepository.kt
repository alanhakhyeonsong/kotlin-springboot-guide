package me.ramos.guide.repository

import me.ramos.guide.domain.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TeamRepository : JpaRepository<Team, Long> {

    @Query("select distinct t from Team t left join fetch t.players")
    fun findAllWithPlayer(): List<Team>
}