import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertTrue

class MainFunctionTest {

    @Test
    fun `main function should print expected output`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        val output = outputStream.toString()
        assertTrue(output.contains("Player A wins"))
        assertTrue(output.contains("Player B wins"))
        assertTrue(output.contains("Draws"))
    }
}
