package q4_PauloFilho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiplicacaoMatrizes {
    public static void main(String[] args) {
        int[][] matrizA;
        int[][] matrizB;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader("matriz.txt"));

            // Lê as dimensões da primeira matriz
            String[] dimensoesMatrizA = leitor.readLine().split(" ");
            int linhasA = Integer.parseInt(dimensoesMatrizA[0]);
            int colunasA = Integer.parseInt(dimensoesMatrizA[1]);
            matrizA = new int[linhasA][colunasA];

            // Lê a primeira matriz
            for (int i = 0; i < linhasA; i++) {
                String[] valores = leitor.readLine().split(" ");
                for (int j = 0; j < colunasA; j++) {
                    matrizA[i][j] = Integer.parseInt(valores[j]);
                }
            }

            // Lê as dimensões da segunda matriz
            String[] dimensoesMatrizB = leitor.readLine().split(" ");
            int linhasB = Integer.parseInt(dimensoesMatrizB[0]);
            int colunasB = Integer.parseInt(dimensoesMatrizB[1]);
            matrizB = new int[linhasB][colunasB];

            // Lê a segunda matriz
            for (int i = 0; i < linhasB; i++) {
                String[] valores = leitor.readLine().split(" ");
                for (int j = 0; j < colunasB; j++) {
                    matrizB[i][j] = Integer.parseInt(valores[j]);
                }
            }

            leitor.close();

            if (colunasA != linhasB) {
                System.out.println("As matrizes não podem ser multiplicadas devido às dimensões.");
            } else {
                int[][] resultado = multiplicarMatrizes(matrizA, matrizB);

                System.out.println("Resultado da multiplicação das matrizes:");
                for (int i = 0; i < linhasA; i++) {
                    for (int j = 0; j < colunasB; j++) {
                        System.out.print(resultado[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] multiplicarMatrizes(int[][] matrizA, int[][] matrizB) {
        int linhasA = matrizA.length;
        int colunasA = matrizA[0].length;
        int colunasB = matrizB[0].length;
        int[][] resultado = new int[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < colunasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }
}

