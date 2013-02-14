package br.com.micheldealmeida.metodositerativos.teste;


public class TestaMetodosIterativos {

	public static void imprimirMatriz(double a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%8.5f ", a[i][j]);
			}
			System.out.println();
		}
	}


}
