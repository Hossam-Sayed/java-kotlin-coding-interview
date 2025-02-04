import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PlayerBMoveTest {

    @Test
    fun `Player B should always return ROCK`() {
        assertEquals(Move.ROCK, getPlayerBMove())
    }
}
