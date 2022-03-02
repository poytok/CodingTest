package programmers
fun main() {
    println(
        solution12951("    a3people unFollowed me")
    )
    println(
        solution12951("aaaaa aaa")
    )
    println(
        solution12951("tomato     ")
    )
}


fun solution12951(s: String): String {
    return s.toLowerCase().split(" ").map {
        it.mapIndexed { index, c ->
            if (index == 0) c.toUpperCase()
            else c
        }.joinToString(separator = "")
    }.joinToString(" ")
}