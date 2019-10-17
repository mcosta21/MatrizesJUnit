package br.com.fsma.matriz.negocio;

import br.com.fsma.matriz.negocio.especificacao.Matriz3x3;

public class Matriz implements Matriz3x3  {
	
	private static int linha = 3;
	private static int coluna = 3;
	private Double[][] matriz;
	
	public Matriz() {
		this.matriz = new Double[linha][coluna];
	}
	
	public Matriz(double v1, double v2, double v3, double v4, double v5, double v6, double v7, double v8, double v9) {
		this.matriz = new Double[linha][coluna];
		matriz[0][0] = v1;
		matriz[0][1] = v2;
		matriz[0][2] = v3;
		matriz[1][0] = v4;
		matriz[1][1] = v5;
		matriz[1][2] = v6;
		matriz[2][0] = v7;
		matriz[2][1] = v8;
		matriz[2][2] = v9;
	}
	
	public Matriz(int nlinha, int ncoluna) {
		this.matriz = new Double[nlinha][ncoluna];
	}
	
	public void preencherValorMatriz(int nlinha, int ncoluna, double valor) {
		this.matriz[nlinha][ncoluna] = valor;
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
	public Matriz3x3 inversa(){
		Matriz comatriz = new Matriz();
		for(int i = 0; i < linha; i++ ){
			for(int j = 0; j < coluna; j++ ){
				comatriz.preencherValorMatriz(i, j, cofactor(i,j));
			}
		}
		return comatriz.transposta().multiplica(1/getDeterminante());
	}

 	public double cofactor(int ii, int jj){
		return Math.pow(-1,ii+jj)*(submatriz(ii,jj));
	}
 	
 	public double submatriz(int ii, int jj){
		Matriz sub = new Matriz(2,2);
		for(int i = 0; i < 2; i++ ){
			for(int j = 0; j < 2; j++ ){
				
				if(ii == 0 && jj == 0) {
					sub.preencherValorMatriz(i, j, this.matriz[ii+1+i][jj+1+j]);
				}
				else if(ii == 0 && jj == 1) {
					if (j == 1)
						sub.preencherValorMatriz(i, j, this.matriz[ii+1+i][jj+1]);
					else {
						sub.preencherValorMatriz(i, j, this.matriz[ii+1+i][jj-1]);
					}
				}
				else if(ii == 0 && jj == 2) {						
					sub.preencherValorMatriz(i, j, this.matriz[ii+1+i][jj-1-j]);
				}
				else if(ii == 1 && jj == 0) {						
					if (i == 0)
						sub.preencherValorMatriz(i, j, this.matriz[ii-1][jj+1+j]);
					else {
						sub.preencherValorMatriz(i, j, this.matriz[ii+i][jj+1+j]);
					}
				}
				else if(ii == 1 && jj == 1) {						
					if (i == 0 && j == 0) {
						sub.preencherValorMatriz(i, j, this.matriz[ii-1][jj-1]);
					}
					else if (i == 0 && j == 1) {
						sub.preencherValorMatriz(i, j, this.matriz[ii-j][jj+j]);
					}
					else if (i == 1 && j == 0) {
						sub.preencherValorMatriz(i, j, this.matriz[ii+i][jj-i]);
					}
					else if (i == 1 && j == 1) {
						sub.preencherValorMatriz(i, j, this.matriz[ii+i][jj+i]);
					}
				}
				else if(ii == 1 && jj == 2) {
					if(i == 0) {
						sub.preencherValorMatriz(i, j, this.matriz[i][j+i]);
					}
					else {
						sub.preencherValorMatriz(i, j, this.matriz[i+1][j]);
					}
				}
				else if(ii == 2 && jj == 0) {
						sub.preencherValorMatriz(i, j, this.matriz[ii-2+i][jj+1+j]);
				}
				else if(ii == 2 && jj == 1) {
					if (j == 0) {
						sub.preencherValorMatriz(i, j, this.matriz[ii-2+i][jj-1]);
					}
					else {
						sub.preencherValorMatriz(i, j, this.matriz[ii-2+i][jj+1]);
					}
				}
				else if (ii == 2 && jj == 2){
					sub.preencherValorMatriz(i, j, this.matriz[ii-2+i][jj-2+j]);
				}
			}
		}
		
		return ( ( sub.getValor(0, 0) * sub.getValor(1, 1) ) - ( sub.getValor(0, 1) * sub.getValor(1, 0) ) );
	}
	

	@Override
	public Matriz3x3 transposta() {
		Matriz novaMatrizTransposta = new Matriz();
		for(int i=0; i < linha ; i++){  
	        for(int j = 0; j < coluna ; j++){  	            
	            novaMatrizTransposta.preencherValorMatriz(i, j, this.matriz[j][i]);
	        }  
	    } 
		return novaMatrizTransposta;
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
	public double getValor(int linha, int coluna) {
		return this.matriz[linha][coluna];
	}



}
