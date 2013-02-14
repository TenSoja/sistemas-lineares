package br.com.micheldealmeida.metodositerativos.teste;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import br.com.micheldealmeida.metodositerativos.GaussJacobi;
import br.com.micheldealmeida.metodositerativos.GaussSeidel;

public class TestaMetodosIterativos {

	public static void imprimirMatriz(double a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%8.5f ", a[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		double a[][] = {
				{ 5.28736, -0.60384, -0.79092, -0.67437, -0.01234, 0.60336,
						-0.39065, -0.43007, -0.24465, -0.10010 },
				{ -0.60384, 4.60945, 0.08126, 0.37286, 0.05493, 0.00043,
						0.05923, -0.00401, 0.12517, -0.38246 },
				{ -0.79092, 0.08126, 4.82266, 0.74562, -0.48683, -0.35628,
						0.14533, -0.83524, -0.28373, -0.14948 },
				{ -0.67437, 0.37286, 0.74562, 5.98566, -0.15453, 0.40161,
						0.02549, -0.59519, -0.59956, -0.48716 },
				{ -0.01234, 0.05493, -0.48683, -0.15453, 5.77743, -0.29989,
						-0.73218, 0.55421, 0.07070, 0.06200 },
				{ 0.60336, 0.00043, -0.35628, 0.40161, -0.29989, 5.70460,
						0.07734, -0.10477, 0.58029, -0.05681 },
				{ -0.39065, 0.05923, 0.14533, 0.02549, -0.73218, 0.07734,
						4.38715, -0.81542, 0.11179, -0.64917 },
				{ -0.43007, -0.00401, -0.83524, -0.59519, 0.55421, -0.10477,
						-0.81542, 4.34963, 0.26040, 0.66148 },
				{ -0.24465, 0.12517, -0.28373, -0.59956, 0.07070, 0.58029,
						0.11179, 0.26040, 5.89643, -0.03933 },
				{ -0.10010, -0.38246, -0.14948, -0.48716, 0.06200, -0.05681,
						-0.64917, 0.66148, -0.03933, 4.24838 }

		};

		int escolha = 0;
		while (escolha != 3) {
			System.out
					.println("Métodos iterativos para resolução de sistemas lineares.");
			System.out.println("");
			System.out
					.println("Por favor, escolha uma das funções abaixo de acordo com o número correspondente:");
			System.out.println("1: Gauss-Jacobi");
			System.out.println("2: Gauss-Seidel");
			System.out.println("3: Sair");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				escolha = Integer.parseInt(reader.readLine());
				if (escolha == 1) {

					System.out.println("Método de Gauss-Jacobi ");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					imprimirMatriz(a);
					System.out.println();
					GaussJacobi gaussJacobi = new GaussJacobi(a);
					gaussJacobi.resolve();
					System.out.println();

				}
				if (escolha == 2) {

					System.out.println("Método de Gauss-Seidel ");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					imprimirMatriz(a);
					System.out.println();
					GaussSeidel gaussSeidel = new GaussSeidel(a);
					gaussSeidel.resolve();
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
