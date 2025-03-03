package com.benyq.day1

import kotlin.math.max
import kotlin.math.min

// https://leetcode.cn/problems/container-with-most-water/description/
fun main() {
    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    println(maxArea(intArrayOf(1,1)))
}


fun maxArea(height: IntArray): Int {
    var maxCap = 0
    var left = 0
    var right = height.lastIndex
    while (left < right) {
        val area = (right - left) * min(height[left], height[right])
        maxCap = max(maxCap, area)
        if (height[left] <= height[right]) {
            left++
        }else {
            right--
        }
    }
    return maxCap
}