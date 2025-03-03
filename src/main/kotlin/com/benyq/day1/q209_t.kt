package com.benyq.day1

import kotlin.math.min

// https://leetcode.cn/problems/minimum-size-subarray-sum/

fun main() {


}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var result = Int.MAX_VALUE
    var sum = 0
    var left = 0
    for (i in nums.indices) {
        sum += nums[i]
        while (sum >= target) {
            result = min(i - left + 1, result)
            sum -= nums[left++]
        }
    }
    return if (result == Int.MAX_VALUE) 0 else result
}