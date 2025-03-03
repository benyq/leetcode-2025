package com.benyq.day1

// https://leetcode.cn/problems/valid-palindrome/description/

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
    println(isPalindrome("0P"))
}

fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    while (start < end) {
        if (!s[start].isLetterOrDigit()) {
            start++
            continue
        }
        if (!s[end].isLetterOrDigit()) {
            end--
            continue
        }
        if (s[start].uppercase() != s[end].uppercase()) {
            return false
        }
        start++
        end--
    }
    return true
}

