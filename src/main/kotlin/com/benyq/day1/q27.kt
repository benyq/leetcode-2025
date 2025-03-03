package com.benyq.day1


fun main() {
    println(removeElement(intArrayOf(3,2,2,3), 3))
    println(removeElement(intArrayOf(0,1,2,2,3,0,4,2), 2))
}

fun removeElement(nums: IntArray, value: Int): Int {
    var slow = 0
    for (i in nums.indices) {
        if (nums[i] != value) {
            nums[slow++] = nums[i]
        }
    }
    return slow
}