package com.benyq.day5

import com.benyq.ListNode
import com.benyq.generateListNodes

// https://leetcode.cn/problems/reverse-linked-list/description/


fun main() {
    println(reverseList(generateListNodes(intArrayOf(1,2,3,4,5))))
    println(reverseList(generateListNodes(intArrayOf(1,2))))
    println(reverseList(generateListNodes(intArrayOf())))
}

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return null
    var cur = head
    var newNode: ListNode? = null
    while (cur != null)  {
        val next = cur.next
        cur.next = newNode
        newNode = cur
        cur = next
    }
    return newNode
}