package br.com.fsma.matriz.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.fsma.matriz.negocio.especificacao.Vetor3x1;

class VetorTest {

	@Test
	void deveRetornarOsValoresDosElementosDoVetor() {
		Vetor3x1 vetorOriginal = new Vetor(5,6,4);
		assertEquals(5, vetorOriginal.getValor(0));
		assertEquals(6, vetorOriginal.getValor(1));
		assertEquals(4, vetorOriginal.getValor(2));
	}
	
	@Test
	void deveRetornarOsValoresDosElementosDaMultiplicacaoDosVetores() {
		Vetor3x1 vetorOriginal = new Vetor(5,6,4);
		Vetor3x1 vetorSecundario = new Vetor(5,2,1);
		assertEquals(12, vetorOriginal.multiplica(vetorSecundario).getValor(1) );
	}
	

}
