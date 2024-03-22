package operacionesEstadistica;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayDatos numeros = new ArrayDatos();
        numeros.generarDatos();
        numeros.imprimirDatos();

        numeros.start();
        numeros.join();

        Thread calcularVarianzaThread = new Thread(() -> {
            numeros.calcularVarianza();
        });

        calcularVarianzaThread.start();
        calcularVarianzaThread.join();

        System.out.println("Media: " + numeros.media);
        System.out.println("Varianza: " + numeros.varianza);
        System.out.println("Frecuencia Máxima: " + numeros.frecuenciaMaxima);
        System.out.println("Frecuencia Mínima: " + numeros.frecuenciaMinima);
    }
}
