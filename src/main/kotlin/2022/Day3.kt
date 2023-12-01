package `2022`

class Day3 {
    companion object {
        private val char: Map<Char, Int> = ('a'..'z').mapIndexed { idx, chr -> chr to idx + 1 }.toMap()
    }

    fun firstPart(input: String): Int =
        input.split("\\s\\s".toRegex())
            .map { it.toCharArray() }
            .map { it.copyOfRange(0, (it.size + 1) / 2) to it.copyOfRange((it.size + 1) / 2, it.size) }
            .flatMap { (first, second) -> first.intersect(second.toSet()) }
            .sumOf {
                if (it.isUpperCase()) char[it.lowercaseChar()]!! + char.size
                else char[it]!!
            }

    fun secondPart(input: String): Int =
        input.split("\\s\\s".toRegex())
            .map { it.toCharArray() }
            .chunked(3)
            .flatMap { it.reduce { acc, chars -> chars.intersect(acc.toSet()).toCharArray() }.toSet() }
            .sumOf {
                if (it.isUpperCase()) char[it.lowercaseChar()]!! + char.size
                else char[it]!!
            }
}