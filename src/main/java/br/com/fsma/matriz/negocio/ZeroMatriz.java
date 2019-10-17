package br.com.fsma.matriz.negocio;

import br.com.fsma.matriz.negocio.especificacao.Matriz3x3;

public class ZeroMatriz implements Matriz3x3 {
	
	private static int linha = 3;
	private static int coluna = 3;
	private Double[][] matriz;
	
	public ZeroMatriz() {
		this.matriz = new Double[linha][coluna];
		for( int i = 0; i < linha; i++) {
			for ( int j = 0; j < coluna; j++) {
				matriz[i][j] = 0.0;
			}
		}
	}
	
	@Override
	public Matriz3x3 adiciona(Matriz3x3 matrizParametro) {
		Matriz novaMatrizDaSoma = new Matriz();
		for (int i = 0; i < linha; i++) {
			for(int j = 0; j < coluna; j++) {
				novaMatrizDaSoma.preencherValorMatriz(i, j, this.matriz[i][j] + matrizParametro.getValor(i, j));
			}
		}
		return novaMatrizDaSoma;
	}

	@Override
	public Matriz3x3 subtrai(Matriz3x3 matrizParametro) {
		Matriz novaMatrizDaSubtracao = new Matriz();
		for (int i = 0; i < linha; i++) {
			for(int j = 0; j < coluna; j++) {
				novaMatrizDaSubtracao.preencherValorMatriz(i, j, this.matriz[i][j] - matrizParametro.getValor(i, j));
			}
		}
		return novaMatrizDaSubtracao;
	}

	@Override
	public Matriz3x3 multiplica(Matriz3x3 matrizParametro) {
		return new ZeroMatriz();
	}

	@Override
	public Matriz3x3 multiplica(double escalar) {
		return new ZeroMatriz();
	}

	@Override
	public Matriz3x3 inversa() {
		return new ZeroMatriz();
	}

	@Override
	public Matriz3x3 transposta() {
		return new ZeroMatriz();
	}

	@Override
	public boolean isEscalar() {
		return true;
	}

	@Override
	public boolean isDiagonal() {
		return true;
	}

	@Override
	public boolean isIgual(Matriz3x3 matrizParametro) {
		for (int i = 0; i < linha; i++) {
			for(int j = 0; j < coluna; j++) {
				if(this.matriz[i][j] != matrizParametro.getValor(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public double getDeterminante() {
		return 0;
	}

	@Override
	public double getValor(int linha, int coluna) {
		return this.matriz[linha][coluna];
	}

	@Override
	public void imprime() {
		System.out.println("\t\tj[0] \tj[1] \tj[2]\n");
		for (int i = 0; i < linha; i++) {
				System.out.print("i[" + i + "]   |");
			for (int j = 0; j < coluna; j++) {
				   System.out.print("\t" + matriz[i][j]);
			}
			System.out.println("\n----------------------------------------\n");
		}
	}

}
