package me.ramos.guide.service

import me.ramos.guide.common.enum.CodeEnum
import me.ramos.guide.common.exception.BaseException
import me.ramos.guide.dto.PlayerResponse
import me.ramos.guide.repository.PlayerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlayerServiceImpl(
    private val playerRepository: PlayerRepository
) : PlayerService {

    @Transactional(readOnly = true)
    override fun findByPlayerId(playerId: Long): PlayerResponse {
        val player = playerRepository.findByIdOrNull(playerId)
            ?: throw BaseException(CodeEnum.PLAYER_NOT_FOUND)
        return PlayerResponse.from(player)
    }

    @Transactional(readOnly = true)
    override fun findAll(): List<PlayerResponse> {
        return playerRepository.findAllWithTeam().map { PlayerResponse.from(it) }
    }
}