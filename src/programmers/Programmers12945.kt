package programmers

fun main() {

}


fun solution12945(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    val answer = Array(arr1.size) { IntArray(arr2[0].size) { 0 } }

    for(i in arr1.indices) {
        for(k in arr2[0].indices) {
            var sum = 0
            for(j in arr2.indices) {
                sum += (arr1[i][j] * arr2[j][k])
            }
            answer[i][k] = sum
        }
    }

    return answer
}