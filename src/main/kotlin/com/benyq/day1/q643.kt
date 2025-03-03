package com.benyq.day1

import kotlin.math.max

fun main() {
//    println(findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4))
//    println(findMaxAverage(intArrayOf(5), 1))
    println(findMaxAverage(intArrayOf(-1), 1))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = 0
    var left = 0
    var maxV = -Double.MAX_VALUE
    for (right in nums.indices) {
        sum+= nums[right]
        if (right >= k - 1) {
            maxV = max(maxV, 1.0 * sum / k)
            sum -=nums[left++]
        }
    }
    return maxV
}