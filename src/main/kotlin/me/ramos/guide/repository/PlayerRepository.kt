package me.ramos.guide.repository

import me.ramos.guide.domain.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PlayerRepository : JpaRepository<Player, Long> {

    @Query("select distinct p from Player p join fetch p.team")
    fun findAllWithTeam(): List<Player>
}