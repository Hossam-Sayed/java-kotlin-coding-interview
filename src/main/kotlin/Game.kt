import java.util.*

enum class Move {
    ROCK, PAPER, SCISSORS;

    fun beats(): Move = when (this) {
        ROCK -> SCISSORS
        PAPER -> ROCK
        SCISSORS -> PAPER
    }
}

enum class Result { WIN_A, WIN_B, DRAW }

fun determineOutcome(a: Move, b: Move): Result = when {
    a == b -> Result.DRAW
    a.beats() == b -> Result.WIN_A
    else -> Result.WIN_B
}

fun getPlayerAMove(random: Random = Random()): Move {
    return Move.values()[random.nextInt(Move.values().size)]
}

fun getPlayerBMove(): Move = Move.ROCK

fun main() {
    val totalRounds = 100
    var winsA = 0
    var winsB = 0
    var draws = 0

    repeat(totalRounds) {
        val aMove = getPlayerAMove()
        val bMove = getPlayerBMove()
        when (determineOutcome(aMove, bMove)) {
            Result.WIN_A -> winsA++
            Result.WIN_B -> winsB++
            Result.DRAW -> draws++
        }
    }

    println("Player A wins $winsA of $totalRounds games")
    println("Player B wins $winsB of $totalRounds games")
    println("Draws: $draws of $totalRounds games")
}
