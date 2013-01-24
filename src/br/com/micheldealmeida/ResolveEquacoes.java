/**
 * Classe para resolução de equações lineares contendo os métodos: Eliminação de Gauss, Fatoração LU e Fatoração de Cholesky
 * 
 * @author Michel de Almeida Silva
 * @email michel@uft.edu.br
 */
package br.com.micheldealmeida;


public class ResolveEquacoes {

	private static void pivoParcial(double a[][], double b[]) {
		double temp;
		double tempLinha[];
		int i, j = 0, m;
		int qtdLinhas = a.length;

		// Determinar o elemento pivô para a coluna atual e reorganizar as
		// linhas

		m = j;
		for (i = j + 1; i < qtdLinhas; ++i) {
			if (Math.abs(a[i][j]) > Math.abs(a[m][j])) {
				m = i;
			}
		}
		if (m != j) {
			tempLinha = a[j];
			a[j] = a[m];
			a[m] = tempLinha;
			temp = b[j];
			b[j] = b[m];
			b[m] = temp;
		}
		return;
	}

	public static double[] fatoracaoLU(double a[][], double b[]) {
		int i, j, k;

		int qtdLinhas = a.length;
		int qtdColunas = a[0].length;

		// A matriz a[][] é sobrescrita em uma que contém as matrizes diagonais
		// inferioras e superioras.

		for (j = 0; j < qtdColunas; ++j) {

			// Elementos diagonais superiores.

			for (i = 0; i <= j; ++i) {
				for (k = 0; k < i; ++k) {
					a[i][j] -= a[i][k] * a[k][j];
				}
			}

			// Elementos diagonais inferiores.

			for (i = j + 1; i < qtdLinhas; ++i) {
				for (k = 0; k < j; ++k) {
					a[i][j] -= a[i][k] * a[k][j];
				}
			}

			// Determinar o elemento pivô para a coluna atual e reorganizar as
			// linhas.

			pivoParcial(a, b);

			// Divide os elementos diagonais inferiores pelo valor diagonal.

			for (i = j + 1; i < qtdLinhas; ++i) {
				a[i][j] /= a[j][j];
			}

		} // fim do carregamento da matriz LU.

		// Usa a substituição forward (para frente) and backward (para trás)
		// para resolver as incógnitas.
		// Primeiro a substituição forward.

		for (i = 1; i < qtdLinhas; ++i) {
			for (j = 0; j < i; ++j) {
				b[i] -= a[i][j] * b[j];
			}
		}

		// E agora a substituição backward

		b[qtdLinhas - 1] = b[qtdLinhas - 1] / a[qtdLinhas - 1][qtdLinhas - 1];
		for (i = qtdLinhas - 2; i >= 0; --i) {
			for (j = i + 1; j < qtdColunas; ++j) {
				b[i] -= a[i][j] * b[j];
			}
			b[i] /= a[i][i];
		}

		return b;
	}

	public static double[] gauss(double a[][], double b[]) {
		int qtdLinhas = a.length;
		int qtdColunas = a[0].length;

		// Determinar o elemento pivô para a coluna atual e reorganizar as
		// linhas

		pivoParcial(a, b);

		// Transforma a matriz a[][] em uma matriz diagonal superior pela
		// subtração de um multiplo da linha abaixo dela. Faz o mesmo com a
		// matriz b[][].

		for (int i = 0; i < qtdLinhas; ++i) {
			b[i] /= a[i][i];
			for (int j = qtdColunas - 1; j >= i; --j) {
				a[i][j] /= a[i][i];
			}

			for (int k = i + 1; k < qtdLinhas; ++k) {
				b[k] -= a[k][i] * b[i];
				for (int m = i + 1; m < qtdColunas; ++m) {
					a[k][m] -= a[k][i] * a[i][m];
				}
			}
		}

		// Resolve a matriz b[] com substituição backward. Os elementos da
		// matriz a[][] foram previamente normalizados para 1.

		for (int i = qtdLinhas - 2; i >= 0; --i) {
			for (int j = i + 1; j < qtdLinhas; ++j) {
				b[i] -= a[i][j] * b[j];
			}
		}

		return b;
	}

	public static double[][] cholesky(double[][] a) {
		int m = a.length;
		double[][] g = new double[m][m]; // inicializa com 0

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