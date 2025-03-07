### 动态规划专题
q70简单台阶问题  
```kotlin
f(n) = f(n-1) + f(n-2)的规律 
```
q198:小偷问题
```kotlin
dp[i] = max(dp[i-2]+nums[i], dp[i-1])
```
q139: 因为字典中的字符串可以重复，所以是拆分而不是组合
```kotlin
for (i in 1 .. n) {
    for (j in 0 until i) {
        // s[0, i]是否存在j，使[0,j],(j,i]拆分后在wordDict中
        if (wordSet.contains(s.substring(j, i)) && dp[j]) {
            dp[i] = true
            break
        }
    }
}
```