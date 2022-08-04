import arrow.core.None
import arrow.core.getOrElse
import com.majorkik.common.AppDateFormat.parseReadableDate
import com.majorkik.common.tryParseDate
import com.soywiz.klock.Date
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class AppDateFormatSpec :
    ShouldSpec({
        context("parseReadableDate(X)") {
            should("return parsed string of X") {
                parseReadableDate(
                    Date(2004, 3, 5)
                ).getOrElse { "" } shouldBe "05 March 2004"
            }

            should("return None at null values") {
                parseReadableDate(null) shouldBe None
            }
        }

        context("tryParseDate(X, Y)") {
            should("return Date when X satisfies Y pattern") {
                tryParseDate(
                    "2000-04-09", "yyyy-MM-dd"
                ) shouldBe Date(2000, 4, 9)
            }

            should("return null when X doesn't satisfy Y pattern") {
                tryParseDate("04-2000-09", "yyyy-MM-dd") shouldBe null
            }
        }
    })
