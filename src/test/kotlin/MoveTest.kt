import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MoveTest {

    @Test
    fun `Rock should beat Scissors`() {
        val move = Move.ROCK
        val beatenMove = move.beats()
        assertEquals(Move.SCISSORS, beatenMove)
    }

    @Test
    fun `Paper should beat Rock`() {
        val move = Move.PAPER
        assertEquals(Move.ROCK, move.beats())
    }

    @Test
    fun `Scissors should beat Paper`() {
        val move = Move.SCISSORS
        assertEquals(Move.PAPER, move.beats())
    }
}
