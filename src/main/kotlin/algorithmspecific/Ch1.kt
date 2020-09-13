package algorithmspecific

import sun.security.ec.point.ProjectivePoint

/**
 * From book algorithm
 * Statement in java/koltin
 *  - variable declarations
 *  - Assignments
 *  - conditionals is statement in java but expression in kotlin
 */


fun main(){
    val alist = mutableListOf<Int>(1,2,3,4,5)
    print(reverseArray(alist))
}
fun <T> reverseArray( list: MutableList<T>) : List<T> {
    // or just list.reversed()
    val size = list.size
    for (x in 0 until list.size/2){
        val temp = list[x]
        list[x] = list[size -1 - x]
        list[size -1 - x] = temp
    }
    return list.toList()
}
