package com.benyq.day2

import com.benyq.TreeNode
import java.util.*

// https://leetcode.cn/problems/invert-binary-tree/

fun main() {

}

//递归
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val left = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(left)
    return root
}

// 迭代法
fun invertTree2(root: TreeNode?): TreeNode? {
    if (root == null) return root
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        val left = node.left
        node.left = node.right
        node.right = left
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
    return root
}