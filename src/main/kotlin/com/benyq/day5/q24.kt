package com.benyq.day5

import com.benyq.ListNode
import com.benyq.generateListNodes


// https://leetcode.cn/problems/swap-nodes-in-pairs/description/

fun main() {
    println(swapPairs(generateListNodes(intArrayOf(1,2,3,4))))
    println(swapPairs(generateListNodes(intArrayOf())))
    println(swapPairs(generateListNodes(intArrayOf(1))))
}


fun swapPairs(head: ListNode?): ListNode? {
    var cur = head
    var dummyNode = ListNode(0)
    dummyNode.next = head
    var pre = dummyNode
    while (cur?.next != null) {
        val next = cur.next?.next
        pre.next = cur.next
        cur.next?.next = cur
        cur.next = next

        pre = cur
        cur = next
    }

    return dummyNode.next
}


