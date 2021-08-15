package tree.matrix;

// https://www.youtube.com/watch?v=2H_2UGsRmLE&t=19s - part 2

import java.util.*;

public class BFSMatrix {
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

    // loop through whole matrix and get the positions of the gates (-2)

    // loop: for each gate
        // start a bfs, filling the distance from the origin in steps if it is smaller than current value or different from zero

    // time complexity:
    // O(n*m) for the gates position,
    // Then potentially O(n*m) for each gate loop O(n2m2)
    // result: O(n2m2)
    // space complexity: depends on implementation details, but possibly O(n*m) (queue size)

    static class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Gate extends Cell {
        public Gate(int x, int y) {
            super(x, y);
        }
    }

    static class QueueElement extends Cell {
        int depth;

        public QueueElement(int x, int y, int depth) {
            super(x, y);
            this.depth = depth;
        }
    }

    public static void addNeighborsToQueue(Cell cell, Queue<QueueElement> queue, int depth) {
        queue.add(new QueueElement(cell.x - 1, cell.y, depth));
        queue.add(new QueueElement(cell.x + 1, cell.y, depth));
        queue.add(new QueueElement(cell.x, cell.y - 1, depth));
        queue.add(new QueueElement(cell.x, cell.y + 1, depth));
    }

    public static boolean isValid(Cell cell, int[][] matrix) {
        int matrixXDimension = matrix.length;
        int matrixYDimension = matrix[0].length;

        return ((cell.x >= 0) && (cell.x < matrixXDimension) && (cell.y >= 0) && (cell.y < matrixYDimension));
    }

    public static boolean isWall(Cell cell, int[][] matrix) {
        return matrix[cell.x][cell.y] == -1;
    }

    public static boolean isGate(Cell cell, int[][] matrix) {
        return matrix[cell.x][cell.y] == -2;
    }

    public static boolean wasVisited(Cell cell, boolean[][] visitedMatrix) {
        return visitedMatrix[cell.x][cell.y];
    }

    // in-place updates the values of the received matrix
    public static void updateDistancesToGate(int[][] matrix, Gate gate, Queue<QueueElement> queue, boolean[][] visited) {

        // add gate neighbors to queue with depth 1
        addNeighborsToQueue(gate, queue, 1);

        // loop while queue has elements to process
        while (!queue.isEmpty()) {
            // get a cell
            QueueElement currentCell = queue.poll();
//            System.out.println("iterating on cell " + currentCell.toString());

            // if cell is not a valid position is a wall or is a gate or was already visited, move to next cell
            if (!isValid(currentCell, matrix) || isWall(currentCell, matrix) || isGate(currentCell, matrix)  || wasVisited(currentCell, visited)) {
//                System.out.println("skipping " + currentCell.toString());
                continue;
            }

            int currentCellValue = matrix[currentCell.x][currentCell.y];

            // if depth is larger than value of this cell, I know this gate went "too far" and I can terminate the process for this gate
            if ((currentCellValue != 0) && (currentCell.depth > currentCellValue)) {
                break;
            }

            // update matrix value of this cell with the correct depth
            if (currentCellValue == 0 || currentCell.depth < currentCellValue) {
                matrix[currentCell.x][currentCell.y] = currentCell.depth;
            }

            // put all cell neighbors in the queue and mark this cell as visited
            addNeighborsToQueue(currentCell, queue, currentCell.depth + 1);
            visited[currentCell.x][currentCell.y] = true;
        }
    }

    public static List<Gate> getGates(int[][] matrix) {
        List<Gate> gateList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -2) {
                    gateList.add(new Gate(i, j));
                }
            }
        }

        return gateList;
    }

    public static int[][] updateDistancesToGates(int[][] matrix) {
        // get all existing gates
        List<Gate> gates = getGates(matrix);

        // clone matrix to return a new matrix as a result
        int[][] newMatrix = matrix.clone();

        // for each gate in matrix
        for (Gate gate : gates) {
             // initialize queue to perform bfs and matrix to store visited cells
             Queue<QueueElement> queue = new ArrayDeque<>();
             boolean[][] visited = new boolean[matrix.length][matrix[0].length];

             // perform bfs starting on that gate, updating distance to that gate on each cell
             updateDistancesToGate(newMatrix, gate, queue, visited);
         }

         return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        // ex: input:
        // [-2 0 -1 -2]
        // [ 0 0 0  0]
        int[][] matrix = new int[2][4];
        matrix[0][0] = -2;
        matrix[0][1] = 0;
        matrix[0][2] = -1;
        matrix[0][3] = -2;
        matrix[1][0] = 0;
        matrix[1][1] = 0;
        matrix[1][2] = 0;
        matrix[1][3] = 0;

        printMatrix(matrix);
        System.out.println(getGates(matrix)); // 0,0 and 0,3

        System.out.println("Testing main function");
        int[][] updatedMatrix = updateDistancesToGates(matrix);
        printMatrix(updatedMatrix);

        System.out.println("Testing a new matrix");
        // [ 0 0 -1 -2]
        // [-1 0  0  0]
        int[][] matrix2 = new int[2][4];
        matrix2[0][0] = 0;
        matrix2[0][1] = 0;
        matrix2[0][2] = -1;
        matrix2[0][3] = -2;
        matrix2[1][0] = -1;
        matrix2[1][1] = 0;
        matrix2[1][2] = 0;
        matrix2[1][3] = 0;
        printMatrix(matrix2);
        int[][] updatedMatrix2 = updateDistancesToGates(matrix2);
        printMatrix(updatedMatrix2);

        // possible improvement in the algorithm:
        // get all gates first, then do a breadth-first search for all gates at once (n = 1 for all gates, then n = 2, etc)
    }
}
