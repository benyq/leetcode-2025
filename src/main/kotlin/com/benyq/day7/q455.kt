package com.benyq.day7

// https://leetcode.cn/problems/assign-cookies/description/

fun main() {
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}


fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var gIndex = g.lastIndex
    var sIndex = s.lastIndex
    var result = 0
    while (sIndex >= 0 && gIndex >= 0) {
        if (g[gIndex] <= s[sIndex]) {
            result++
            gIndex--
            sIndex--
        } else {
            gIndex--
        }
    }
    return result
}
