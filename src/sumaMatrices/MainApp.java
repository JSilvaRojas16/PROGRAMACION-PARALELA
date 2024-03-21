package sumaMatrices;

public class MainApp {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2}, {0, 2}};
        int[][] matrix2 = {{5, 8}, {2, 5}};

        MatrixAdder matrixAdder = new MatrixAdder(matrix1, matrix2);

        matrixAdder.sumMatrices();


        int[][] resultMatrix = matrixAdder.getResult();

        System.out.println("Resultado final: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-------------");
    }
}

