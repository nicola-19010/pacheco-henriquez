public class SensorSismologico {
    public static void main(String[] args) {
        double gradoSismoSinTruncar = ( (Math.random() * ( 9.5 - 0.5 )) + 0.5);
        double gradosSismosTruncados = Math.round(gradoSismoSinTruncar);
        System.out.println(gradosSismosTruncados);

    }
    private static double [][] rellenarMatriz(int dias) {
        double [][] matrizRellena = new double[dias][24];
        double gradoSismoSinTruncar;
        double gradosSismosTruncados;

        for (int i = 0; i < matrizRellena.length; i++) {
            for (int j = 0; j < matrizRellena[i].length; j++) {
                gradoSismoSinTruncar = ( (Math.random() * ( 9.5 - 0.5 )) + 0.5);
                gradosSismosTruncados = Math.round(gradoSismoSinTruncar);
            }
        }
        return null;
    }
}
