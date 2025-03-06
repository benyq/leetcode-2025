package com.benyq.day4

import kotlin.math.max

// https://leetcode.cn/problems/house-robber/

fun main() {
    println(rob(intArrayOf(1, 2, 3, 1)))
//    println(rob(intArrayOf(2, 7, 9, 3, 1)))
}

fun rob(nums: IntArray): Int {
    if (nums.size < 3) return nums.max() ?: 0
    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for (i in 2 until nums.size) {
        dp[i] = max(dp[i-2]+nums[i], dp[i-1])
    }
    return dp[nums.lastIndex]
}
