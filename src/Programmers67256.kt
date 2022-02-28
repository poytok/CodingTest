fun main() {
//    println(
//        solution4(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left")
//    )
}

fun solution67256(numbers: IntArray, hand: String): String {
    var answer = ""
    var lHand = Pair(3, 0)
    var rHand = Pair(3, 2)
    var count = 1

    val handPhone = Array(4) { Array(3) { "" } }
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            handPhone[i][j] = count.toString()
            count++
        }
    }
    handPhone[3][0] = "*"
    handPhone[3][1] = "0"
    handPhone[3][2] = "#"

    numbers.forEach {
        when (it) {
            1, 4, 7 -> {
                lHand = Pair(it / 3, 0)
                answer += "L"
            }

            3, 6, 9 -> {
                rHand = Pair((it - 1) / 3, 2)
                answer += "R"
            }

            else -> {
                val (x, y) = if(it == 0) {
                    3 to 1
                } else {
                    (it - 1) / 3 to (it - 1) % 3
                }

                val left = Math.abs(lHand.first - x) + Math.abs(lHand.second - y)
                val right = Math.abs(rHand.first - x) + Math.abs(rHand.second - y)

                if (left == right) {
                    if (hand == "right") {
                        rHand = Pair(x, y)
                        answer += "R"
                    } else {
                        lHand = Pair(x, y)
                        answer += "L"
                    }
                } else if (left > right) {
                    rHand = Pair(x, y)
                    answer += "R"
                } else {
                    lHand = Pair(x, y)
                    answer += "L"
                }
            }
        }
    }
    return answer
}