fun main() {
//    solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5))
//    solution(5, intArrayOf(2, 4), intArrayOf(3))
//    solution(3, intArrayOf(3), intArrayOf(1))
}


fun solution42862(n: Int, lost: IntArray, reserve: IntArray): Int {

    val totalArray = IntArray(n) { 1 }

    reserve.forEach {
        totalArray[it - 1] = 2
    }
    lost.forEach {
        totalArray[it - 1] = totalArray[it - 1] - 1
    }

    totalArray.forEachIndexed { index, i ->
        if (i == 2) {
            if (index != 0 && totalArray[index - 1] == 0) {
                totalArray[index - 1] = 1
                totalArray[index] = 1
            } else if (index != totalArray.size - 1 && totalArray[index + 1] == 0) {
                totalArray[index + 1] = 1
                totalArray[index] = 1
            }
        }
    }
    return totalArray.filter { it != 0 }.size
}