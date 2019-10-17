package br.com.fsma.matriz.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.fsma.matriz.negocio.especificacao.Matriz3x3;

class UnidadeMatrizTest {

	@Test
	void deveRetornaOsValoresDaSomaDasMatrizes() {
		Matriz3x3 matrizOriginal = new Matriz(1,2,3,3,2,1,1,2,3);
		Matriz3x3 matrizUnidade = new UnidadeMatriz();
		assertEquals(4, matrizUnidade.adiciona(matrizOriginal).getValor(2,2));
	}
	
	@Test
	void deveRetornaOsValoresDaSubtracaoDasMatrizes() {
		Matriz3x3 matrizOriginal = new Matriz(1,2,3,3,2,1,1,2,3);
		Matriz3x3 matrizUnidade = new UnidadeMatriz();
		assertEquals(-2, matrizUnidade.subtrai(matrizOriginal).getValor(2,2));
	}
	
	@Test
	void deveRetornarSeMatrizEhEscalar() {
		Matriz3x3 matrizUnidade = new UnidadeMatriz();
		assertEquals(true, matrizUnidade.isEscalar());
	}
	
	@Test
	void deveRetornarSeMatrizEhDiagonal() {
		Matriz3x3 matrizUnidade = new UnidadeMatriz();
		assertEquals(true, matrizUnidade.isDiagonal());
	}

}
