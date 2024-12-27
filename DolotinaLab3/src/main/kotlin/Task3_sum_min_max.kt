class TaskProcessor(private val array: List<Int>) {

    // Метод для знаходження індексу першого парного елемента
    private fun findFirstEvenIndex(): Int {
        return array.indexOfFirst { it % 2 == 0 }
    }

    // Метод для знаходження індексу мінімального елемента
    private fun findMinIndex(): Int {
        return array.indexOf(array.minOrNull() ?: throw IllegalArgumentException("Array is empty"))
    }

    // Метод для обчислення суми елементів між індексами L і R включно
    fun calculateSumBetweenLAndR(): Int {
        val l = findFirstEvenIndex()
        val r = findMinIndex()

        if (l == -1 || r == -1) throw IllegalStateException("L or R index is invalid")

        val start = minOf(l, r)
        val end = maxOf(l, r)

        return array.subList(start, end + 1).sum()
    }
}

fun main() {
    try {
        // Зчитуємо кількість елементів
        val n = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
        require(n in 2..100) { "N is out of range" }

        // Зчитуємо масив чисел
        val array = readLine()?.split(" ")?.map { it.toInt() }
            ?: throw IllegalArgumentException("Invalid array input")
        require(array.size == n) { "Array size does not match N" }
        require(array.all { it in -100..100 }) { "Array elements are out of range" }

        // Обробка масиву
        val processor = TaskProcessor(array)
        println(processor.calculateSumBetweenLAndR())
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
