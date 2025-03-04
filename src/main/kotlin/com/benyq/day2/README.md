q94和q144是二叉树的遍历。二叉树的遍历用递归是最快的，而且逻辑也比较简单。
如果用栈辅助遍历，就需要考虑栈的特性，即后入先出。
q94是一个通用的结构，只需要调整  
``` kotlin
    node.second.right?.let { stack.push(Pair(1, it)) }
    stack.push(Pair(2, node.second))
    node.second.left?.let { stack.push(Pair(1, it)) }
```
q101:  
https://leetcode.cn/problems/symmetric-tree/description/  
递归，核心代码：  
```kotlin
//先比较节点值，再递归比较左右子节点
private fun compare(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    else if (left?.`val` != right?.`val`) return false
    else return compare(left?.left, right?.right) && compare(left?.right, right?.left)
}
```
q104使用广度优先搜索，核心是遍历完每一层的所有节点，层级才能+1
```kotlin
while (queue.isNotEmpty()) {
    val levelSize = queue.size // 当前层的节点数
    for (i in 0 until levelSize) {
        val node = queue.removeFirst()
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
    res++ // 每处理完一层，深度加1
}
```
q226是二叉树反转，只要把每个节点都遍历到，然后交换左右子节点  
q112：  
递归：递归判断，当前节点的值是否是子节点，且当前节点的值等于target的剩余
```kotlin
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) {
        return root.`val` == targetSum
    }
    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
}
```
迭代法：  
每个节点都记录从根节点到当前节点的值之和
```kotlin
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    // first是当前节点，second是根节点到当前节点的和
    val queue = LinkedList<Pair<TreeNode, Int>>()
    if (root == null) return false
    queue.add(Pair(root, root.`val`))
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        val current = node.second
        if (current == targetSum && node.first.left == null && node.first.right == null) return true
        node.first.left?.let { queue.add(Pair(it, current + it.`val`)) }
        node.first.right?.let { queue.add(Pair(it, current + it.`val`)) }
    }
    return false
}
```
q617：  
这个其实就是把root2的内容加到root1，所以只要同时往队列中加入root1和root2对应的节点，遍历时同时取出，进行值相加或者节点赋值
```kotlin
while (q.isNotEmpty()) {
    val n1 = q.removeFirst()
    val n2 = q.removeFirst()
    n1.`val` += n2.`val`
    if (n1.left == null) {
        n1.left = n2.left
    }else {
        if (n2.left != null) {
            q.add(n1.left!!)
            q.add(n2.left!!)
        }
    }
    if (n1.right == null) {
        n1.right = n2.right
    }else {
        if (n2.right != null) {
            q.add(n1.right!!)
            q.add(n2.right!!)
        }
    }
}
```
q543:  
二叉树直径本质上是左右子节点的深度之和，但是有可能不经过root，所以需要需要全局变量保存最大的直径
```kotlin
//最大直径
var ans = 0
fun diameterOfBinaryTree(root: TreeNode?): Int {
    fun find(root: TreeNode?): Int {
        if (root == null) return 0
        val left = find(root.left)
        val right = find(root.right)
        ans = max(ans, left + right)
        return max(left, right) + 1
    }
    find(root)
    return ans
}
```