package com.benyq.day2

import com.benyq.TreeNode
import java.util.LinkedList

// https://leetcode.cn/problems/path-sum/description/

fun main() {

}

//递归
fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) {
        return root.`val` == targetSum
    }
    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
}

//迭代
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

