package backjoon
import java.util.*

// 베르트랑 공준
fun main() {
    val sc = Scanner(System.`in`)
    while (true) {
        val m = sc.nextInt()
        if (m == 0) break
        val n = m * 2

        val nArray = Array(n + 1) { it }
        nArray[1] = 0

        // 에라토스테네스의 체 이용
        for (i in 2 until nArray.size) {
            if (nArray[i] == 0) continue

            for (j in i * 2..n step i) {
                nArray[j] = 0
            }
        }

        // 0이거나 m보다 크고 n 작은 경우
        println(nArray.filter { it != 0 && it > m }.size)

    }

}