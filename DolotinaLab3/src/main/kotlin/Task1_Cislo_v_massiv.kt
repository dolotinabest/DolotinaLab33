class NumberArrayProcessor(private val number: Int) {

    // Поле для зберігання масиву цифр
    val digitArray: List<Int> by lazy { processNumber(number) }

    // Лямбда-функція для перетворення числа в масив цифр
    private val processNumber: (Int) -> List<Int> = { num ->
        num.toString().map { it.digitToInt() }
    }

    // Метод для отримання результату у вигляді рядка
    fun getArrayAsString(): String =
        digitArray.joinToString(" ")
}

fun main() {
    try {
        // Зчитуємо вхідне число
        val input = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input")

        // Перевіряємо, чи входить число в допустимий діапазон
        val result = if (input in 0..2_147_483_647) {
            NumberArrayProcessor(input).getArrayAsString()
        } else {
            "Number out of range"
        }

        println(result)
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
