package programmers

fun main() {
    println(
        solution12953(intArrayOf(2, 6, 8, 14))
    )

}


fun solution12953(arr: IntArray): Int {
    var answer = arr[0]
    for (i in 1 until arr.size) {
        answer = lcm(answer, arr[i])
    }

    return answer
}

private fun gcd(a: Int, b: Int): Int = if (a % b == 0) b else gcd(b, a % b)
private fun lcm(a: Int, b: Int): Int = (a * b) / gcd(a, b)