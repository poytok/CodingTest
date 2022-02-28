import java.math.BigInteger
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val l = sc.nextInt()
    val aa = sc.next()
    var sum = BigInteger("0")
    val mod = BigInteger("1234567891")

    for (i in 0 until l) {
        sum = sum.plus(BigInteger("31").pow(i).multiply(BigInteger.valueOf(((aa[i] - 'a') + 1).toLong())))
    }


    println(sum.mod(mod))
}