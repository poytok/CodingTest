package programmers
import java.math.BigDecimal

// 못품
fun main() {
    println(
        solution62048(8, 12)
    )
    println(
        solution62048(8, 3)
    )
}


fun solution62048(w: Int, h: Int): Long {

    val ww = w / gcd(w, h)
    val hh = h / gcd(w, h)

    return 0L
}

private fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a
