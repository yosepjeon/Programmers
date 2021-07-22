package skill_check_level3.p1;

public class Main {
}

class Solution {
    static int size;

    public int solution(int[][] board) {
        int answer = 0;

        size = board.length;

        return answer;
    }
}

class Robot {
    Side leftSide;
    Side rightSide;

    public Robot(Side leftSide, Side rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public void rotateByLeftSide(int[][] board) {
        if (leftSide.col < rightSide.col && rightSide.row + 1 < Solution.size && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col - 1] == 0) {

        }

        if (leftSide.col > rightSide.col && rightSide.col - 1 >= 0 && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row < rightSide.row && rightSide.col + 1 < Solution.size && board[rightSide.row][rightSide.col + 1] == 0 && board[rightSide.row - 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row > rightSide.row && rightSide.col - 1 >= 0 && board[rightSide.row][rightSide.col - 1] == 0 && board[rightSide.row - 1][rightSide.col - 1] == 0) {

        }
    }

    public void reverseRotateByLeftSide(int[][] board) {
        if (leftSide.col < rightSide.col && rightSide.row + 1 < Solution.size && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col - 1] == 0) {

        }

        if (leftSide.col > rightSide.col && rightSide.col - 1 >= 0 && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row < rightSide.row && rightSide.col + 1 < Solution.size && board[rightSide.row][rightSide.col + 1] == 0 && board[rightSide.row - 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row > rightSide.row && rightSide.col - 1 >= 0 && board[rightSide.row][rightSide.col - 1] == 0 && board[rightSide.row - 1][rightSide.col - 1] == 0) {

        }
    }

    public void rotateByRightSide(int[][] board) {
        if (leftSide.col < rightSide.col && rightSide.row + 1 < Solution.size && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col - 1] == 0) {

        }

        if (leftSide.col > rightSide.col && rightSide.col - 1 >= 0 && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row < rightSide.row && rightSide.col + 1 < Solution.size && board[rightSide.row][rightSide.col + 1] == 0 && board[rightSide.row - 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row > rightSide.row && rightSide.col - 1 >= 0 && board[rightSide.row][rightSide.col - 1] == 0 && board[rightSide.row - 1][rightSide.col - 1] == 0) {

        }
    }

    public void reverseRotateByRightSide(int[][] board) {
        if (leftSide.col < rightSide.col && rightSide.row + 1 < Solution.size && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col - 1] == 0) {

        }

        if (leftSide.col > rightSide.col && rightSide.col - 1 >= 0 && board[rightSide.row + 1][rightSide.col] == 0 && board[rightSide.row + 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row < rightSide.row && rightSide.col + 1 < Solution.size && board[rightSide.row][rightSide.col + 1] == 0 && board[rightSide.row - 1][rightSide.col + 1] == 0) {

        }

        if (leftSide.row > rightSide.row && rightSide.col - 1 >= 0 && board[rightSide.row][rightSide.col - 1] == 0 && board[rightSide.row - 1][rightSide.col - 1] == 0) {

        }
    }

}

class Side {
    int col;
    int row;

    public Side(int col, int row) {
        this.col = col;
        this.row = row;
    }
}