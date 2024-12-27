fun main() {
    try {
        // Зчитуємо кількість елементів масиву
        val n = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input for n")

        // Зчитуємо масив чисел
        val array = readLine()?.split(" ")?.map { it.toInt() }
            ?: throw IllegalArgumentException("Invalid array input")
        require(array.size == n) { "Array size does not match N" }

        // Зчитуємо число k
        val k = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input for k")

        // Перевіряємо, чи k не більше за кількість елементів в масиві
        require(k in 1..n) { "k must be between 1 and N" }

        // Сортуємо масив для отримання найменших і найбільших елементів
        val sortedArray = array.sorted()

        // Обчислюємо суму найменших k елементів
        val sumOfSmallestK = sortedArray.take(k).sum()

        // Обчислюємо суму найбільших k елементів
        val sumOfLargestK = sortedArray.takeLast(k).sum()

        // Виводимо результати
        println("$sumOfSmallestK $sumOfLargestK")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
