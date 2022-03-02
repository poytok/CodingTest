package programmers

fun main() {

//    println(
//        programmers.solution42586(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).contentToString()
//    )
    println(
        solution42586(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1)).contentToString()
    )
}


fun solution42586(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()

    var index = 0
    var count = 0
    var i = 1
    while (index != progresses.size) {
        if (progresses[index] + (speeds[index] * i) >= 100) {
            count++
            index++
            if (index != progresses.size) continue
        } else {
            i++
        }

        if (count != 0) answer += count
        count = 0
    }

    return answer
}