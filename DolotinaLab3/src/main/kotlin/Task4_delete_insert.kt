class ArrayOperations(private var elements: MutableList<Int>) {

    fun removeElement(index: Int) {
        elements.removeAt(index)
    }

    fun insertElement(index: Int, value: Int) {
        elements.add(index, value)
    }

    fun findMinInSubarray(l: Int, r: Int): Int {
        return elements.subList(l - 1, r).minOrNull() ?: Int.MAX_VALUE
    }

    fun findMaxInSubarray(l: Int, r: Int): Int {
        return elements.subList(l - 1, r).maxOrNull() ?: Int.MIN_VALUE
    }
}

fun main() {
    try {
        val n = readLine()!!.toInt()
        val elements = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        val k = readLine()!!.toInt()
        val arrayOps = ArrayOperations(elements)

        // Список для зберігання результатів
        val results = mutableListOf<Int>()

        repeat(k) {
            val operation = readLine()!!.split(" ").map { it.toInt() }
            when (operation[0]) {
                1 -> {
                    // Remove element
                    arrayOps.removeElement(operation[1] - 1)
                }
                2 -> {
                    // Insert element
                    arrayOps.insertElement(operation[1], operation[2])
                }
                3 -> {
                    // Find minimum
                    val min = arrayOps.findMinInSubarray(operation[1], operation[2])
                    results.add(min)  // Додаємо результат у список
                }
                4 -> {
                    // Find maximum
                    val max = arrayOps.findMaxInSubarray(operation[1], operation[2])
                    results.add(max)  // Додаємо результат у список
                }
            }
        }

        // Виводимо всі результати після завершення всіх операцій
        results.forEach { println(it) }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
