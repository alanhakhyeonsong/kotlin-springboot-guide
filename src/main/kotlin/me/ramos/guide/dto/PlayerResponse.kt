package me.ramos.guide.dto

import me.ramos.guide.domain.Player

data class PlayerResponse(
    val name: String,
    val backNumber: Int,
    val nationality: String,
    val teamName: String,
    val league: String
) {
    companion object {
        fun from(entity: Player): PlayerResponse =
            PlayerResponse(
                name = entity.name,
                backNumber = entity.backNumber,
                nationality = entity.nationality,
                teamName = entity.team?.name ?: "",
                league = entity.team?.league ?: ""
            )
    }
}
