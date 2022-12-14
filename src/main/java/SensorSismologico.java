import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SensorSismologico {
    public static void main(String[] args) {


        imprimirMatriz(rellenarMatriz(10));
    }

    private static void imprimirMatriz(double[][] matriz){
        /*for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j] + " ");
            }
        } */

        for (int i = 0; i < matriz.length; i++) {
                System.out.println(Arrays.toString(matriz[i]));
        }

    }

    private static int validarIngreso( ){
        Scanner teclado = new Scanner(System.in);
        int entrada;
        do {
            try {
                entrada = teclado.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Ingrese una opción válida:");
                teclado.nextLine();
            }
        } while (true);
        return entrada;
    }

    public static int ValidarDiasValidos(int entrada) {
        if (entrada < 1 || entrada > 365){
            return validarIngreso();
        }else {
            System.out.println("Error, ha ingresado una cantidad de dias invalida");
            return entrada;
        }
    }

    private static double [][] rellenarMatriz(int dias) {
        double [][] matrizRellena = new double[dias][24];
        double gradoSismoSinTruncar;
        double gradosSismosTruncados;

        for (int i = 0; i < matrizRellena.length; i++) {
            for (int j = 0; j < matrizRellena[i].length; j++) {
                gradoSismoSinTruncar = ( (Math.random() * ( 9.5 - 0.5 )) + 0.5);

                //para truncar
                BigDecimal gradosSismo = new BigDecimal(gradoSismoSinTruncar);
                BigDecimal rounded = gradosSismo.setScale(1, RoundingMode.FLOOR);
                gradosSismosTruncados = rounded.doubleValue();

                //rellenar la matriz
                matrizRellena[i][j] = gradosSismosTruncados;
            }
        }
        return matrizRellena;
    }

    private void BuscarSismoMasIntenso(double matrizRellena[][]){
        for (int i = 0; i < matrizRellena.length; i++) {

            double mayor = matrizRellena[0][0];
            for (int j = 0; j < matrizRellena[i].length; j++) {
                double numeroActual = matrizRellena[i][j];
                if (numeroActual > mayor)
                    mayor = numeroActual;
            }

            System.out.println("El simo mas intenso ocurrio el: ");
            //System.out.println("Dia : " + i);
            //System.out.println("Hora: " + j);
            System.out.println("Intensidad: " + mayor);
        }
    }

    private static void BuscarSismosMayorOIgualesA55(double[][] MatrizRellena){
        int contador = 0;
        for (int  i = 0; i < MatrizRellena.length; i++){
            for (int j = 0; j < MatrizRellena[i].length; j++){
                if (MatrizRellena[i][j] >= 5.5){
                    contador ++;
                }
            }
        }
        System.out.println("La cantidad de sismos mayores a 5.5  es: " + contador);

    }
}
