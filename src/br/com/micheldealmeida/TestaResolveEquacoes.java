/**
 * Classe para testes de resolução de equações lineares contendo os métodos: Eliminação de Gauss, Fatoração LU e Fatoração de Cholesky
 * 
 * @author Michel de Almeida Silva
 * @email michel@uft.edu.br
 * 
 * TODO: 
 * Implementar versão webapp;
 * Fazer deploy no google app.
 * 
 */
package br.com.micheldealmeida;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TestaResolveEquacoes {

	public static void imprimirMatriz(double a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%8.5f ", a[i][j]);
			}
			System.out.println();
		}
	}

	public static void imprimirVetor(double b[]) {

		for (int i = 0; i < b.length; i++) {

			System.out.printf("%8.5f ", b[i]);

			System.out.println();
		}
	}

	public static void imprimirResultados(double x[]) {
		System.out.println("Incógnitas:" + "\r\n");
		for (int i = 0; i < x.length; ++i) {

			System.out.println("x[" + i + "] = " + x[i]);

		}
		System.out.println();
	}

	public static void main(String args[]) {
		
		/*
		 * Conjunto de entrada formado por matrizes.
		 */
		
		
		//Matriz simétrica positiva (especial para uso com o método Cholesky).
		double a[][] = 
			{
				 {  5.28736, -0.60384, -0.79092, -0.67437, -0.01234, 0.60336, -0.39065, -0.43007, -0.24465, -0.10010 },
				 { -0.60384,  4.60945,  0.08126,  0.37286,  0.05493,  0.00043,  0.05923, -0.00401,  0.12517, -0.38246 },
				 { -0.79092,  0.08126,  4.82266,  0.74562, -0.48683, -0.35628,  0.14533, -0.83524, -0.28373, -0.14948 },
				 { -0.67437,  0.37286,  0.74562,  5.98566, -0.15453,  0.40161,  0.02549, -0.59519, -0.59956, -0.48716 },
				 { -0.01234,  0.05493, -0.48683, -0.15453,  5.77743, -0.29989, -0.73218,  0.55421,  0.07070,  0.06200 },
				 {  0.60336,  0.00043, -0.35628,  0.40161, -0.29989,  5.70460,  0.07734, -0.10477,  0.58029, -0.05681 },
				 { -0.39065,  0.05923,  0.14533,  0.02549, -0.73218,  0.07734,  4.38715, -0.81542,  0.11179, -0.64917 },
				 { -0.43007, -0.00401, -0.83524, -0.59519,  0.55421, -0.10477, -0.81542,  4.34963,  0.26040,  0.66148 },
				 { -0.24465,  0.12517, -0.28373, -0.59956,  0.07070,  0.58029,  0.11179,  0.26040,  5.89643, -0.03933 },
				 { -0.10010, -0.38246, -0.14948, -0.48716,  0.06200, -0.05681, -0.64917,  0.66148, -0.03933,  4.24838 }
				 
			};
		//Matriz solução
		double b[] = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		
		int escolha = 0;
		while (escolha != 5) {
			System.out
					.println("Por favor, escolha uma das funções abaixo de acordo com o número correspondente:");
			System.out.println("1: Eliminação de Gauss");
			System.out.println("2: Eliminação de Gauss-Jordan");
			System.out.println("3: Fatoração LU");
			System.out.println("4: Fatoração de Cholesky");
			System.out.println("5: Sair");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				escolha = Integer.parseInt(reader.readLine());
				if (escolha == 1) {

					System.out.println("Eliminação de Gauss ");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					imprimirMatriz(a);
					System.out.println();
					System.out.println("Conjunto Solução" + "\r\n");
					imprimirVetor(b);
					System.out.println();
					double[] X = ResolveEquacoes.gauss(a, b);
					imprimirResultados(X);
					System.out.println();
					System.out.println();

				}
				if (escolha == 2) {

					System.out.println("Eliminação de Gauss-Jordan ");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					imprimirMatriz(a);
					System.out.println();
					System.out.println("Conjunto Solução" + "\r\n");
					imprimirVetor(b);
					System.out.println();
					double[] X = ResolveEquacoes.gaussJordan(a, b);
					imprimirResultados(X);
					System.out.println();
					System.out.println();

				}
				if (escolha == 3) {
					System.out.println("Fatoração LU");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					imprimirMatriz(a);
					System.out.println();
					System.out.println("Conjunto Solução" + "\r\n");
					imprimirVetor(b);
					System.out.println();
					double[] X = ResolveEquacoes.fatoracaoLU(a, b);
					imprimirResultados(X);
					System.out.println();
					System.out.println();

				}
				if (escolha == 4) {
					// Cholesky
					System.out.println("Fatoração de Cholesky");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					imprimirMatriz(a);
					System.out.println();
					double[][] G = ResolveEquacoes.cholesky(a);
					System.out.println("Matriz G (Fator Cholesky)" + "\r\n");
					imprimirMatriz(G);
					System.out.println();
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Voce não digitou um número");
				System.out.println("Saindo do Programa");
				return;
			}

		}

	}
}
