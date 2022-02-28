import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val dwarfList = IntArray(9) { sc.nextInt() }
    findDwarf(dwarfList)
}


fun findDwarf(dwarfList: IntArray) {
    for (i in dwarfList.indices) {
        for (j in dwarfList.indices) {
            if (i == j) continue
            val list = dwarfList.copyOf()
            list[i] = 0
            list[j] = 0

            if(list.sum() == 100) {
                list.sortedArray().forEach {
                    if(it != 0) println(it)
                }
                return
            }
        }
    }
}