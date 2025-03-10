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