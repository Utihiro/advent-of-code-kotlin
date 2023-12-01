package `2022`

class Day1 {

    fun firstPart(input: String) = calc(input).maxBy { it.value }.value

    fun secondPart(input: String) = calc(input).entries.sortedByDescending { it.value }.take(3).sumOf { it.value }

    private fun calc(input: String): Map<String, Int> {
        val map = mutableMapOf<String, Int>()

        input.split("\\s\\s".toRegex())
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
}