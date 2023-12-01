package `2022`

import input
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day4Test : FunSpec({
    context("First part") {
        test("should pass example") {
            val sut = Day4().firstPart(input("2022/day4_example.txt"))

            sut shouldBe 2
        }

        test("should pass first part") {
            Day4().firstPart(input("2022/day4.txt")).also(::println)
        }
    }

    context("Second part") {
        test("should pass example") {
            val sut = Day4().secondPart(input("2022/day4_example.txt"))

            sut shouldBe 4
        }

        test("should pass second part") {
            Day4().secondPart(input("2022/day4.txt")).also(::println)
        }
    }
})
