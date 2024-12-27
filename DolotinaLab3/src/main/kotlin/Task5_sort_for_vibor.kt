fun selectionSortSwaps(array: MutableList<Int>): Int {
    val n = array.size
    val firstElement = array[0]
    var swaps = 0

    for (i in 0 until n - 1) {
        // Знаходимо індекс мінімального елемента у підмасиві
        var minIndex = i
        for (j in i + 1 until n) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        // Якщо мінімальний елемент не на своєму місці, міняємо місцями
        if (minIndex != i) {
            // Перевіряємо, чи перший елемент бере участь у переміщенні
            if (array[i] == firstElement || array[minIndex] == firstElement) {
                swaps++
            }
            array[i] = array[minIndex].also { array[minIndex] = array[i] }
        }
    }

    return swaps
}

fun main() {
    try {
        // Зчитуємо кількість елементів
        val n = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
        require(n >= 2) { "Array must have at least 2 elements" }

        // Зчитуємо масив
        val array = readLine()?.split(" ")?.map { it.toInt() }?.toMutableList()
            ?: throw IllegalArgumentException("Invalid array input")
        require(array.size == n) { "Array size does not match N" }

        // Виклик функції сортування
        val result = selectionSortSwaps(array)
        println(result)
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
