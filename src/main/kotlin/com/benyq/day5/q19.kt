package com.benyq.day5

import com.benyq.ListNode
import com.benyq.generateListNodes

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/

fun main() {
    println(removeNthFromEnd(generateListNodes(intArrayOf(1,2,3,4,5)), 2))
    println(removeNthFromEnd(generateListNodes(intArrayOf(1)), 1))
    println(removeNthFromEnd(generateListNodes(intArrayOf(1,2)), 1))
}

// 数组存储
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val array = mutableListOf<ListNode>()
    var size = 0
    var cur = head
    while (cur != null) {
        size++
        array.add(cur)
        cur = cur.next
    }
    if (size == n) return head?.next

    array[size-n-1].next = array.getOrNull(size-n+1)
    return head
}