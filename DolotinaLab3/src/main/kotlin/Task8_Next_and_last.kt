class CharInfo(val inputChar: Char) {
    // Властивість для отримання ASCII коду символу
    val asciiCode: Int = inputChar.toInt()

    // Лямбда-функції для отримання наступного і попереднього символів
    val nextChar: Char = run { (asciiCode + 1).toChar() }
    val prevChar: Char = run { (asciiCode - 1).toChar() }

    // Метод для виведення результату
    fun printCharInfo() {
        // Використовуємо when для форматування повідомлення
        println(
            "The next char for '$inputChar' ($asciiCode) is '$nextChar' (${nextChar.toInt()})."
        )
        println(
            "The previous char for '$inputChar' ($asciiCode) is '$prevChar' (${prevChar.toInt()})."
        )
    }
}

fun main() {
    // Зчитуємо символ
    val inputChar = readLine()?.firstOrNull() ?: return

    // Створюємо об'єкт CharInfo
    val charInfo = CharInfo(inputChar)

    // Виводимо інформацію
    charInfo.printCharInfo()
}
