fun main() {
//    val sc = Scanner(System.`in`)
//    val n = sc.nextInt()
//    while (n != -1) {
//    println(solution(n))
//    }
//    println(
//        solution92334(
//            arrayOf("muzi", "frodo", "apeach", "neo"),
//            arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
//            2
//        ).contentToString()
//    )

    println(
        solution92334(
            arrayOf("con", "ryan"),
            arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
            3
        ).contentToString()
    )
}


fun solution92334(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    var answer: IntArray = intArrayOf()

    val map = LinkedHashMap<String, MutableList<String>>()
    val reportCountMap = HashMap<String, Int>()
    id_list.forEach {
        map[it] = mutableListOf()
        reportCountMap[it] = 0
    }

    report.distinct().forEach {
        val split = it.split(" ").distinct()
        map[split[0]] = (map[split[0]]?.plus(split[1]))?.toMutableList() ?: mutableListOf()
        reportCountMap[split[1]] = (reportCountMap[split[1]] ?: 0) + 1
    }


    map.forEach { (key, value) ->
        var count = 0
        value.forEach {
            if ((reportCountMap[it] ?: 0) >= k) {
                count++
            }
        }
        answer += count
    }

    return answer
}