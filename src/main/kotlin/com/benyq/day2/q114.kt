package com.benyq.day2
import com.benyq.TreeNode
import com.benyq.buildCompleteBinaryTree
import java.util.LinkedList

// https://leetcode.cn/problems/binary-tree-preorder-traversal/description/

fun main() {
    val root1 = buildCompleteBinaryTree(arrayOf(1,null,2,3))
    println(root1)
    println(preorderTraversal1(root1))
    println(preorderTraversal2(root1))
}

fun preorderTraversal1(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    fun work(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return
        list.add(node.`val`)
        work(node.left, list)
        work(node.right, list)
    }
    work(root, result)
    return result
}

fun preorderTraversal2(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    if (root == null) return result

    val queue = LinkedList<TreeNode>()
    queue.push(root)
    while (queue.isNotEmpty()) {
        val cur = queue.pop()
        result.add(cur.`val`)
        cur.right?.let { queue.push(it) }
        cur.left?.let { queue.push(it) }
    }
    return result
}