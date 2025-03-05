package com.benyq.day3

import java.util.ArrayList
import java.util.LinkedList

fun main() {
    println(combinationSum3(3, 7))
    println(combinationSum3(3, 9))
}


fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack(n, k, 1, res, LinkedList(), 0)
    return res
}

private fun backtrack(n: Int,k: Int, startIndex: Int, result: MutableList<List<Int>>, stack: LinkedList<Int>, sum: Int) {
    if (stack.size == k) {
        if (n == sum) {
            result.add(ArrayList(stack))
        }
        return
    }
    for (i in startIndex .. 9) {
        stack.add(i)
        backtrack(n, k, i + 1, result, stack, sum + i)
        stack.removeLast()
    }

}