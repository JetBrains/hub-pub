import kotlin.test.*

@Suppress("unused")
class IndexTest {
    @Test
    fun shouldPrintUsageIfNoArguments() {
        val args: List<String> = listOf()
        parseArguments(args)
    }
}
