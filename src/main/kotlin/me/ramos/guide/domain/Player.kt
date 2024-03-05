package me.ramos.guide.domain

import jakarta.persistence.*

@Entity
@Table(name = "players")
class Player(
    @Column(name = "name", nullable = false, length = 50)
    var name: String,
    @Column(name = "back_number")
    var backNumber: Int,
    @Column(name = "nationality", nullable = false, length = 50)
    var nationality: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team? = null

    fun updateBackNumber(backNumber: Int) {
        this.backNumber = backNumber;
    }

    // 연관관계 편의 메소드
    fun initTeam(team: Team?) {
        this.team = team
        if (team != null && !team.players.contains(this)) {
            team.players.add(this)
        }
    }
}