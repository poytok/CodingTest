package programmers
fun main() {

}


fun solution70128(a: IntArray, b: IntArray): Int {
    var answer: Int = 0

    answer = a.mapIndexed { index, i ->
        i * b[index]
    }.sumBy { it }

    return answer
}