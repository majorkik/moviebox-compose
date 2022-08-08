import arrow.core.None
import arrow.core.some
import com.majorkik.test.convertToRowArray
import com.majorkik.tmdb.impl.util.ServerDatePattern
import com.majorkik.tmdb.impl.util.tryParseDateFromAPI
import com.soywiz.klock.Date
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.data.blocking.forAll
import io.kotest.matchers.shouldBe

class ServerDatePatternSpec :
    ShouldSpec({
        context("tryParseDateFromAPI(X)") {
            val samples = convertToRowArray(
                listOf(
                    Date(2000, 1, 1),
                    Date(2012, 12, 14),
                    Date(1900, 8, 5)
                )
            )

            forAll(*samples) { date ->
                val stringDate = date.format(ServerDatePattern.DEFAULT_SERVER_PATTERN.pattern)

                tryParseDateFromAPI(stringDate) shouldBe date.some()
            }

            should("return null if pattern can't be applied") {
                val stringDate = Date(
                    4, 2000, 5
                ).format(ServerDatePattern.DEFAULT_SERVER_PATTERN.pattern)

                tryParseDateFromAPI(stringDate) shouldBe None
            }
        }
    })
