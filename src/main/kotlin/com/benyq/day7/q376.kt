package com.benyq.day7

// https://leetcode.cn/problems/wiggle-subsequence/description/

fun main() {
    println(wiggleMaxLength(intArrayOf(1, 7, 4, 9, 2, 5)))
    println(wiggleMaxLength(intArrayOf(1,17,5,10,13,15,10,5,16,8)))
    println(wiggleMaxLength(intArrayOf(1,2,3,4,5,6,7,8,9)))
}

fun wiggleMaxLength(nums: IntArray): Int {
    if (nums.size < 2) return nums.size
    var preDiff = 0
    var curDiff = 0
    var res = 1
    for (i in 0 until nums.size - 1) {
        curDiff = nums[i+1] - nums[i]
        if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
            res++
            preDiff = curDiff
        }
    }
    return res
}