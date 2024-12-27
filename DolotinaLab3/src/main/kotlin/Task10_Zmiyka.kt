fun main() {
    // Зчитуємо розміри матриці
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    // Створюємо матрицю розміру n x m
    val matrix = Array(n) { IntArray(m) }

    // Заповнюємо матрицю згідно з правилом
    var currentValue = n * m
    for (j in 0 until m) {
        if (j % 2 == 0) {
            // Якщо стовпець парний, заповнюємо зверху вниз
            for (i in 0 until n) {
                matrix[i][j] = currentValue--
            }
        } else {
            // Якщо стовпець непарний, заповнюємо знизу вверх
            for (i in n - 1 downTo 0) {
                matrix[i][j] = currentValue--
            }
        }
    }

    // Виводимо матрицю
    for (i in 0 until n) {
        println(matrix[i].joinToString(" "))
    }
}
