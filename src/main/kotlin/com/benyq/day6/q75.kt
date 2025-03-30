package com.benyq.day6

// https://leetcode.cn/problems/sort-colors/description/

fun main() {
    val nums = intArrayOf(0,0,1,1,1,2)
    sortColors2(nums)
    println(nums.contentToString())
}



// 冒泡排序
fun sortColors(nums: IntArray) {
    for (i in nums.indices) {
        for (j in 0..<nums.size - i - 1) {
            if (nums[j] > nums[j+1]) {
                val temp = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = temp
            }
        }
    }
}

private fun sortColors2(nums: IntArray) {
    var left = 0
    var right = nums.size - 1
    var cur = 0
    while (cur <= right) {
        when (nums[cur]) {
            0 -> {
                swap(nums, left, cur)
                cur++
                left++
            }
            2 -> {
                swap(nums, cur, right)
                right--
            }
            else -> {
                cur++
            }
        }
    }
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

