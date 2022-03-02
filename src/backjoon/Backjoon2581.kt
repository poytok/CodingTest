package backjoon
import java.util.*


fun main() {
    val sc = Scanner(System.`in`)
    val m = sc.nextInt()
    val n = sc.nextInt()

    var nm = 0

    for (i in 1 until n) {
        if (i * i <= n && (i + 1) * (i + 1) > n) {
            nm = i + 1
            break
        }
    }
    var answer = intArrayOf()

    for (i in m..n) {
        for (j in 2..nm) {
            if (i == j) {
                answer += i
            }
            if (i % j == 0 || i == 1) {
                break
            } else if (j == nm) {
                answer += i
            }
        }
    }
    println(answer.contentToString())

    if (answer.isEmpty()) {
        println(-1)
    } else {
        println(answer.sum())
        println(answer.minOf { it })
    }

}