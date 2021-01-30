// https://leetcode.com/problems/word-search/submissions/

// Runtime: 4 ms, faster than 98.91% of Java online submissions for Word Search.
// Memory Usage: 41.1 MB, less than 54.96% of Java online submissions for Word Search.

class Solution {

    public boolean exist(char[][] board, String word) {
        char firstLtr = word.charAt(0);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == firstLtr && recursiveExist(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recursiveExist(char[][] board, int row, int col, String word, int wordIdx) {
        if (wordIdx == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(wordIdx)) {
            return false;
        }
        char visitedChar = board[row][col];
        board[row][col] = ' ';
        boolean result = recursiveExist(board, row + 1, col, word, wordIdx + 1)
                || recursiveExist(board, row - 1, col, word, wordIdx + 1)
                || recursiveExist(board, row, col + 1, word, wordIdx + 1)
                || recursiveExist(board, row, col - 1, word, wordIdx + 1);
        board[row][col] = visitedChar;
        return result;

    }

}