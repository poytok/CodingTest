import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val m = sc.nextInt()
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

    // 0이거나 m과 n 사이에 있는 수가 아니면 filter
    nArray.filter { it != 0 && it >= m}.forEach {
        println(it)
    }

}