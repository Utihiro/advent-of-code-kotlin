private val input = input("day4.txt")

fun main() {
    calcPairs().also { println("Part One: $it") }
    calcPairs_part_two().also { println("Part Two: $it") }
}

fun calcPairs(): Int =
    input.split("\\s\\s".toRegex())
        .map { it.split(",") }
        .map { (firstPair, secondPair) ->
            val firstRange = firstPair.split("-").let { (first, second) ->
                first.toInt()..second.toInt()
            }
            val secondRange = secondPair.split("-").let { (first, second) ->
                first.toInt()..second.toInt()
            }

            firstRange.all { it in secondRange } || secondRange.all { it in firstRange }
        }
        .count { it }

fun calcPairs_part_two(): Int =
    input.split("\\s\\s".toRegex())
        .map { it.split(",") }
        .map { (firstPair, secondPair) ->
            val firstRange = firstPair.split("-").let { (first, second) ->
                first.toInt()..second.toInt()
            }
            val secondRange = secondPair.split("-").let { (first, second) ->
                first.toInt()..second.toInt()
            }

            firstRange.intersect(secondRange).isNotEmpty()
        }
        .count { it }