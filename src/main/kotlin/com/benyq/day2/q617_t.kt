package com.benyq.day2

import com.benyq.TreeNode
import java.util.LinkedList

// https://leetcode.cn/problems/merge-two-binary-trees/description/

fun main() {

}

//递归
fun mergeTrees2(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null && root2 == null) return null
    val root = root1 ?: root2
    root?.`val` = (root1?.`val` ?: 0) + (root2?.`val` ?: 0)
    root?.left = mergeTrees2(root1?.left, root2?.left)
    root?.right = mergeTrees2(root1?.right, root2?.right)
    return root
}

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1
    val q = LinkedList<TreeNode>()
    q.add(root1)
    q.add(root2)
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
    return root1
}