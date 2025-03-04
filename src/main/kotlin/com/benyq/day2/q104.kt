package com.benyq.day2

import com.benyq.TreeNode
import java.util.LinkedList

// https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/

fun main() {

}


//BFS
fun maxDepth(root: TreeNode?): Int {
    var res = 0
    if (root == null) return res
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        for (i in 0 until levelSize) {
            val node = queue.removeFirst()
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        res++ // 每处理完一层，深度加1
    }
    return res
}
