object GCD {
    fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val tmp = a % b
            a = b
            b = tmp
        }
        return a
    }
}

fun main(args: Array<String>) {
    val tmp = readLine()!!.split(" ")
    val a = tmp!![0].toInt()
    val b = tmp!![1].toInt()
    println(GCD.gcd(a, b))
}