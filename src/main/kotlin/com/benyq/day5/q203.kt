package com.benyq.day5

import com.benyq.ListNode
import com.benyq.generateListNodes

//https://leetcode.cn/problems/remove-linked-list-elements/description/

fun main() {
    println(removeElements(generateListNodes(intArrayOf(1,2,6,3,4,5,6)), 6))
    println(removeElements(generateListNodes(intArrayOf()), 1))
    println(removeElements(generateListNodes(intArrayOf(7,7,7,7)), 7))
}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val dummyNode = ListNode(-1)
    dummyNode.next = head
    var cur: ListNode? = dummyNode
    while (cur != null) {
        if (cur.next?.`val` == `val`) {
            cur.next = cur.next?.next
        }else {
            cur = cur.next
        }
    }
    return dummyNode.next
}