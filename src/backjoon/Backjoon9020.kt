package backjoon
import java.util.*

// 골드바흐의 추측
fun main() {
    val sc = Scanner(System.`in`)
    for (x in 0 until sc.nextInt()) {
        val n = sc.nextInt()

        val nArray = Array(n + 1) { it }
        nArray[1] = 0

        // 에라토스테네스의 체 이용
        for (i in 2 until nArray.size) {
            if (nArray[i] == 0) continue

            for (j in i * 2..n step i) {
                nArray[j] = 0
            }
        }

        val filterArray = nArray.copyOf().filter { it != 0 }

        val m = n / 2

        // n의 절반부터 내려가면서 조건을 만족하는 소수 찾기
        for (i in m downTo 1) {
            if (filterArray.any { it == i } && filterArray.any { it == n - i }) {
                println("$i ${n - i}")
                break
            }
        }
    }
}