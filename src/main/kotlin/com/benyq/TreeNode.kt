package com.benyq

class TreeNode(
    var `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null


) {
    override fun toString(): String {
        return "TreeNode(`val`=$`val`, left=$left, right=$right)"
    }
}
fun buildCompleteBinaryTree(preorder: Array<Int?>): TreeNode? {
    // 使用一个可变索引来跟踪当前处理的位置
    var index = 0

    fun helper(): TreeNode? {
        // 如果当前索引超出数组范围或值为 null，则返回 null
        if (index >= preorder.size || preorder[index] == null) {
            return null
        }

        // 创建当前节点
        val node = TreeNode(preorder[index]!!)
        index++ // 移动到下一个元素

        // 递归构建左子树
        node.left = helper()

        // 递归构建右子树
        node.right = helper()

        return node
    }

    // 调用辅助函数构建二叉树
    return helper()
}