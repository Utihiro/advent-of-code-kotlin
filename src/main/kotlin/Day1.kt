private val input = input("day1.txt")

fun main() {
    val elfMap = calc().also { println(it) }

    elfMap.maxBy { it.key }.value.also { println("Part One: $it") }
    elfMap.entries.sortedByDescending { it.value }.take(3).sumOf { it.value }.also { println("Part Two: $it") }
}

fun calc(): Map<String, Int> {
    val map = mutableMapOf<String, Int>()

    input.split("\\s\\s".toRegex()).drop(1).dropLast(1)
        .mapIndexed { idx, element -> element.ifBlank { "Elf #$idx" } }
        .runningReduce { value, element ->
            if (element.contains("Elf")) {
                map[element] = value.toInt()
                return@runningReduce "0"
            }
            (value.toInt() + element.toInt()).toString()
        }

    return map
}