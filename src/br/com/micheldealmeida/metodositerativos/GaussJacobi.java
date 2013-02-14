package br.com.micheldealmeida.metodositerativos;

import java.util.Arrays;

public class GaussJacobi {

	public static final int QTD_MAX_ITERACOES = 100;
	private double[][] A;

	public GaussJacobi(double[][] a) {
		A = a;
	}

	public void resolve() {
		double erro = 1e-15;
		int iteracoes = 0;
		int tamanho = A.length;

		double[] aproximacao = new double[tamanho]; 
		double[] anterior = new double[tamanho]; 
		Arrays.fill(aproximacao, 0);
		Arrays.fill(anterior, 0);
		System.out.println("Iterações:");
		while (true) {
			for (int i = 0; i < tamanho; i++) {
				double soma = A[i][tamanho - 1]; // b_n

				for (int j = 0; j < tamanho; j++)
					if (j != i)
						soma -= A[i][j] * anterior[j];

				aproximacao[i] = 1 / A[i][i] * soma;
			}

			System.out.print("X[" + iteracoes + "] = {");
			for (int i = 0; i < tamanho; i++)
				System.out.printf(aproximacao[i] + " ");
			System.out.println("}");

			iteracoes++;
			if (iteracoes == 1)
				continue;

			boolean pare = true;
			for (int i = 0; i < tamanho && pare; i++)
				if (Math.abs(aproximacao[i] - anterior[i]) > erro)
					pare = false;

			if (pare || iteracoes == QTD_MAX_ITERACOES)
				break;
			anterior = (double[]) aproximacao.clone();
		}
	}

}
