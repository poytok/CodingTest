fun main() {
    val array = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 3),
        intArrayOf(0, 2, 5, 0, 1),
        intArrayOf(4, 2, 4, 4, 2),
        intArrayOf(3, 5, 1, 3, 1)
    )

    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
//    val a = solution3(array, moves)
//
//    println(a)
}

fun solution64061(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0

    var basket = intArrayOf()
    var moveArray = moves.copyOf()
    val boardList = board.indices.map { columnIndex ->
        board.map { it[columnIndex] }.toMutableList()
    }

    while (moveArray.isNotEmpty()) {
        val move = moveArray.first() - 1
        val doll = boardList[move].firstOrNull { it != 0 }
        moveArray = moveArray.drop(1).toIntArray()

        if (doll != null) {
            boardList[move][boardList[move].indexOfFirst { it != 0 }] = 0
            if (basket.isEmpty() || basket.last() != doll) basket += doll
            else {
                basket = basket.dropLast(1).toIntArray()
                answer++
            }
        }
    }


    return answer * 2
}