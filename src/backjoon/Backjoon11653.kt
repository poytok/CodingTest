package backjoon
import java.util.*


fun main() {

    val sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var smallNumber = 2

    while (n != 1) {
        if (n % smallNumber == 0) {
            n /= smallNumber
            println(smallNumber)
        } else {
            smallNumber++
        }
    }
}