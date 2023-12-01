package `2022`

import input
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day3Test : FunSpec({
    context("First part") {
        test("should pass example") {
            val sut = Day3().firstPart(input("2022/day3_example.txt"))

            sut shouldBe 157
        }

        test("should pass first part") {
            Day3().firstPart(input("2022/day3.txt")).also(::println)
        }
    }

    context("Second part") {
        test("should pass example") {
            val sut = Day3().secondPart(input("2022/day3_example.txt"))

            sut shouldBe 70
        }

        test("should pass second part") {
            Day3().secondPart(input("2022/day3.txt")).also(::println)
        }
    }
})
