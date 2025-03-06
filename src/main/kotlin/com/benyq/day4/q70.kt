package com.benyq.day4

// https://leetcode.cn/problems/climbing-stairs/description/

fun main() {
    println(climbStairs(2))
    println(climbStairs(3))
    println(climbStairs(45))
}


private val hash = mutableMapOf<Int, Int>()
fun climbStairs(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2
    if (hash.containsKey(n)) return hash[n]!!
    val sum = climbStairs(n - 1) + climbStairs(n - 2)
    hash[n] = sum
    return sum
}

