import org.junit.jupiter.api.Test
import java.util.*
import kotlin.math.absoluteValue
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PlayerAMoveTest {

    @Test
    fun `Player A should make a valid move`() {
        val random = Random(0)
        val move = getPlayerAMove(random)
        assertTrue(move in Move.values())
    }

    @Test
    fun `Multiple calls should return different moves`() {
        val random = Random(42)
        val moves = List(10) { getPlayerAMove(random) }
        assertTrue(moves.distinct().size > 1) // Expect some randomness
    }

    @Test
    fun `Random player should have roughly equal move distribution`() {
        val random = Random(42)
        val moves = List(1000) { getPlayerAMove(random) }

        val rockCount = moves.count { it == Move.ROCK }
        val paperCount = moves.count { it == Move.PAPER }
        val scissorsCount = moves.count { it == Move.SCISSORS }

        val total = rockCount + paperCount + scissorsCount
        val expectedPercentage = total / 3.0

        assertEquals(1000, total)
        assertTrue((rockCount - expectedPercentage).absoluteValue < 50)
        assertTrue((paperCount - expectedPercentage).absoluteValue < 50)
        assertTrue((scissorsCount - expectedPercentage).absoluteValue < 50)
    }
}
