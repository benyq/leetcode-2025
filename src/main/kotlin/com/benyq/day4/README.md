### 动态规划专题
q70简单台阶问题  
```kotlin
f(n) = f(n-1) + f(n-2)的规律 
```
q198:小偷问题
```kotlin
dp[i] = max(dp[i-2]+nums[i], dp[i-1])
```