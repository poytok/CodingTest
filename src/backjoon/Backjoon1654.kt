package backjoon
import java.util.*

// 랜선 자르기
fun main() {
    val sc = Scanner(System.`in`)
    // 첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다.
    // K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N 이다.
    // 그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다. 랜선의 길이는 2^31 - 1보다 작거나 같은 자연수이다.

    val k = sc.nextInt()
    val n = sc.nextLong()
    val array = Array(k) { sc.nextLong() }

    val sum = array.sum()
    var start = 0L
    var end = sum / n
    var middle = end / 2


    var answer: Long

    while (true) {
        answer = (array.sumOf { it / middle })

        if (answer == n) break
        else if (answer > n) {
            start = middle + 1

        } else {
            end = middle - 1
        }
        middle = (start + end) / 2
    }
    println(end)

}