package br.com.fsma.matriz.negocio;

import br.com.fsma.matriz.negocio.especificacao.Matriz3x3;

public class UnidadeMatriz implements Matriz3x3 {
	
	private static int linha = 3;
	private static int coluna = 3;
	private Double[][] matriz;
	
	public UnidadeMatriz() {
		this.matriz = new Double[linha][coluna];
		matriz[0][0] = 1.0;
		matriz[0][1] = 0.0;
		matriz[0][2] = 0.0;
		matriz[1][0] = 0.0;
		matriz[1][1] = 1.0;
		matriz[1][2] = 0.0;
		matriz[2][0] = 0.0;
		matriz[2][1] = 0.0;
		matriz[2][2] = 1.0;
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
		Matriz novaMatrizDaMultiplicacao = new Matriz();
		double SomaDaMultiplicacao = 0;
		for (int i = 0; i < linha; i++) {
			for(int j = 0; j < coluna; j++) {
				for(int k = 0; k < coluna; k++) {
					SomaDaMultiplicacao += this.matriz[i][k] * matrizParametro.getValor(k, j);					
				}
				novaMatrizDaMultiplicacao.preencherValorMatriz(i, j, SomaDaMultiplicacao);
				SomaDaMultiplicacao = 0;
			}
		}
		return novaMatrizDaMultiplicacao;
	}

	@Override
	public Matriz3x3 multiplica(double escalar) {
		Matriz novaMatrizDaMultiplicacaoEscalar = new Matriz();
		for (int i = 0; i < linha; i++) {
			for(int j = 0; j < coluna; j++) {
				novaMatrizDaMultiplicacaoEscalar.preencherValorMatriz(i, j, this.matriz[i][j] * escalar);
			}
		}
		return novaMatrizDaMultiplicacaoEscalar;
	}

	@Override
	public Matriz3x3 inversa() {
		return new UnidadeMatriz();
	}

	@Override
	public Matriz3x3 transposta() {
		return new UnidadeMatriz();
	}

	@Override
	public boolean isEscalar() {
		double primeiraPosicao = this.matriz[0][0];
		boolean retornoEscalar = false;
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				if(i == j && this.matriz[i][j] == primeiraPosicao) {
					retornoEscalar = true;
				}
				else if (i != j && this.matriz[i][j] == 0) {
					retornoEscalar = true;
				}
				else {
					return false;
				}
			}
		}
		return retornoEscalar;
	}

	@Override
	public boolean isDiagonal() {
		boolean retornoEscalar = false;
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				if (i != j && this.matriz[i][j] == 0) {
					retornoEscalar = true;
				}				
			}
		}
		return retornoEscalar;
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
		double diagPrin1 = matriz[0][0] * matriz[1][1] * matriz[2][2];
	    double diagPrin2 = matriz[0][1] * matriz[1][2] * matriz[2][0];
	    double diagPrin3 = matriz[0][2] * matriz[1][0] * matriz[2][1];
	    double diagSec1 = matriz[2][0] * matriz[1][1] * matriz[0][2];
	    double diagSec2 = matriz[2][1] * matriz[1][2] * matriz[0][0];
	    double diagSec3 = matriz[2][2] * matriz[1][0] * matriz[0][1];

		return -(diagSec1 + diagSec2 + diagSec3) + (diagPrin1 + diagPrin2 + diagPrin3);
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
