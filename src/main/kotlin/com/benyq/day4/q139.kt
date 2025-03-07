package com.benyq.day4

// https://leetcode.cn/problems/word-break/description/

fun main() {
println(wordBreak("leetcode", listOf("leet", "code")))
println(wordBreak("applepenapple", listOf("apple", "pen")))
println(wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
}


fun wordBreak(s: String, wordDict: List<String>): Boolean {
    if (s.isEmpty() || wordDict.isEmpty()) return false
    val wordSet = wordDict.toSet() // 转换为 Set 提高查找效率
    val n = s.length
    val dp = BooleanArray(s.length + 1) { false }
    dp[0] = true
    for (i in 1 .. n) {
        for (j in 0 until i) {
            // s[0, i]是否存在j，使[0,j],(j,i]拆分后在wordDict中
            if (wordSet.contains(s.substring(j, i)) && dp[j]) {
                dp[i] = true
                break
            }
        }
    }
    return dp[n]
}




