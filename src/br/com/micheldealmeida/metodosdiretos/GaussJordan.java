package br.com.micheldealmeida.metodosdiretos;

public class GaussJordan {
	private int i, j, k, m, qtdLinhas, qtdColunas;
	private double temp;

	public  double[] resolve(double a[][], double b[]) {
		
		 qtdLinhas = a.length;
		 qtdColunas = a[0].length;
		 int indice[][] = new int[qtdLinhas][2];

		// Determinar o elemento pivô para a coluna atual e reorganizar as
		// linhas.

		Pivo pivo = new Pivo();
		pivo.pivoParcial(a, b);

		// Executa a eliminação linha por linha. Primeiro dividindo a linha
		// atual e o elemento b por a[i][i].

		for (i = 0; i < qtdLinhas; ++i) {
			temp = a[i][i];
			for (j = 0; j < qtdColunas; ++j) {
				a[i][j] /= temp;
			}
			b[i] /= temp;
			a[i][i] = 1.0 / temp;

			// Reduz (para a matriz identidade) outras lihas pela subtração de um multiplo da linha atual.
			// Não reduz a linha atual. Como cada coluna da matriz a[][] é
			// reduzida os elementos são substituidos pela matriz inversa de
			// a[][].

			for (k = 0; k < qtdLinhas; ++k) {
				if (k != i) {
					temp = a[k][i];
					for (j = 0; j < qtdColunas; ++j) {
						a[k][j] -= temp * a[i][j];
					}
					b[k] -= temp * b[i];
					a[k][i] = -temp * a[i][i];
				}
			}
		}

		// Reordena a matriz inversa a[][]. As colunas são trocadas na ordem
		// inversa que as linhas foram durante o pivoteamento.

		for (j = qtdColunas - 1; j >= 0; --j) {
			k = indice[j][0];
			m = indice[j][1];
			if (k != m) {
				for (i = 0; i < qtdLinhas; ++i) {
					temp = a[i][m];
					a[i][m] = a[i][k];
					a[i][k] = temp;
				}
			}
		}

		return b;
	}
}
