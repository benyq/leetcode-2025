package com.benyq.day1

// https://leetcode.cn/problems/minimum-window-substring/description/

fun main() {
    println(minWindow("ADOBECODEBANC", "ABC"))
    println(minWindow("a", "a"))
    println(minWindow("a", "aa"))
}


fun minWindow(s: String, t: String): String {
    if (s.length < t.length) return ""
    var slow = 0
    var out = ""
    var length = -1
    val oriArray = IntArray(128){ 0 }
    for (c in t) {
        oriArray[c.code] += 1
    }
    val contArray = IntArray(128) { 0 }
    for (right in s.indices) {
        contArray[s[right].code] += 1
        while (right - slow + 1 >= t.length && check(oriArray, contArray)) {
            val temp = s.substring(slow, right + 1)
            if (out.isEmpty() || out.length > temp.length) {
                out = temp
            }
            contArray[s[slow++].code] -= 1
        }
    }
    return out
}

private fun check(oriArray: IntArray, contArray: IntArray): Boolean {
    for (i in oriArray.indices) {
        if (contArray[i] < oriArray[i]) return false
    }
    return true
}