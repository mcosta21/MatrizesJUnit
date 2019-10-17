package br.com.fsma.matriz.negocio.especificacao;

public interface Matriz3x3 {
	/** 
	 *	Gera uma nova matriz que será retornada. 
	 *	Esta nova matriz é resultado da matriz atual adicionada com a matriz recebida por parâmetro. 
	 * 
	 * @param matriz
	 * @return novaMatriz
	 */
	Matriz3x3 adiciona(Matriz3x3 matriz);
	/** 
	 *	Gera uma nova matriz que será retornada. 
	 *	Esta nova matriz é o resultado da matriz atual subtraida pela matriz recebida por parâmatro.
	 * 
	 * @param matriz
	 * @return novaMatriz
	 */
	Matriz3x3 subtrai(Matriz3x3 matriz);
	/** 
	 *	Gera uma nova matriz que será retornada. 
	 *	Esta nova matriz é o resultado da matriz atual multiplicada pela matriz recebida por parâmetro.
	 * 
	 * @param matriz
	 * @return novaMatriz
	 */
	Matriz3x3 multiplica(Matriz3x3 matriz);
	/** 
	 *	Gera uma nova matriz que será retornada. 
	 *	Esta nova matriz é o resultado da matriz atual multiplicada pelo escalar recebido por parâmetro.
	 * 
	 * @param escalar
	 * @return novaMatriz
	 */
	Matriz3x3 multiplica(double escalar);
	
	/**
	 *  Gera e retorna uma nova matriz que é a inversa da matriz atual.
	 *  
	 * @return matriz
	 */
	Matriz3x3 inversa();
	/**
	 * 	Gera e retorna uma nova matriz que é a transposta da matriz atual.
	 * 
	 * @return
	 */
	Matriz3x3 transposta();
	/**
	 * Retorna um valor verdadeiro se a matriz atual for uma patriz escalar.
	 * 
	 * @return boolean
	 */
	boolean isEscalar();
	/**
	 * Retorna um valor verdadeiro se a matriz atual for uma matriz diagonal.
	 * @return boolean
	 */
	boolean isDiagonal();
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	boolean isIgual(Matriz3x3 matriz);
	/**
	 * Retorna o determinante da matriz atual.
	 * 
	 * @return double
	 */
	double getDeterminante();
	/**
	 * Retorna o valor do elemento situado na lina e coluna informados nos parâmetros.
	 * @param linha
	 * @param coluna
	 * @return double
	 */
	double getValor(int linha, int coluna);
	/**
	 *  Imprime a matriz atual no console, conforme está mostrado abaixo:
	 *  
	 *  
	 *  |  a11  a12  a13 |
	 *  |  a21  a22  a23 |
	 *  |  a31  a32  a33 |
	 *  
	 *  Obs.: Os números mostrados devem ter o seguinte formato: 99.99.
	 *  
	 */
	void imprime();
}


