package `2023`

import input
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day2Test : FunSpec({
    context("First part") {
        test("should pass example") {
            val sut = Day2().firstPart(input("2023/day2_example.txt"))

            sut shouldBe 8
        }

        test("should pass first part") {
            Day2().firstPart(input("2023/day2.txt")).also(::println)
        }
    }

    context("Second part") {
        test("should pass example") {
            val sut = Day2().secondPart(input("2023/day2_example.txt"))

            sut shouldBe 2286
        }

        test("should pass second part") {
            Day2().secondPart(input("2023/day2.txt")).also(::println)
        }
    }
})