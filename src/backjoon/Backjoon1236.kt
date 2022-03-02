package backjoon
import java.lang.Integer.max
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    val row = Array(n) { false }
    val col = Array(m) { false }

    var r = 0
    var c = 0

    val array = Array(n) { CharArray(m) { '.' } }
    for (i in 0 until n) {
        array[i] = sc.next().toCharArray()
        for (j in 0 until m) {
            if(array[i][j] == 'X') {
                row[i] = true
                col[j] = true
            }
        }
    }

    row.forEach {
        if(!it) r++
    }

    col.forEach {
        if(!it) c ++
    }

    println(max(r, c))

}