package com.benyq.day2

import com.benyq.TreeNode
import java.util.LinkedList
import kotlin.math.max

// https://leetcode.cn/problems/diameter-of-binary-tree/description/

fun main() {

}


//其实就是找出根节点的左子树最大深度和右子树的最大深度
//错误的！！！，可能不经过root节点
fun diameterOfBinaryTree2(root: TreeNode?): Int {
    fun findDepth(root: TreeNode?): Int {
        var res = 0
        if (root == null) return 0
        val q = LinkedList<TreeNode>()
        q.add(root)
        while (q.isNotEmpty()) {
            val levelSize = q.size
            for (i in 0 until levelSize) {
                val node = q.removeFirst()
                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }
            ++res
        }
        return res
    }
    return findDepth(root?.left) + findDepth(root?.right)
}
//那只要把每个节点当成root节点，然后获取直径，取最大值即可
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