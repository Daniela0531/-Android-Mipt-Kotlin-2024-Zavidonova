import java.math.BigInteger

fun getFibonacciByIndex(index: BigInteger): BigInteger {
    if (index == BigInteger.ZERO) {
        return BigInteger.ZERO
    }
    if (index < BigInteger.ZERO) {
        throw IndexOutOfBoundsException(index.toString())
    }
    var n0 = BigInteger.ZERO
    var n1 = BigInteger.ONE
    var i = BigInteger.TWO
    while (i <= index) {
        val n2 = n0 + n1
        n0 = n1
        n1 = n2
        ++i
    }
    return n1
}

fun main() {
    var input = readLine()!!.split(" ")
    var n = input!![0].toBigInteger()
    var m = input!![1].toBigInteger()
    println(getFibonacciByIndex(n)%m)
}