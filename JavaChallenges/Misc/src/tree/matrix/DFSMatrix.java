package tree.matrix;

import java.util.Arrays;

public class DFSMatrix {
    // implement a function that receives a matrix int[][] n x m with the following cells:
    // 0: available space
    // -1: wall
    // -2: gates

    // the output is the matrix with the 0s substituted by the distance to the closest gate
    // ex: input:
    // [-2 0 -1 -2]
    // [ 0 0 0  0]

    // would become
    // [-2 1 -1 -2]
    // [ 1 2 2  1]

    // now implementing it using DFS
    // clone matrix

    // loop through whole matrix
        // if a gate is found, perform a DFS starting from that gate and updating all cells if they are valid

    public static boolean isGate(int row, int col, int[][] matrix) {
        return (matrix[row][col] == -2);
    }

    public static boolean isWall(int row, int col, int[][] matrix) {
        return (matrix[row][col] == -1);
    }

    public static boolean isWithinBounds(int row, int col, int[][] matrix) {
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;

        return ((row >= 0) && (row < matrixRows) && (col >= 0) && (col < matrixColumns));
    }

    public static boolean wasVisited(int row, int col, boolean[][] visitMatrix) {
        return visitMatrix[row][col];
    }

    public static boolean isValid(int row, int col, int[][] matrix, boolean[][] visitMatrix) {
        return isWithinBounds(row, col, matrix) &&
                !isGate(row, col, matrix) &&
                !isWall(row, col, matrix) &&
                !wasVisited(row, col, visitMatrix);
    }

    public static void updateDistancesOfNeighbors(int row, int col, int[][] matrix, int thisCellDepth, boolean[][] visitMatrix) {
        updateDistancesToGate(row - 1, col, matrix, thisCellDepth + 1, visitMatrix);
        updateDistancesToGate(row + 1, col, matrix, thisCellDepth + 1, visitMatrix);
        updateDistancesToGate(row, col - 1, matrix, thisCellDepth + 1, visitMatrix);
        updateDistancesToGate(row, col + 1, matrix, thisCellDepth + 1, visitMatrix);
    }

    public static void updateDistancesToGate(int row, int col, int[][] matrix, int depth, boolean[][] visitMatrix) {
//        System.out.println("running for row, col: " + row + ", " + col);

        // if cell is not valid, don't do anything
        if (!isValid(row, col, matrix, visitMatrix)) {
            return;
        }

        // update current cell value with depth if it is possible
        if (matrix[row][col] == 0 || matrix[row][col] > depth) {

            matrix[row][col] = depth;
        }

        // mark cell as visited only for this DFS branch
        visitMatrix[row][col] = true;

        // call function to update distances for all neighbors of this one
        updateDistancesOfNeighbors(row, col, matrix, depth, visitMatrix);

        // mark cell as not visited after adding neighbors (so next DFS branch starts clean)
        visitMatrix[row][col] = false;
    }

    public static int[][] updateDistancesToGates(int[][] matrix) {

        int[][] newMatrix = matrix.clone();

        // loop through all cells
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // if current cell is a gate, perform DFS updating all cells as a function of this gate
                if (isGate(i, j, matrix)) {
//                    System.out.println("Doing dfs for gate " + i + ", " + j);
                    boolean[][] visitMatrix = new boolean[matrix.length][matrix[0].length];

                    updateDistancesOfNeighbors(i, j, matrix, 0, visitMatrix);
                }
            }
        }

        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        // [-2 0 -1 -2]
        // [ 0 0 0  0]
//        int[][] matrix = new int[2][4];
//        matrix[0][0] = -2;
//        matrix[0][1] = 0;
//        matrix[0][2] = -1;
//        matrix[0][3] = -2;
//        matrix[1][0] = 0;
//        matrix[1][1] = 0;
//        matrix[1][2] = 0;
//        matrix[1][3] = 0;

        // better way to initialize the matrix here
        int[][] matrix = {{-2, 0, -1, -2}, {0, 0, 0, 0}};

        printMatrix(matrix);
        int[][] updatedMatrix = updateDistancesToGates(matrix);
        printMatrix(updatedMatrix);
    }
}
