package programmers
import java.util.*

fun main() {

//    val sc = Scanner(System.`in`)
//    val n = sc.nextInt()

}

// n, 2 형태
private fun solution86491(sizes: Array<IntArray>): Int {
    var lowMax = 0
    var colMax = 0

    sizes.forEach { array ->
        array.sort()
        lowMax = array.first().coerceAtLeast(lowMax)
        colMax = array.last().coerceAtLeast(colMax)
    }

    return lowMax * colMax
}