package com.benyq.day1

import kotlin.math.max

fun main() {
    println(characterReplacement("ABAB", 2))
    println(characterReplacement("AABABBA", 1))
}

fun characterReplacement(s: String, k: Int): Int {
    var left = 0
    var res = 0
    var maxCount = 0
    val array = IntArray(26) { 0 }
    for (right in s.indices) {
        array[s[right] - 'A'] += 1
        maxCount = max(maxCount, array[s[right] - 'A'])
        while (right - left + 1 - maxCount > k) {
            array[s[left++] - 'A'] -= 1
        }
        res = max(res, right - left + 1)
    }
    return res
}