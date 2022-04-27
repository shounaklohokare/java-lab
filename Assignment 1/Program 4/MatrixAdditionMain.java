import java.io.*;

class MatrixAdditionMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter the row size of both matrix: ");
        int rowSize = Integer.parseInt(br.readLine());

        System.out.print("\nEnter the column size of both matrix: ");
        int colSize = Integer.parseInt(br.readLine());

        int[][] firstMatrix = getMatrix(rowSize, colSize);
        System.out.println("The first matrix is: ");
        displayMatrix(firstMatrix);

        int[][] secondMatrix = getMatrix(rowSize, colSize);
        System.out.println("The second matrix is: ");
        displayMatrix(secondMatrix);

        int[][] sumMatrix = addMatrix(firstMatrix, secondMatrix);
        System.out.println("The sum matrix is: ");
        displayMatrix(sumMatrix);

    }

    private static int[][] getMatrix(int rowSize, int columnSize) throws IOException {

        int[][] out = new int[rowSize][columnSize];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nEnter the values of the matrix: ");
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                out[i][j] = Integer.parseInt(br.readLine());
            }
        }
        return out;
    }

    private static int[][] addMatrix(int[][] firstMatrix, int[][] secondMatrix) {

        int n = firstMatrix.length;
        int m = firstMatrix[0].length;

        int[][] out = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        return out;
    }

    private static void displayMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}