package com.benyq.day1

// https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
// 题目重点是 非递减顺序排列

fun main() {
    println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    println(twoSum(intArrayOf(2,3,4), 6).contentToString())
    println(twoSum(intArrayOf(-1,0), -1).contentToString())
}


fun twoSum(numbers: IntArray, target: Int): IntArray {
    var start = 0
    var end = numbers.lastIndex
    while (start < end) {
        if (numbers[start] + numbers[end] < target) {
            start++
        }else if (numbers[start] + numbers[end] > target) {
            end--
        }else {
            break
        }
    }
    return intArrayOf(start + 1, end + 1)
}

