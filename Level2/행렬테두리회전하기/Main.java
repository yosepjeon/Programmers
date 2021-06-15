package Level2.행렬테두리회전하기;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;

        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };

//        int rows = 3;
//        int columns = 3;
//
//        int[][] queries = {
//                {1,1,2,2},
//                {1,2,2,3},
//                {2,1,3,2},
//                {2,2,3,3}
//        };

//        int rows = 100;
//        int columns = 97;
//
//        int[][] queries = {
//                {1,1,100,97}
//        };

        Solution solution = new Solution();

        int[] result = solution.solution(rows, columns, queries);

        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        Matrix matrix = new Matrix(rows, columns);

        int queryCount = queries.length;
        answer = new int[queryCount];
        for(int i=0;i<queryCount;i++) {
            answer[i] = matrix.rotate(queries[i]);
        }

        return answer;
    }

}

class Matrix {
    int min;
    int[][] matrix;

    public Matrix(int rows, int columns) {
        matrix = new int[rows + 1][columns + 1];

        int num = 1;
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                matrix[row][column] = num++;
            }
        }
    }

    public int rotate(int[] query) {
        int row1 = query[0];
        int col1 = query[1];

        int row2 = query[2];
        int col2 = query[3];

        min = Integer.MAX_VALUE;

        System.out.println("[" + query[0] + ", " + query[1] + ", " + query[2] + ", " + query[3] + "]");
        int[][] copyMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = col1; i < col2; i++) {
            matrix[row1][i+1] = copyMatrix[row1][i];

            if(min > copyMatrix[row1][i]) {
                min = copyMatrix[row1][i];
            }
        }

        for (int i = row1; i < row2; i++) {
            matrix[i+1][col2] = copyMatrix[i][col2];

            if(min > copyMatrix[i][col2]) {
                min = copyMatrix[i][col2];
            }
        }

        for (int i = col2; i > col1; i--) {
            matrix[row2][i-1] = copyMatrix[row2][i];

            if(min > copyMatrix[row2][i]) {
                min = copyMatrix[row2][i];
            }
        }

        for (int i = row2; i > row1; i--) {
            matrix[i-1][col1] = copyMatrix[i][col1];

            if(min > copyMatrix[i][col1]) {
                min = copyMatrix[i][col1];
            }
        }

        return min;
    }
}