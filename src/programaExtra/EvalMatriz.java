package programaExtra;

public class EvalMatriz {

    private double[][] C;
    private double[] D;

    public EvalMatriz(double[][] C, double[] D) {
        if (C == null || D == null)
            throw new NullPointerException();
        if (C.length != D.length)
            throw new IllegalArgumentException();
        this.C = C;
        this.D = D;
    }

    public double[] solucion() {
        double sumdat = 0.0D;
        int exc = 0;
        int a = 10000;
        double[] fin = new double[this.C.length];
        double[] result = new double[this.C.length];
        double[][] G = new double[this.C.length][this.C.length + 1];
        for (int x = 0; x < this.C.length; x++) {
            for (int y = 0; y < this.C.length; y++) {
                G[x][y] = this.C[x][y];
            }
        }
        for (int i = 0; i < this.C.length; i++) {
            G[i][this.C.length] = this.D[i];
        }
          for (int p = 0; p < this.C.length; p++) {
                for (int j = 0; j < this.C.length; j++) {
                    for (int k = 0; k < this.C.length; k++) {
                        sumdat += Math.abs(this.C[j][k]);
                    }
                    double dat1 = Math.abs(this.C[j][p]);
                    result[j] = Math.abs(sumdat - 2.0D * dat1);
                    sumdat = 0.0D;
                }
               double resultado = result[0];
                for (int i = 0; i < result.length; i++) {
                    if (result[i] < resultado)
                    {
                        resultado = result[i];
                    }
                }
                for (int l = 0; l < result.length; l++) {
                    if (result[l] == resultado) {
                        exc = l;
                        System.out.println("La fila " + (p + 1) + " es cambiada por la fila " + (l + 1)); break;
                    }
                }
                a = exc;
                fin[p] = exc;
                for (int i = 0; i < this.C.length; i++) {
                    this.C[a][i] = 10000.0D;
                }
            }
          return fin;
    }

}
