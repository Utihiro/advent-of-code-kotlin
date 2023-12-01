package `2022`

class Day2 {
    fun firstPart(input: String) = calcByStrategy(input) { _, player ->
        Shape.find(player)
    }

    fun secondPart(input: String) = calcByStrategy(input) { opponent, player ->
        val opponentShape = Shape.find(opponent)
        when (player) {
            "X" -> opponentShape.defeat.value
            "Y" -> opponentShape
            "Z" -> opponentShape.defeat.value.defeat.value
            else -> error("Unsupported player strategy")
        }
    }

    private fun calcByStrategy(input: String, playerStrategy: (String, String) -> Shape): Int =
        input.split("\\s\\s".toRegex())
            .map { it.split(" ").let { (opponent, player) -> opponent to player } }
            .sumOf { (opponent, player) ->
                val opponentShape = Shape.find(opponent)
                val playerShape = playerStrategy(opponent, player)

                if (opponentShape == playerShape) playerShape.score + 3
                else if (playerShape.defeat.value == opponentShape) playerShape.score + 6
                else playerShape.score
            }

    private enum class Shape(val score: Int, val code: List<String>, val defeat: Lazy<Shape>) {
        Rock(1, listOf("A", "X"), lazy { Scissors }),
        Paper(2, listOf("B", "Y"), lazy { Rock }),
        Scissors(3, listOf("C", "Z"), lazy { Paper });

        companion object {
            fun find(code: String): Shape = entries.first { it.code.contains(code) }
        }
    }
}