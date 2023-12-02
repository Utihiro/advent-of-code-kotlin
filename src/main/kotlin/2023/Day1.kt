package `2023`

class Day1 {
    companion object {
        private val numberList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

        private val literals = mapOf(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )
    }

    fun firstPart(input: String) = input.split("\\s\\s".toRegex())
        .map { line ->
            val chars = line.toCharArray()

            Pair(
                chars.first { it.digitToIntOrNull() != null },
                chars.reversed().first { it.digitToIntOrNull() != null }
            )
        }
        .sumOf { (first, second) -> String(charArrayOf(first, second)).toInt() }

    fun secondPart(input: String) = input.split("\\s\\s".toRegex())
        .map { line ->
            val literalList = numberList + literals.keys

            fun String.toNumberChar() = literals[this]?.digitToChar() ?: this.first()

            literalList.associateWith { (line.indexOf(it) to line.lastIndexOf(it)) }
                .filter { it.value.first != -1 && it.value.second != -1 }
                .let { indexedMap ->
                    Pair(
                        indexedMap.minBy { it.value.first }.key.toNumberChar(),
                        indexedMap.maxBy { it.value.second }.key.toNumberChar()
                    )
                }
        }
        .sumOf { (first, second) -> String(charArrayOf(first, second)).toInt() }
}