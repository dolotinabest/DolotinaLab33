class ArrayProcessor(private val array: List<Int>) {

    // Лямбда-функція для обчислення суми цифр числа
    private val sumOfDigits: (Int) -> Int = { num ->
        num.toString().filter { it.isDigit() }.sumOf { it.digitToInt() }
    }

    // Метод для знаходження елемента з мінімальною сумою цифр
    fun findMinByDigitSum(): Int {
        val minSum = array.minOf { sumOfDigits(it) }
        return array.filter { sumOfDigits(it) == minSum }.minOrNull() ?: 0
    }

    // Метод для знаходження елемента з максимальною сумою цифр
    fun findMaxByDigitSum(): Int {
        val maxSum = array.maxOf { sumOfDigits(it) }
        return array.filter { sumOfDigits(it) == maxSum }.maxOrNull() ?: 0
    }
}

fun main() {
    try {
        // Зчитуємо кількість елементів
        val n = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
        require(n in 1..100) { "N is out of range" }

        // Зчитуємо масив чисел
        val array = readLine()?.split(" ")?.map { it.toInt() }
            ?: throw IllegalArgumentException("Invalid array input")
        require(array.size == n) { "Array size does not match N" }
        require(array.all { it in -10_000..10_000 }) { "Array elements are out of range" }

        // Обробка масиву
        val processor = ArrayProcessor(array)
        println(processor.findMinByDigitSum())
        println(processor.findMaxByDigitSum())
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
