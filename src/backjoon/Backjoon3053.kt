package backjoon
import java.util.*

// 택시 기하학
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextDouble()

    val pi = Math.PI

    val euclidean = n * n * pi
    val taxi = n * n * 2

    println(String.format("%.6f", euclidean))
    println(String.format("%.6f", taxi))

}