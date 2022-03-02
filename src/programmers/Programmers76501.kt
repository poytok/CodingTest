package programmers
fun main() {
//    solution(intArrayOf(1, 2, 3, 4, 6, 7, 8, 0))
}


fun solution76501(numbers: IntArray): Int {
    return (IntArray(10) { it } + numbers).sortedArray().groupBy { it }.filter { it.value.size < 2 }.keys.sum()
}