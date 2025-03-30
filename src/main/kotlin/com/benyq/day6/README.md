day6排序算法  
q75 国旗
1. 冒泡排序
2. 双指针
``` kotlin
var left = 0
var right = nums.size - 1
var cur = 0
while (cur <= right) {
    when (nums[cur]) {
        0 -> {
            swap(nums, left, cur)
            cur++
            left++
        }
        2 -> {
            swap(nums, cur, right)
            right--
        }
        else -> {
            cur++
        }
    }
}
```
q283只要定义一个指针 left，从前往后遍历，如果当前元素不为 0，则和 left 位置的元素交换，left 向后移动一位。
