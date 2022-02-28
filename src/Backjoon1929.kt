import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val m = sc.nextInt()
    val n = sc.nextInt()

    var nm = 0

    for (i in 1 until n) {
        if (i * i <= n && (i + 1) * (i + 1) > n) {
            nm = i + 1
            break
        }
    }

    var array = Array(1000001) { it }
    array = array.map {
        var a = 0
        for (i in 2..nm) {

            if (i >= m) {
                if (i == nm) {
                    a = it
                } else if (it % 2 == 0) {
                    a = 0
                } else {
                    a = 0
                }
            } else {
                a = 0
            }
        }
        a
    }.toTypedArray()


    println(array.filter { it in m..n && it != 0 }.toTypedArray().contentToString())
}