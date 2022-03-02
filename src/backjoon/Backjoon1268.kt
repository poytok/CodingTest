package backjoon
import java.util.*


/**
 * 시간초과 ...
 * */
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val array = Array(n) { Array(5) { sc.nextInt() } }
    val answerArray = Array(n) { ArrayList<Int>() }

    for (i in 0 until 5) {
        for (j in 0 until n - 1) {
            for (k in j until n) {
                if (j == k) continue

                if (array[j][i] == array[k][i]) {
                    val temp1 = ArrayList<Int>()
                    temp1.addAll(answerArray[j])
                    temp1.add(k)
                    answerArray[j] = temp1

                    val temp2 = ArrayList<Int>()
                    temp2.addAll(answerArray[k])
                    temp2.add(j)
                    answerArray[k] = temp2
                }
            }
        }
    }

    var max = -1
    var answerNumber = -1

    answerArray.forEachIndexed { index, it ->
        val size = it.distinct().size
        if(max < size) {
            max = size
            answerNumber = index
        } else if (max == size && answerNumber > index) {
            answerNumber = index
        }
    }

    println(answerNumber + 1)
}