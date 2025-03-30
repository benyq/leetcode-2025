package com.benyq.day6

// https://leetcode.cn/problems/move-zeroes/description/

fun main() {

}

fun moveZeroes(nums: IntArray) {
    var left = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            val temp = nums[left]
            nums[left] = nums[i]
            nums[i] = temp
            left++
        }
    }
}