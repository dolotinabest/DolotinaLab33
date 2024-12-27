fun main() {
    try {
        // Зчитуємо кількість елементів масиву
        val n = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid input for n")

        // Зчитуємо масив чисел
        val array = readLine()?.split(" ")?.map { it.toInt() }
            ?: throw IllegalArgumentException("Invalid array input")
        require(array.size == n) { "Array size does not match N" }

        // Сортуємо масив за двома критеріями:
        // 1. За абсолютним значенням елементів
        // 2. Якщо абсолютні значення однакові, то за від'ємністю елементів (від'ємні числа повинні бути перед додатними)
        val sortedArray = array.sortedWith { a, b ->
            val absA = Math.abs(a)
            val absB = Math.abs(b)
            // Порівнюємо за модулем, якщо вони однакові, то порівнюємо за від'ємністю
            when {
                absA < absB -> -1
                absA > absB -> 1
                a < b -> -1
                else -> 1
            }
        }

        // Виводимо відсортований масив
        println(sortedArray.joinToString(" "))
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
