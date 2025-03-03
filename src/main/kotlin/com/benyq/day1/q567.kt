package com.benyq.day1

// https://leetcode.cn/problems/permutation-in-string/description/
//先找出s1的所有排列组合，然后根据s1的长度，在s2中寻找

fun main() {
    println(checkInclusion("ab", "eidbaooo"))
    println(checkInclusion("ab", "eidboaoo"))
}

fun checkInclusion(s1: String, s2: String): Boolean {
    var left = 0
    val letters = IntArray(26)
    for (char in s1.toCharArray()) {
        letters[char.code - 97] += 1
    }
    val targetLetters = IntArray(26)
    for (right in s2.indices) {
        targetLetters[s2[right].code - 97] += 1
        if (right >= s1.length - 1) {
            val str = s2.substring(left, right + 1)
            // 判断是否存在
            if (check(letters, targetLetters)) return true
            targetLetters[s2[left++].code - 97] -= 1
        }
    }
    return false
}

//只需要检测s1和s2是否有一样的字符
private fun check(s1: IntArray, s2: IntArray): Boolean {
    for(i in s1.indices) {
        if (s1[i] != s2[i]) return false
    }
    return true
}

