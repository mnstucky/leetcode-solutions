// https://leetcode.com/problems/word-search/submissions/

import java.util.*;

class WordSearch {
    
    public boolean exist(char[][] board, String word) {
        int row = 0;
        int col = 0;
        while (row <= board.length - 1 && col <= board[0].length - 1) {
            if (board[row][col] == word.charAt(0)) {
                Set<String> used = new HashSet<>();
                if (recursiveExist(board, row, col, word, used)) {
                    return true;
                }
            }
            if (col == board[0].length - 1) {
                row++;
                col = 0;
                continue;
            }
            col++;
        }
        return false;
    }

    private boolean recursiveExist(char[][] board, int row, int col, String word, Set used) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (used.contains(row + "," + col)) {
            return false;
        }
        if (board[row][col] == word.charAt(0)) {
            if (word.length() == 1) {
                return true;
            } else {
                used.add(row + "," + col);
                if (recursiveExist(board, row + 1, col, word.substring(1), used)
                        || recursiveExist(board, row - 1, col, word.substring(1), used)
                        || recursiveExist(board, row, col + 1, word.substring(1), used)
                        || recursiveExist(board, row, col - 1, word.substring(1), used)) {
                    return true;
                } else {
                    used.remove(row + "," + col);
                    return false;
                }
            }
        } else {
            return false;
        }
    }

}