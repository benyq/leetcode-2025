q26和q127是同向的快慢指针，适用场景：数组去重、原地修改、链表操作
``` java
int slow = 0;
for (int fast = 0; fast < nums.length; fast++) {
    if (满足条件) {
        nums[slow++] = nums[fast];
    }
}
return slow;
```
q125和q167是左右指针，适用场景：有序数组求和、回文判断
``` java
int left = 0, right = nums.length - 1;
while (left < right) {
    int sum = nums[left] + nums[right];
    if (sum == target) return ...;
    else if (sum < target) left++;
    else right--;
}
```
q643和q567 是移动窗口
``` java
int left = 0, sum = 0;
for (int right = 0; right < nums.length; right++) {
    sum += nums[right];
    if (right >= k - 1) {
        maxAvg = Math.max(maxAvg, sum / k);
        sum -= nums[left++];
    }
}
```
q3和q76 滑动窗口

q209 滑动窗口

q424主要问题是maxCount。这个maxCount是程序运行过程中，当前窗口中存在最多相同字母的个数。只要滑动窗口长度-maxCount小于k(可修改次数)，那么当前移动窗口就是符合条件的

q11的问题是很难想到是双指针。。。由于面积是由短板决定，所以先确定宽度最大，这样先左右边界。要获得更大的面积，只能替换掉短板，所以判断条件是:
``` java
    if (height[left] <= height[right]) {
        left++
    }else {
        right--
    }
```