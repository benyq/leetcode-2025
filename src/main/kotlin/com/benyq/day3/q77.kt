package com.benyq.day3

import java.util.ArrayList
import java.util.LinkedList

// https://leetcode.cn/problems/combinations/description/

fun main() {

}

fun combine(n: Int, k: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack(n, k, 1, res, LinkedList())
    return res
}


private fun backtrack(n: Int, k: Int, startIndex: Int, result: MutableList<List<Int>>,stack: LinkedList<Int>) {
    if (stack.size == k) {
        result.add(ArrayList(stack))
    }
    for (i in startIndex .. n) {
        if (stack.contains(i)) {
            continue
        }
        stack.add(i)
        // i + 1 : 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
        backtrack(n, k, i + 1, result, stack)
        stack.removeLast()
    }
}