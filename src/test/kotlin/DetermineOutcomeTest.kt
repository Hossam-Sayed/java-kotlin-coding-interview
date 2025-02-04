import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DetermineOutcomeTest {

    @Test
    fun `Same moves should result in a draw`() {
        assertEquals(Result.DRAW, determineOutcome(Move.ROCK, Move.ROCK))
        assertEquals(Result.DRAW, determineOutcome(Move.PAPER, Move.PAPER))
        assertEquals(Result.DRAW, determineOutcome(Move.SCISSORS, Move.SCISSORS))
    }

    @Test
    fun `Rock should win against Scissors`() {
        assertEquals(Result.WIN_A, determineOutcome(Move.ROCK, Move.SCISSORS))
    }

    @Test
    fun `Paper should win against Rock`() {
        assertEquals(Result.WIN_A, determineOutcome(Move.PAPER, Move.ROCK))
    }

    @Test
    fun `Scissors should win against Paper`() {
        assertEquals(Result.WIN_A, determineOutcome(Move.SCISSORS, Move.PAPER))
    }

    @Test
    fun `Rock should lose against Paper`() {
        assertEquals(Result.WIN_B, determineOutcome(Move.ROCK, Move.PAPER))
    }

    @Test
    fun `Paper should lose against Scissors`() {
        assertEquals(Result.WIN_B, determineOutcome(Move.PAPER, Move.SCISSORS))
    }

    @Test
    fun `Scissors should lose against Rock`() {
        assertEquals(Result.WIN_B, determineOutcome(Move.SCISSORS, Move.ROCK))
    }
}
