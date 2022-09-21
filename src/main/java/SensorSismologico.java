import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;

public class SensorSismologico {
    public static void main(String[] args) {
        mostrarMenu();

    }

    private static void mostrarMenu() {
        System.out.println("------MENU------");
        System.out.println("1. ¿Qué intensidad, qué día y a qué hora ocurrió el sismo?");
        System.out.println("2. ¿Cuántos días en total se registraron sismos >= 5.5 grados?");
        System.out.println("3. ¿Hay alerta de escalada sísmica?");
        System.out.println("4. ¿Hay alerta de enjambre sísmico?");
        System.out.println("5. Salir del sistema.");
        int opcionMenu = validarIngreso();
        opcionesMenu(validarIngreso());
    }

    private static void opcionesMenu(int opcion){
        switch (opcion){
            case 1:
            case 2:
            case 3:
                hayAlertaDeEscalada();
            case 4:
            case 5:
                salirDelSistema();
        }
    }

    public static int[] hayAlertaDeEscalada(double [][] matrizLlena, int dias) {
        int aux;
        int vecesPorDia = 0;
        int [] matrizMayorCuatro = new int [dias];

        for(int i = 0; i < matrizLlena.length; i++) {
            for(int j = 0; j < matrizLlena[i].length; j++ ) {
                if(matrizLlena[i][j] >= 4.0) {
                    vecesPorDia++;
                }
            }
            matrizMayorCuatro[i] = vecesPorDia;
            System.out.println(matrizMayorCuatro[i]);
            vecesPorDia = 0;
        }

        return matrizMayorCuatro;
    }

    private static void salirDelSistema(){
        System.out.println("¿Está seguro/a que desea salir del sistema?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcionIngresada = validarIngreso();
        opcionesSalirDelSistema(validarIngreso());
    }

    private static void opcionesSalirDelSistema(int opcionIngresada){
        switch (opcionIngresada) {
            case 1 -> System.out.println("Ha salido del sistema.");
            case 2 -> mostrarMenu();
        }
    }
}