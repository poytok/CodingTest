package project_Euler


/*
Problem 1
10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.
1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?
* */
fun main() {
    val array = IntArray(1000) { it }
    println(array.filter { it % 3 == 0 || it % 5 == 0 }.sum())
}