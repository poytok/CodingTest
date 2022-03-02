package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

lateinit var wb: Array<Array<Char>>
lateinit var bw: Array<Array<Char>>

lateinit var visit: Array<Array<Boolean>>

private var count = 999999

fun main() {
    setChess()

    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val array = Array(n) { br.readLine().toCharArray() }
    visit = Array(n) { Array(m) { false } }

    checkCount(array, 0, 0, n, m)
    println(count)
}

fun checkCount(array: Array<CharArray>, currentN: Int, currentM: Int, n: Int, m: Int) {
    if (currentN + 8 > n || currentM + 8 > m) return
     else if (visit[currentN][currentM]) return
    visit[currentN][currentM] = true

    var whiteCount = 0
    var blackCount = 0

    for (i in currentN until currentN + 8) {
        for (j in currentM until currentM + 8) {
            if (array[i][j] == wb[i - currentN][j - currentM]) continue
            else whiteCount++
        }
    }

    for (i in currentN until currentN + 8) {
        for (j in currentM until currentM + 8) {
            if (array[i][j] == bw[i - currentN][j - currentM]) continue
            else blackCount++
        }
    }

    count = min(count, min(whiteCount, blackCount))
    checkCount(array, currentN + 1, currentM, n, m)
    checkCount(array, currentN, currentM + 1, n, m)
}

fun setChess() {
    wb = Array(8) { Array(8) { 'W' } }
    bw = Array(8) { Array(8) { 'B' } }
    for (i in 0 until 8) {
        var flag = i % 2 == 0
        for (j in 0 until 8) {
            if (flag) {
                wb[i][j] = 'W'
                bw[i][j] = 'B'
            } else {
                bw[i][j] = 'W'
                wb[i][j] = 'B'
            }
            flag = !flag
        }
    }
}