package programmers
import java.util.*

fun main() {
//    println(
//        solution77485(
//            6,
//            6,
//            arrayOf(intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3))
//        ).contentToString()
//    )
    println(
        solution77485(
            10,
            7,
            arrayOf(intArrayOf(1, 1, 10, 7))
        ).contentToString()
    )
}


fun solution77485(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
    var answer = intArrayOf()
    var count = 1
    val array = Array(rows) { Array(columns) { count++ } }


    queries.forEach {
        val startCol = it[0] - 1
        val startRow = it[1] - 1
        val endCol = it[2] - 1
        val endRow = it[3] - 1

        val stack = Stack<Int>()

        // 집어넣을 배열
        for (i in startRow until endRow) {
            stack.push(array[startCol][i])
        }

        for (i in startCol until endCol) {
            stack.push(array[i][endRow])
        }

        for (i in endRow downTo startRow) {
            stack.push(array[endCol][i])
        }

        for (i in endCol - 1 downTo startCol + 1) {
            stack.push(array[i][startRow])
        }

        var min = 100001

        // 회전된 배열
        for (i in startCol until endCol) {
            val pop = stack.pop()
            if (min > pop) min = pop
            array[i][startRow] = pop
        }

        for (i in startRow until endRow) {
            val pop = stack.pop()
            if (min > pop) min = pop
            array[endCol][i] = pop
        }

        for (i in endCol downTo startCol) {
            val pop = stack.pop()
            if (min > pop) min = pop
            array[i][endRow] = pop
        }

        for (i in endRow - 1 downTo startRow + 1) {
            val pop = stack.pop()
            if (min > pop) min = pop
            array[startCol][i] = pop
        }

        answer += min
    }

    return answer
}