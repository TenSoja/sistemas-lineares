package br.com.micheldealmeida.metodositerativos;

import java.util.Arrays;

public class GaussSeidel {

	public static final int QTD_MAX_ITERACOES = 100;
	private double[][] A;

	public GaussSeidel(double[][] a) {
		A = a;
	}

	public void resolve() {
		double erro = 1e-15;
		int iteracao = 0;
		int tamanho = A.length;

		double[] anterior = new double[tamanho];
		double[] aproximacao = new double[tamanho];

		Arrays.fill(aproximacao, 0);
		System.out.println("Iterações:");
		while (true) {
			for (int i = 0; i < tamanho; i++) {
				double soma = A[i][tamanho - 1]; // b_n

				for (int j = 0; j < tamanho; j++)
					if (j != i)
						soma -= A[i][j] * aproximacao[j];

				aproximacao[i] = 1 / A[i][i] * soma;
			}

			System.out.print("X[" + iteracao + "] = {");
			for (int i = 0; i < tamanho; i++)
				System.out.print(aproximacao[i] + " ");
			System.out.println("}");

			iteracao++;
			if (iteracao == 1)
				continue;

			boolean pare = true;
			for (int i = 0; i < tamanho && pare; i++)
				if (Math.abs(aproximacao[i] - anterior[i]) > erro)
					pare = false;

			if (pare || iteracao == QTD_MAX_ITERACOES)
				break;
			anterior = (double[]) aproximacao.clone();
		}
	}

}
