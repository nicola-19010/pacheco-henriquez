import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;

public class SensorSismologico {
    private static int pedirDias() {
        int dias;

        while(true){
            try {
                dias = validarIngreso();
            }catch(InputMismatchException e) {
                continue;
            }

            if(dias > 1 && dias < 32) {
                return dias;
            }
        }
    }

    private static void MostrarMenu() {
        System.out.println("------MENU------");
        System.out.println("1. ¿Qué intensidad, qué día y a qué hora ocurrió el sismo?");
        System.out.println("2. ¿Cuántos días en total se registraron sismos >= 5.5 grados?");
        System.out.println("3. ¿Hay alerta de escalada sísmica?");
        System.out.println("4. ¿Hay alerta de enjambre sísmico?");
        int opcionMenu = validarIngreso();
    }

    private static void opcionesMenu(int opcion,){
        switch (opcion){
            case 1:
            case 2:
            case 3:
                hayAlertaDeEscalada();
        }
    }

    public static int [] hayAlertaDeEscalada(double [][] matrizLlena, int dias) {
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
    private static int validarIngreso() {
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
}
