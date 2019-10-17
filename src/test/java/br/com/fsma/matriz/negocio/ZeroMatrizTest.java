package br.com.fsma.matriz.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.fsma.matriz.negocio.especificacao.Matriz3x3;

class ZeroMatrizTest {

	@Test
	void deveRetornaOsValoresDaSomaDasMatrizes() {
		Matriz3x3 matrizOriginal = new Matriz(1,2,3,3,2,1,1,2,3);
		Matriz3x3 matrizZero = new ZeroMatriz();
		assertEquals(3, matrizZero.adiciona(matrizOriginal).getValor(2,2));
	}
	
	@Test
	void deveRetornaOsValoresDaSubtracaoDasMatrizes() {
		Matriz3x3 matrizOriginal = new Matriz(1,2,3,3,2,1,1,2,3);
		Matriz3x3 matrizZero = new ZeroMatriz();
		assertEquals(-2, matrizZero.subtrai(matrizOriginal).getValor(0,1));
	}
	
}
