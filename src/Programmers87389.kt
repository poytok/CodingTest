import java.util.*

fun main() {

//    val sc = Scanner(System.`in`)
//    val n = sc.nextInt()
//    while (n != -1) {
//    println(solution(n))
//    }
}

private fun solution87389(n: Int): Int {
    val m = n - 1
    var answer: Int = m
    for (i in 2 until n) {
        if (m % i == 0) {
            answer = i
            break
        }
    }
    return answer
}