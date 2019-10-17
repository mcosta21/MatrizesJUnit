package br.com.fsma.matriz.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.fsma.matriz.negocio.especificacao.Matriz3x3;

class MatrizTest {

	@Test
	void deveRetornarOsValoresDosElementosDaMatriz() {
		Matriz3x3 matrizOriginal = new Matriz(1,8,3,3,2,7,2,1,3);
		assertEquals(1, matrizOriginal.getValor(0,0));
		assertEquals(8, matrizOriginal.getValor(0,1));
		assertEquals(3, matrizOriginal.getValor(0,2));
		assertEquals(3, matrizOriginal.getValor(1,0));
		assertEquals(2, matrizOriginal.getValor(1,1));
		assertEquals(7, matrizOriginal.getValor(1,2));
		assertEquals(2, matrizOriginal.getValor(2,0));
		assertEquals(1, matrizOriginal.getValor(2,1));
		assertEquals(3, matrizOriginal.getValor(2,2));
	}
	
	@Test
	void deveRetornaOsValoresDaSomaDasMatrizes() {
		Matriz3x3 matrizOriginal = new Matriz(0,8,1.6,3,20.7,1,1,2,3);
		Matriz3x3 matrizSecundaria = new Matriz(75,2,3,3,2,21,2,1,10);
		assertEquals(75, matrizOriginal.adiciona(matrizSecundaria).getValor(0,0));
		assertEquals(10, matrizOriginal.adiciona(matrizSecundaria).getValor(0,1));
		assertEquals(4.6, matrizOriginal.adiciona(matrizSecundaria).getValor(0,2));
		assertEquals(6, matrizOriginal.adiciona(matrizSecundaria).getValor(1,0));
		assertEquals(22.7, matrizOriginal.adiciona(matrizSecundaria).getValor(1,1));
		assertEquals(22, matrizOriginal.adiciona(matrizSecundaria).getValor(1,2));
		assertEquals(3, matrizOriginal.adiciona(matrizSecundaria).getValor(2,0));
		assertEquals(3, matrizOriginal.adiciona(matrizSecundaria).getValor(2,1));
		assertEquals(13, matrizOriginal.adiciona(matrizSecundaria).getValor(2,2));
	}
	
	@Test
	void deveRetornaOsValoresDaSubtracaoDasMatrizes() {
		Matriz3x3 matrizOriginal = new Matriz(1,2,3,3,2,1,1,2,3);
		Matriz3x3 matrizSecundaria = new Matriz(1,2,3,3,2,1,2,1,3);
		assertEquals(0, matrizSecundaria.subtrai(matrizOriginal).getValor(2,2));
	}
	
	@Test
	void deveRetornarOsValoresDosElementosDaMultiplicacaoDasMatrizes() {
		Matriz3x3 matrizOriginal = new Matriz(0.9,0.8,0.7,1.4,2.5,3.6,22.1,3.33,4.41);
		Matriz3x3 matrizSecundaria = new Matriz(10, 100, 400, 20, 200, 500, 30, 300, 600);
		assertEquals(13151.0, matrizOriginal.multiplica(matrizSecundaria).getValor(2,2) );
//		matrizOriginal.multiplica(matrizSecundaria).imprime();
	}
	
	@Test
	void deveRetornarODeterminante() {
		Matriz3x3 matrizOriginal = new Matriz(8, 6, 3, 4, 5, 6, 7, 8, 9);
		assertEquals(3, matrizOriginal.getDeterminante() );
	}
	
	@Test
	void deveRetornarSeMatrizEhEscalar() {
		Matriz3x3 matrizOriginal = new Matriz(2,0,0,0,2,0,0,0,2);
		assertEquals(true, matrizOriginal.isEscalar());
	}
	
	@Test
	void deveRetornarSeMatrizEhDiagonal() {
		Matriz3x3 matrizOriginal = new Matriz(2,0,0,0,2,0,0,0,2);
		assertEquals(true, matrizOriginal.isDiagonal());
	}
	
	@Test
	void deveRetornarSeMatrizesSaoIguais() {
		Matriz3x3 matrizOriginal = new Matriz(1,2,3,3,2,1,2,1,3);
		Matriz3x3 matrizSecundaria = new Matriz(1,2,3,3,2,1,2,1,3);
		assertEquals(true, matrizOriginal.isIgual(matrizSecundaria));
	}
	
	@Test
	void deveImprimirOUsoDaJuncaoDosMetodos() {
		Matriz3x3 matrizOriginal = new Matriz(0.9,0.8,0.7,1.4,2.5,3.6,22.1,3.33,4.41);
		Matriz3x3 matrizSecundaria = new Matriz(10, 100, 400, 20, 200, 500, 30, 300, 600);
		matrizOriginal.multiplica(5).adiciona(matrizSecundaria).subtrai(matrizSecundaria).multiplica(50).transposta().inversa().imprime();
	}
	
}
