### 链表

q203使用了虚拟节点，q206没有使用。使用虚拟节点是为了方便处理删除节点的操作  
q24：同时保存pre,cur两个节点。
```kotlin
while (cur?.next != null) {
    val next = cur.next?.next
    //交换节点
    pre.next = cur.next
    cur.next?.next = cur
    cur.next = next

    pre = cur
    cur = next
}
```

q19可以遍历一遍，将node和index存到数组中，然后按照index查找删除即可。
也可以使用快慢指针的思想，这个方法不会产生额外的内存空间  

q02_07: 最简单就是遍历两个节点，使用map存起来。重复值就是结果；如果不能申请额外内存，就是要想办法将A和B的长度弄成一样的，然后遍历比较。
```java
ListNode fa = headA;
ListNode fb = headB;
int sizeA = 0;
int sizeB = 0;
while (fa != null) {
    sizeA++;
    fa = fa.next;
}
while (fb != null) {
    sizeB++;
    fb = fb.next;
}
int diff = Math.abs(sizeA-sizeB);
fa = headA;
fb = headB;
if (sizeA > sizeB) {
    while (diff > 0) {
        fa = fa.next;
        diff--;
    }
}else if (sizeA < sizeB) {
    while (diff > 0) {
        fb = fb.next;
        diff--;
    }
}
```
