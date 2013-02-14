/**
 * Fatoração de LU (Lower-Upper decomposition).
 * 
 * @author Michel de Almeida Silva
 * @email michel@uft.edu.br
 */
package br.com.micheldealmeida.metodosdiretos;

public class LU {

	private int i, j, k, qtdLinhas, qtdColunas;

	public double[] resolve(double a[][], double b[]) {

		qtdLinhas = a.length;
		qtdColunas = a[0].length;

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
			
			Pivo pivo = new Pivo();
			pivo.pivoParcial(a, b);

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

}
