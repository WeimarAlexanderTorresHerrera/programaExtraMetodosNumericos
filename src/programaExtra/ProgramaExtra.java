package programaExtra;

import java.util.Scanner;

public class ProgramaExtra {

    public static void main(String[] args) {
        int m;
        do {
            Scanner consola = new Scanner(System.in);
            System.out.println("Introduzca numero de incognitas");
            int n = consola.nextInt();
            if (n == 2) {
                System.out.println("Introduzca un numero mayor de incognitas");
                n = consola.nextInt();
            }  double[][] C = new double[n][n];
            double[] D = new double[n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    System.out.println("Introduzca el coeficiente [" + x + "," + y + "]");
                    C[x][y] = consola.nextDouble();
                }
            }
            for (int y = 0; y < n; y++) {
                System.out.println("Introduzca la matriz de resultados b[" + y + "]");
                D[y] = consola.nextDouble();
            }
            EvalMatriz solver = new EvalMatriz(C, D);
            double[] x = solver.solucion();
            System.out.println("Para salir presione 1");
            System.out.println("Para continuar presione cualquier numero");
            m = consola.nextInt();
        }
        while (m != 1);
    }

}