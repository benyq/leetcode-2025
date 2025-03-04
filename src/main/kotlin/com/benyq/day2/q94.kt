package com.benyq.day2

import com.benyq.TreeNode
import java.util.LinkedList

//https://leetcode.cn/problems/binary-tree-inorder-traversal/description/

fun main() {

}

// 这个是栈遍历的通用模式，只不过因为是栈实现，所有需要考虑下left和right的顺序
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    if (root == null) return result
    val stack = LinkedList<Pair<Int, TreeNode>>()
    stack.push(Pair(1, root))
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        if (node.first == 1) {
            node.second.right?.let { stack.push(Pair(1, it)) }
            stack.push(Pair(2, node.second))
            node.second.left?.let { stack.push(Pair(1, it)) }
        }else {
            result.add(node.second.`val`)
        }
    }
    return result
}