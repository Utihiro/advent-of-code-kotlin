private val input = input("day3.txt")

private val char: Map<Char, Int> = ('a'..'z').mapIndexed { idx, chr -> chr to idx + 1 }.toMap()

fun main() {
    calcItemTypes_part_one().also { println("Part One: $it") }
    calcItemTypes_part_two().also { println("Part Two: $it") }
}

fun calcItemTypes_part_one(): Int =
    input.split("\\s\\s".toRegex())
        .map { it.toCharArray() }
        .map { it.copyOfRange(0, (it.size + 1) / 2) to it.copyOfRange((it.size + 1) / 2, it.size) }
        .flatMap { (first, second) -> first.intersect(second.toSet()) }
        .sumOf {
            if (it.isUpperCase()) char[it.lowercaseChar()]!! + char.size
            else char[it]!!
        }

fun calcItemTypes_part_two(): Int =
    input.split("\\s\\s".toRegex())
        .map { it.toCharArray() }
        .chunked(3)
        .flatMap { it.reduce { acc, chars -> chars.intersect(acc.toSet()).toCharArray() }.toSet() }
        .sumOf {
            if (it.isUpperCase()) char[it.lowercaseChar()]!! + char.size
            else char[it]!!
        }