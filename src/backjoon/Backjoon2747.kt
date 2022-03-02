package backjoon

import java.util.*


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val fiboArray = ArrayList<Int>()

    fiboArray.add(0)
    fiboArray.add(1)
    for (i in 2..n) {
        fiboArray.add(fiboArray[i - 1] + fiboArray[i - 2])
    }

    println(fiboArray.last())
}