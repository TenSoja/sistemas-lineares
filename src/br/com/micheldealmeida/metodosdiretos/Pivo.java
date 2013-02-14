/**
 * Pivoteamento é a técnica de rearranjar a uma matriz de tal modo que os elementos mais desejáveis sejam colocados ao longo da diagonal.
 * 
 * @author Michel de Almeida Silva
 * @email michel@uft.edu.br
 */
package br.com.micheldealmeida.metodosdiretos;

public class Pivo {

	private double temp;
	private double tempLinha[];
	private int i, j = 0, m, qtdLinhas;

	public void pivoParcial(double a[][], double b[]) {
		qtdLinhas = a.length;

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

}
