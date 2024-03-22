package operacionesEstadistica;

import java.util.Random;

public class ArrayDatos extends Thread{
    int n = 10;
    int[] numeros = new int[n];
    double media;
    double sumaCuadrados;
    double varianza;
    int frecuenciaMaxima;
    int frecuenciaMinima;
    public void generarDatos(){
        Random rand = new Random();
        for(int i=0; i<n; i++){
            numeros[i] = rand.nextInt(50);
        }
    }
    public void imprimirDatos(){
        System.out.print("Datos: [");
        for(int i=0; i<n; i++){
            System.out.print(numeros[i] + " ");
        }
        System.out.println("]");
    }
    public double calcularMediaAritmetica(){
        double sum=0;
        for(int i=0; i<n; i++){
            sum += numeros[i];
        }
        return sum/n;
    }
    public void calcularSumaCuadrados(double media) {
        sumaCuadrados = 0;
        for (int i = 0; i < n; i++) {
            double diferencia = numeros[i] - media;
            sumaCuadrados += diferencia * diferencia;
        }
    }
    public void calcularVarianza() {
        varianza = sumaCuadrados / n;
    }
    public void calcularFrecuenciaMinima() {
        int[] frecuencias = new int[50];

        for (int i = 0; i < n; i++) {
            frecuencias[numeros[i]]++;
        }

        int minFrecuencia = Integer.MAX_VALUE;

        for (int i = 0; i < frecuencias.length; i++) {
            if (frecuencias[i] < minFrecuencia && frecuencias[i] != 0) {
                minFrecuencia = frecuencias[i];
                frecuenciaMinima = i;
            }
        }
    }
    public void calcularFrecuenciaMaxima() {
        int[] frecuencias = new int[50];

        for (int i = 0; i < n; i++) {
            frecuencias[numeros[i]]++;
        }

        int maxFrecuencia = 0;

        for (int i = 0; i < frecuencias.length; i++) {
            if (frecuencias[i] > maxFrecuencia) {
                maxFrecuencia = frecuencias[i];
                frecuenciaMaxima = i;
            }
        }
    }


    @Override
    public void run() {
        media = calcularMediaAritmetica();
        calcularSumaCuadrados(media);
        calcularFrecuenciaMinima();
        calcularFrecuenciaMaxima();
    }
}
