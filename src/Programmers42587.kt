import java.util.*

fun main() {
    println(
        solution42587(intArrayOf(1, 1, 9, 1, 1, 1), 0)
    )
}


fun solution42587(priorities: IntArray, location: Int): Int {
    var count = 0
    val queue = LinkedList<Pair<Int, Int>>()
    for (i in priorities.indices) {
        queue.offer(Pair(i, priorities[i]))
    }

    while (queue.isNotEmpty()) {
        var max = 0
        queue.forEach {
            if (it.second > max) max = it.second
        }
        val pop = queue.poll()
        if (pop.second == max) {
            count++
            if (pop.first == location) break
        } else {
            queue.offer(pop)
        }
    }


    return count
}