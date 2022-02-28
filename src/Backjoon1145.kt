import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)

    val nArray = Array(5) { sc.nextInt() }

    val answer = ArrayList<Int>()

    for (i in 0 until 3) {
        for (j in 1 until 4) {
            for (k in 2 until 5) {
                if (i == j || j == k || k == i) continue
                answer.add(lcd(nArray[i], nArray[j], nArray[k]))
            }
        }
    }

    println(answer.minOf { it })

}

fun lcd(n1: Int, n2: Int, n3: Int): Int {
    var nn1 = n1
    var nn2 = n2
    var nn3 = n3

    while (nn1 != nn2 || nn2 != nn3) {
        when (minOf(nn1, nn2, nn3)) {
            nn1 -> nn1 += n1
            nn2 -> nn2 += n2
            nn3 -> nn3 += n3
        }
    }

    return minOf(nn1, nn2, nn3)
}