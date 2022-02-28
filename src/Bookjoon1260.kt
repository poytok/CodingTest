import java.util.*

val sb = StringBuilder()


fun main() = Scanner(System.`in`).run {
    val n = nextInt()
    val m = nextInt()
    val v = nextInt()

    val array = Array(n + 1) { Array(n + 1) { 0 } }
    for (i in 0 until m) {
        val x = nextInt()
        val y = nextInt()

        array[x][y] = 1
        array[y][x] = 1
    }
    val visit = Array(n + 1) { false }


    dfs(v, array, visit)
    sb.append("\n")
    bfs(v, array)
    println(sb)
}

fun dfs(v: Int, array: Array<Array<Int>>, visit: Array<Boolean>) {
    sb.append("$v ")
    visit[v] = true

    for (i in array.indices) {
        if (array[v][i] == 1 && !visit[i]) dfs(i, array, visit)
    }
}

fun bfs(v: Int, array: Array<Array<Int>>) {
    val isVisit = Array(array.size) { false }
    val queue : Queue<Int> = LinkedList()

    isVisit[v] = true
    queue.add(v)


    while(!queue.isEmpty()) {
        val remove = queue.remove()
        sb.append("$remove ")

        for(i in array.indices) {
            if (array[i][remove] != 1 || isVisit[i]) {
                continue
            }
            queue.add(i)
            isVisit[i] = true
        }
    }
}