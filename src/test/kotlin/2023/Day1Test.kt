package `2023`

import input
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day1Test : FunSpec({
    context("First part") {
        test("should pass example") {
            val sut = Day1().firstPart(input("2023/day1_example_1.txt"))

            sut shouldBe 142
        }

        test("should pass first part") {
            Day1().firstPart(input("2023/day1.txt")).also(::println)
        }
    }

    context("Second part") {
        test("should pass example") {
            val sut = Day1().secondPart(input("2023/day1_example_2.txt"))

            sut shouldBe 281
        }

        test("should pass second part") {
            Day1().secondPart(input("2023/day1.txt")).also(::println)
        }
    }
})
