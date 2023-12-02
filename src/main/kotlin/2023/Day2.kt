package `2023`

class Day2 {
    companion object {
        object Color {
            const val RED = "red"
            const val GREEN = "green"
            const val BLUE = "blue"
        }
    }

    fun firstPart(input: String) = input.split("\\s\\s".toRegex())
        .mapNotNull { gameInfo ->
            val (game, bag) = gameInfo.split(": ")

            bag.split("; ")
                .flatMap { it.split(", ") }
                .forEach {
                    val (number, color) = it.split(" ")

                    when {
                        color == Color.RED && number.toInt() > 12 -> return@mapNotNull null
                        color == Color.GREEN && number.toInt() > 13 -> return@mapNotNull null
                        color == Color.BLUE && number.toInt() > 14 -> return@mapNotNull null
                    }
                }

            game.split(" ").last().toInt()
        }
        .sum()

    fun secondPart(input: String) = input.split("\\s\\s".toRegex())
        .sumOf { gameInfo ->
            val (_, bag) = gameInfo.split(": ")

            val cubes = bag.split("; ")
                .flatMap { it.split(", ") }
                .map {
                    val (number, color) = it.split(" ")
                    number.toInt() to color
                }

            fun maxByColor(color: String): Int = cubes.filter { it.second == color }.maxBy { it.first }.first

            maxByColor(Color.RED) * maxByColor(Color.GREEN) * maxByColor(Color.BLUE)
        }
}