fun main() {

//    println(
//        solution(intArrayOf(1, 2, 3, 4, 5)).contentToString()
//    )
}


fun solution42840(answers: IntArray): IntArray {
    var answer = intArrayOf()

    val num1 = intArrayOf(1, 2, 3, 4, 5)
    val num2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val num3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    var num1Count = 0
    var num2Count = 0
    var num3Count = 0

    answers.forEachIndexed { index, i ->
        if (num1[index % num1.size] == i) num1Count++
        if (num2[index % num2.size] == i) num2Count++
        if (num3[index % num3.size] == i) num3Count++
    }

    val max = maxOf(num1Count, num2Count, num3Count)

    if(max == num1Count) answer += 1
    if(max == num2Count) answer += 2
    if(max == num3Count) answer += 3



    return answer
}