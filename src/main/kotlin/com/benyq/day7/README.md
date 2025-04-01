贪心算法  
贪心算法的核心思想是：在每一步中，都选择当前状态下最好（或最差）的选择。
q455 分饼干，尽量满足大饼干分给大胃口
```kotlin
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
```
q376 摆动序列  
找出数组中的波峰
```kotlin
for (i in 0 until nums.size - 1) {
    curDiff = nums[i+1] - nums[i]
    if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
        res++
        preDiff = curDiff
    }
}
```
