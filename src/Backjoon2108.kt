import java.util.*
import kotlin.math.round

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val map = HashMap<Int, Int>()


    val array = Array(n) { sc.nextInt() }

    // toFloat 사용하니까 정확하지 않아서 오류...
    val answer1 = array.sum().toDouble() / array.size

    array.sort()
    val answer2 = array[array.size / 2]


    array.distinctBy {
        map[it] = map[it]?.plus(1) ?: 1
    }

    var max = map.maxOf { map[it.key] ?: 0 }

    val answerArray = ArrayList<Int>()

    map.forEach { (key, value) ->
        if (value == max) {
            max = value
            answerArray.add(key)
        }
    }


    answerArray.sort()
    val answer3 = if(answerArray.size == 1) answerArray[0] else answerArray[1]

    val answer4 = array.maxOf { it } - array.minOf { it }


    println(round(answer1).toInt())
    println(answer2)
    println(answer3)
    println(answer4)
}