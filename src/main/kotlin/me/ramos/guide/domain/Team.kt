package me.ramos.guide.domain

import jakarta.persistence.*

@Entity
@Table(name = "teams")
class Team(
    @Column(name = "name", nullable = false, length = 50, unique = true)
    var name: String,
    @Column(name = "league", nullable = false)
    var league: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "team")
    val players: MutableList<Player> = mutableListOf()
}