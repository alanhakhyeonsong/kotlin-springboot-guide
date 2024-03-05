package me.ramos.guide.controller

import me.ramos.guide.common.enum.CodeEnum
import me.ramos.guide.common.response.ApiResponse
import me.ramos.guide.dto.PlayerResponse
import me.ramos.guide.service.PlayerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/players")
class PlayerController(
    private val playerService: PlayerService
) {

    @GetMapping("/{playerId}")
    fun retrievePlayer(@PathVariable playerId: Long): ResponseEntity<ApiResponse<PlayerResponse>> {
        val result = playerService.findByPlayerId(playerId)
        return ResponseEntity.ok()
            .body(ApiResponse(CodeEnum.OK.code, CodeEnum.OK.message, result))
    }

    @GetMapping
    fun retrieveAllPlayers(): ResponseEntity<ApiResponse<List<PlayerResponse>>> {
        val result = playerService.findAll()
        return ResponseEntity.ok()
            .body(ApiResponse(CodeEnum.OK.code, CodeEnum.OK.message, result))
    }
}