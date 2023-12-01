package `2022`

import input
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day1Test : FunSpec({
    context("First part") {
        test("should pass example") {
            val sut = Day1().firstPart(input("2022/day1_example.txt"))

            sut shouldBe 24000
        }

        test("should pass first part") {
            Day1().firstPart(input("2022/day1.txt")).also(::println)
        }
    }

    context("Second part") {
        test("should pass example") {
            val sut = Day1().secondPart(input("2022/day1_example.txt"))

            sut shouldBe 45000
        }

        test("should pass second part") {
            Day1().secondPart(input("2022/day1.txt")).also(::println)
        }
    }
})
