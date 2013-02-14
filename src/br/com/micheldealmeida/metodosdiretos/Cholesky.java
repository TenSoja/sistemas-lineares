/**
 * Fatoração de Cholesky (Cholesky decomposition).
 * 
 * @author Michel de Almeida Silva
 * @email michel@uft.edu.br
 */
package br.com.micheldealmeida.metodosdiretos;

public class Cholesky {

	private int m;
	private double[][] g;

	public double[][] resolve(double[][] a) {
		m = a.length;
		g = new double[m][m]; // inicializa com 0

		// A matriz sempre deve ser simetrica e positiva essas checagens não vou
		// colocar por estar fazendo uma implementação muito simples, com mais
		// tempo seria bom checar e lançar as exceções.

		// Mesmo processo que a fatoração LU com um passo a mais G.Gt
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < (i + 1); k++) {
				double sum = 0;
				for (int j = 0; j < k; j++) {
					sum += g[i][j] * g[k][j];
				}
				g[i][k] = (i == k) ? Math.sqrt(a[i][i] - sum)
						: (1.0 / g[k][k] * (a[i][k] - sum));
			}
		}
		return g;
	}

}
