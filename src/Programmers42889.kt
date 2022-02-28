// 모르겠음
fun main() {
    println(
        solution42889(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).contentToString()
    )
    println(
        solution42889(4, intArrayOf(4, 4, 4, 4, 4)).contentToString()
    )
    println(
        solution42889(5, intArrayOf(2, 1, 2, 4, 2, 4, 3, 3)).contentToString()
    )
}

fun solution42889(N: Int, stages: IntArray): IntArray {
    var answer = intArrayOf()
    val array = Array(N + 2) { 0 }
    val pairArray = Array(N + 1) { Pair(it, 0.0) }
    var size = stages.size

    stages.forEach {
        array[it] += 1
    }

    (1..N).forEach {
        println("$it >> ${pairArray[it]} ${array[it] / size.toDouble()}")
        if(size != 0) {
            pairArray[it] = Pair(it, array[it] / size.toDouble())
        } else {
            pairArray[it] = Pair(it, 0.0)
        }
        size -= array[it]
    }
    pairArray.sortByDescending { it.second }
    pairArray.forEach {
        if (it.first != 0) answer += it.first
    }

    return answer
}