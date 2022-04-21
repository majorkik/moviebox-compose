import com.majorkik.common.percentOf
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class NumberUtilsSpec :
    ShouldSpec({
        context("Double.percentOf(X)") {
            should("return a positive percentage of X") {
                98.4.percentOf(10) shouldBe 984
                1.2.percentOf(10) shouldBe 12
            }

            should("return a negative percentage of X") { (-290.0).percentOf(10) shouldBe -2900 }

            should("should return zero at zero values") {
                0.0.percentOf(10) shouldBe 0
                10.0.percentOf(0) shouldBe 0
            }
        }
    })
