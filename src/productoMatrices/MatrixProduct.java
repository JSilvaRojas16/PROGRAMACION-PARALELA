package productoMatrices;

public class MatrixProduct {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] resultMatrix = {{0, 0}, {0, 0}};
    private Thread[][] threads;

    public MatrixProduct(int[][] matrix1, int[][] matrix2){
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.threads = new Thread[2][2];
    }

    public void multiplicarMatrices(){
        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                threads[i][j] = new Thread(new ProductTask(i,j));
                threads[i][j].start();
            }
        }
    }

    public int[][] getResultMatrix(){
        return  resultMatrix;
    }

    private class  ProductTask implements Runnable {
        private int row;
        private int col;

        public ProductTask(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public  void run(){
            int sum = 0;
            for (int k = 0; k < 2; k++){
                sum = sum + matrix1[row][k] * matrix2[k][col];
            }
            resultMatrix[row][col] = sum;

            System.out.println("result [" + row + "][" + col + "]: " + resultMatrix[row][col]);
        }
    }

}
