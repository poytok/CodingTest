fun main() {

    println(
        solution42888_2(
            arrayOf(
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            )
        ).contentToString()
    )
}

// 시간초과
fun solution42888_1(record: Array<String>): Array<String> {
    var answer = arrayOf<String>()
    var pair = arrayOf<Pair<String, String>>()
    record.forEach { recordString ->
        val split = recordString.split(" ")
        when (split[0]) {
            "Enter" -> {

                pair = pair.map {
                    if (split[1] == it.first) Pair(
                        split[1],
                        it.second.replaceRange(0 until it.second.indexOf("님이"), split[2])
                    )
                    else it
                }.toTypedArray()
                pair += Pair(split[1], "${split[2]}님이 들어왔습니다.")
            }

            "Leave" -> {
                val findPair = pair.find { it.first == split[1] }
                if (findPair != null) {
                    val second = findPair.second.replaceRange(
                        findPair.second.indexOf("님이") until findPair.second.length,
                        "님이 나갔습니다."
                    )
                    pair += Pair(split[1], second)
                }
            }

            "Change" -> {
                pair = pair.map {
                    if (split[1] == it.first) Pair(
                        split[1],
                        it.second.replaceRange(0 until it.second.indexOf("님이"), split[2])
                    )
                    else it
                }.toTypedArray()
            }
        }
    }

    pair.forEach {
        answer += it.second
    }
    return answer
}

// 정답
fun solution42888_2(record: Array<String>): Array<String> {
    var answer = arrayOf<String>()
    val nameMap = HashMap<String, String>()

    record.forEach { recordString ->
        val split = recordString.split(" ")
        when (split[0]) {
            "Enter", "Change" -> {
                nameMap[split[1]] = split[2]
            }
        }
    }

    record.map {
        val split = it.split(" ")
        when (split[0]) {
            "Enter" -> {
                answer += "${nameMap[split[1]]}님이 들어왔습니다."
            }

            "Leave" -> {
                answer += "${nameMap[split[1]]}님이 나갔습니다."
            }
        }
    }


    return answer
}