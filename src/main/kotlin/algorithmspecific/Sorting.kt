package algorithmspecific

/**
 * @param MutableList<T> unsorted list
 * insertion sort is of O(n^2)
 * which make it much less effiency
 */
fun <T : Comparable<T>> insertionSort(items: MutableList<T>): List<T> {
    if (items.isEmpty() || items.size < 2) {
        return items
    }
    for (key in 1 until items.count()) {
        val item = items[key]
        var i = key
        while (i > 0 && item < items[i - 1]) {
            items[i] = items[i - 1]
            i -= 1
        }
        items[i] = item
    }
    return items
}

/**
 * @param MutableList<T> unsorted list
 * quicksort sort is of O(n*logn)
 * worst case : a sorted list with first/last element is used as pivot
 * which make it ok efficiency
 */
fun <T : Comparable<T>> quickSort(items: MutableList<T>): List<T>{
    if (items.isEmpty() || items.size < 2) {
        return items
    }
    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }

//    println("pivot value is : "+equal)

    val less = items.filter { it < pivot }.toMutableList()
//    println("Lesser values than pivot : "+less)

    val greater = items.filter { it > pivot }.toMutableList()
//    println("Greater values than pivot : "+greater)
    return quickSort(less) + equal + quickSort(greater)
}




fun main() {
    val unsortedList = mutableListOf(8, 3, 2, 7, 4)
    var orderedList = quickSort(unsortedList)
    println(orderedList)
}
