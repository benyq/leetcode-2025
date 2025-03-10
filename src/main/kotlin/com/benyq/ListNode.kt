package com.benyq

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }
}

fun generateListNodes(array: IntArray): ListNode? {
    if (array.isEmpty()) return null
    val head = ListNode(array[0])
    var cur = head
    for (i in 1 until array.size) {
        val node = ListNode(array[i])
        cur.next = node
        cur = node
    }
    return head
}