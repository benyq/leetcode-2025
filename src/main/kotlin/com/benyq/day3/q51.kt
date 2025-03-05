package com.benyq.day3


// TODO 待回顾
fun main() {
    println(solveNQueens(1))
    println(solveNQueens(3))
    println(solveNQueens(4))
}

fun solveNQueens(n: Int): List<List<String>> {
    val res = mutableListOf<List<String>>()
    val board = Array(n) { Array(n) { "." } }
    backtrack(n, 0, res, board)
    return res
}

private fun backtrack(n: Int, row: Int, result: MutableList<List<String>>, board: Array<Array<String>>) {
    if (row == n) {
        result.add(board.map { it.joinToString("")})
        return
    }
    for (col in 0 until n) {
        if (isValid(n, row, col, board)) {
            board[row][col] = "Q"
            backtrack(n, row + 1, result, board)
            board[row][col] = "."
        }
    }
}

private fun isValid(n: Int, row: Int, col: Int, board: Array<Array<String>>): Boolean {
    // 往上找
    for (i in 0  until row) {
        if (board[i][col] == "Q") return false
    }
    var i = row
    var j = col
    // 往左上找
    while (i >= 0 && j >= 0) {
        if (board[i][j] == "Q") return false
        --i
        --j
    }
    i = row
    j = col
    while (i >= 0 && j < n) {
        if (board[i][j] == "Q") return false
        --i
        ++j
    }
    return true
}