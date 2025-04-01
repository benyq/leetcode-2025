package com.benyq.day7

// https://leetcode.cn/problems/maximum-subarray/description/

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
}

fun maxSubArray(nums: IntArray): Int {
    var sum = 0
    var max = Int.MIN_VALUE
    for (i in nums.indices) {
        if (sum < 0) {
            sum = 0
        }
        sum += nums[i]
        if (sum > max) {
            max = sum
        }
    }
    return max
}