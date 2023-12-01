package `2022`

class Day4 {
    fun firstPart(input: String): Int =
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

    fun secondPart(input: String): Int =
        input.split("\\s\\s".toRegex())
            .map { it.split(",") }
            .map { (firstPair, secondPair) ->
                val firstRange = firstPair.split("-").let { (first, second) ->
                    first.toInt()..second.toInt()
                }
                val secondRange = secondPair.split("-").let { (first, second) ->
                    first.toInt()..second.toInt()
                }

                (firstRange intersect secondRange).isNotEmpty()
            }
            .count { it }
}