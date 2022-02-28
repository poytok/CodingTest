fun main() {

//    println(
//        solution(
//            intArrayOf(1, 5, 2, 6, 3, 7, 4),
//            arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
//        ).contentToString()
//    )

}

fun solution42748(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()

    commands.forEach {
        val i = it[0]
        val j = it[1]
        val k = it[2]


        val answerArray = array.slice(i - 1 until j)


        answer += answerArray.sorted()[k - 1]

    }

    return answer
}