package productoMatrices;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2}, {0, 2}};
        int[][] matrix2 = {{5, 8}, {2, 5}};

        MatrixProduct matrixProduct = new MatrixProduct(matrix1,matrix2);

        matrixProduct.multiplicarMatrices();

        int [][] result = matrixProduct.getResultMatrix();

        System.out.println("Resultado final: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-------------");

    }
}
