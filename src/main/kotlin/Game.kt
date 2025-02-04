import java.util.*

/**
 * Enum representing the possible moves in Rock-Paper-Scissors.
 */
enum class Move {
    ROCK, PAPER, SCISSORS;

    /**
     * Determines which move this move beats.
     * @return the move that this move beats
     */
    fun beats(): Move = when (this) {
        ROCK -> SCISSORS
        PAPER -> ROCK
        SCISSORS -> PAPER
    }
}

/**
 * Enum representing the possible outcomes of a round.
 */
enum class Result { WIN_A, WIN_B, DRAW }

/**
 * Determines the outcome of a round between two moves.
 * @param a the move chosen by Player A
 * @param b the move chosen by Player B
 * @return the result of the round
 */
fun determineOutcome(a: Move, b: Move): Result = when {
    a == b -> Result.DRAW
    a.beats() == b -> Result.WIN_A
    else -> Result.WIN_B
}

/**
 * Generates a random move for Player A.
 * @param random an optional Random instance for testability
 * @return a randomly selected Move
 */
fun getPlayerAMove(random: Random = Random()): Move {
    return Move.values()[random.nextInt(Move.values().size)]
}

/**
 * Player B always chooses ROCK.
 * @return the ROCK move
 */
fun getPlayerBMove(): Move = Move.ROCK

/**
 * Data class representing the results of a game simulation.
 * @property winsA Number of rounds won by Player A.
 * @property winsB Number of rounds won by Player B.
 * @property draws Number of rounds that ended in a draw.
 */
data class GameResults(val winsA: Int, val winsB: Int, val draws: Int)

/**
 * Simulates a Rock-Paper-Scissors game for a specified number of rounds.
 * @param totalRounds The number of rounds to simulate (default is 100).
 * @return An instance of [GameResults] containing the simulation results.
 */
fun simulateGame(totalRounds: Int = 100): GameResults {
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

    return GameResults(winsA, winsB, draws)
}

fun main() {
    val results = simulateGame()
    println("Player A wins ${results.winsA} of 100 games")
    println("Player B wins ${results.winsB} of 100 games")
    println("Draws: ${results.draws} of 100 games")
}
