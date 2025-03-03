package com.benyq.day1

import kotlin.math.max

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

fun main() {
    println(lengthOfLongestSubstring("bacabcbb"))
//    println(lengthOfLongestSubstring("bbbbb"))
//    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring(" "))
    println(lengthOfLongestSubstring("au"))
}


fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0
    var slow = 0
    // 可以优化，直接用 char的code当index在数组中记录
    val hash = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        if (hash.containsKey(s[i])) {
            maxLength = max(i - slow, maxLength)
            val temp = hash[s[i]]!! + 1 // 就slow的后一个，可以直接用slow+1
            //移走slow index前的char
            for (j in slow until  temp) {
                hash.remove(s[j])
            }
            slow = temp
        }
        hash[s[i]] = i
    }
    return max(maxLength, hash.size)
}