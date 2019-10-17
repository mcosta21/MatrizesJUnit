package br.com.fsma.matriz.negocio.especificacao;

public interface Vetor3x1 {
	/**
	 *  Imprime o vetor atual no console, conforme está mostrado abaixo:
	 *  
	 *  
	 *  |  a11  |
	 *  |  a21  |
	 *  |  a31  |
	 *       
	 *  Obs.: Os números mostrados devem ter o seguinte formato: 99.99.
	 *  
	 */
	void imprime();
	/**
	 * Retorna o valor da linha recebida por parâmetro.
	 * @param linha
	 * @return
	 */
	double getValor(int linha);
	
	/** 
	 *	Gera um novo vetor. 
	 *	Esta novo vetor é o resultado da matriz atual multiplicado pelo vetor recebido por parâmetro.
	 * 
	 * @param vetor
	 * @return vetor
	 */
	Vetor3x1 multiplica(Vetor3x1 vetor);
}
