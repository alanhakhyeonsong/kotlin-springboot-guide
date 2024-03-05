package me.ramos.guide.service

import me.ramos.guide.dto.PlayerResponse

interface PlayerService {

    fun findByPlayerId(playerId: Long): PlayerResponse
    fun findAll(): List<PlayerResponse>
}