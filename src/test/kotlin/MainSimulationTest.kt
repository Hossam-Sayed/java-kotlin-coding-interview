import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainSimulationTest {

    @Test
    fun `Running 100 games should not crash and sum up correctly`() {
        val totalRounds = 100
        val results = simulateGame(totalRounds)

        assertEquals(100, results.winsA + results.winsB + results.draws) // Total should be 100
    }

    @Test
    fun `Running 200 games should not crash and sum up correctly`() {
        val totalRounds = 200
        val results = simulateGame(totalRounds)

        assertEquals(200, results.winsA + results.winsB + results.draws) // Total should be 200
    }
}
