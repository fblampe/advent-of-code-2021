import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Part2Test {
    @Test
    internal fun `single increase is counted`() {
        val res = countIncreasesWithSlidingWindow(listOf(1, 2, 3, 4))

        assertThat(res).isEqualTo(1)
    }

    @Test
    internal fun `no increases yield zero`() {
        val res = countIncreasesWithSlidingWindow(listOf(1, 1, 1, 1))

        assertThat(res).isEqualTo(0)
    }
}