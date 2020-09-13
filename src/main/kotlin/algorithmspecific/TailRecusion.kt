package algorithmspecific
/**
 * Time complexity O(2^n)
 * space complexity O(n)
 */
fun nonTailRecuFib(n: Int): Long {
    return when (n) {
        0 -> 0
        1 -> 1
        else -> nonTailRecuFib(n - 1) + nonTailRecuFib(n - 2)
    }
}
/**
 * Time complexity O(n)
 * space complexity O(1)
 */
fun tailRecuFib(n: Int): Long {
    return tailFibAux(n - 1, 0, 1)
}



fun tailFibAux(n: Int, a: Long, b: Long): Long {
    if (n == 0) {
        return b
    }
    return tailFibAux(n - 1, b, a + b)
}


fun main() {
    val time2 = System.nanoTime()
    print(tailRecuFib(25))
    println("tail time : ${(System.nanoTime() - time2)}")
    val time1 = System.currentTimeMillis()
    print(nonTailRecuFib(25))
    println("non tail time : ${(System.nanoTime() - time1)}")


}