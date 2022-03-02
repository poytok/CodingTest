package backjoon
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val s = sc.nextInt()

    var sCopy = s

    // s의 자릿수
    var count = 0

    while (sCopy > 0) {
        sCopy /= 10
        count++
    }

    // 최소값은 자릿수마다 9를 빼주는 것이다.
    val max = count * 9

    // 뺀 경우가 0보다 작으면 0으로 처리 / 18 초과면 해당사항 없음
    val min = if (s - max < 0) 0 else s - max

    for (i in min until s) {
        var answer = i
        i.toString().forEach {
            // 자릿수 덧셈
            answer += it.digitToInt()
        }

        // 자릿수를 모두 더한 값이 입력값과 같은 경우 정답
        if (answer == s) {
            print(i)
            return
        }
    }

    // 해당 경우가 없으면 0 출력
    print("0")
}

// 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
// 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
// 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
// 따라서 245는 256의 생성자가 된다.
// 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
//
// 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.