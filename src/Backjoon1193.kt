import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextLong()

    if(n == 1L) { // 1일때는 그냥 처리
        println("1/1")
        return
    }

    for (i in 2L until 10000000) {
        val dN = difference(i)
        val dN1 = difference(i + 1)

        if (n in dN until dN1) {
            if (i % 2 == 0L) {
                println("${1 + n - dN}/${dN1 - n}")
            } else {
                println("${dN1 - n}/${1 + n - dN}")
            }
        }
    }
}

fun difference(n: Long): Long { // 계차수열 이용
    return 1 + (n * (n - 1) / 2)
}

/*
* 1 ->1/1
*
* 2 ->1/2
* 3 -> 2/1
*
* 4 -> 3/1
* 5 -> 2/2
* 6 -> 1/3
*
* 7 -> 1/4
* 8 -> 2/3
* 9 -> 3/2
* 10 -> 4/1
*
* 11 -> 5/1
*
* 1, 2, 4, 7, 11 마다 분자 혹은 분모가 1인 경우 발생
* 1, 2, 4, 7, 11을 1, 2, 3, 4, 5로 잡고 계산하면 2, 4는 1/2, 1/3
* 3, 5는 3/1, 5/1 이므로 짝수는 분자가 1, 홀수는 분모가 1이다.
*
* k+1 번째 계차수열 값과 입력받은 n 값을 빼서 해당 오차를 분자 혹은 분모로
* n을 k번째 계차수열 + 1 값으로 분모 혹은 분자로 넣어준다.
*
*/

