class Matrix(private val rows: Int, private val columns: Int, private val matrix: List<List<Int>>) {
    // Властивість для зберігання кількості останніх та перших стовпців
    var k: Int = 0

    // Метод для зчитування останніх k стовпців
    fun getLastKColumns(): List<List<Int>> {
        return (0 until rows).map { row ->
            (columns - k until columns).map { col ->
                matrix[row][col]
            }
        }
    }

    // Метод для зчитування перших k стовпців
    fun getFirstKColumns(): List<List<Int>> {
        return (0 until rows).map { row ->
            (0 until k).map { col ->
                matrix[row][col]
            }
        }
    }

    // Функція для виведення стовпців
    fun printMatrix(matrixToPrint: List<List<Int>>) {
        matrixToPrint.forEach { row ->
            println(row.joinToString(" "))
        }
    }
}

fun main() {
    // Зчитуємо розміри матриці
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    // Зчитуємо саму матрицю
    val matrix = mutableListOf<List<Int>>()
    for (i in 1..n) {
        val row = readLine()!!.split(" ").map { it.toInt() }
        matrix.add(row)
    }

    // Зчитуємо число k
    val k = readLine()!!.toInt()

    // Створюємо об'єкт класу Matrix
    val matrixObj = Matrix(n, m, matrix).apply { this.k = k }

    // Виводимо k останніх стовпців
    matrixObj.printMatrix(matrixObj.getLastKColumns())

    // Виводимо k перших стовпців
    matrixObj.printMatrix(matrixObj.getFirstKColumns())
}
