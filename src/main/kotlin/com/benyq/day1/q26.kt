package com.benyq.day1

fun main() {
    println(removeDuplicates(intArrayOf(1,4,5,6)))
}

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var slow = 0
    for (i in nums.indices) {
        if (nums[slow] != nums[i]) {
            nums[++slow] = nums[i]
        }
    }
    println(nums.contentToString())
    return slow + 1
}