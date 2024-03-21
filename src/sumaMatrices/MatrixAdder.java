package sumaMatrices;

public class MatrixAdder {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] resultMatrix = {{0, 0}, {0, 0}};
    private Thread[][] threads;

    public MatrixAdder(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.threads = new Thread[2][2];
    }

    public void sumMatrices() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                threads[i][j] = new Thread(new AdderTask(i, j));
                threads[i][j].start();
            }
        }
    }

    public int[][] getResult() {
        return resultMatrix;
    }

    private class AdderTask implements Runnable {
        private int row;
        private int col;

        public AdderTask(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void run() {
            resultMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
            System.out.println("result [" + row + "][" + col + "]: " + resultMatrix[row][col]);
        }
    }
}
