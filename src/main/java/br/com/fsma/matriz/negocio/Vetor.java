package br.com.fsma.matriz.negocio;

import br.com.fsma.matriz.negocio.especificacao.Vetor3x1;

public class Vetor implements Vetor3x1 {
	
	private Double[] vetor;
	
	public Vetor() {
		this.vetor = new Double[3];
	}
	
	public Vetor(double v1, double v2, double v3) {
		this.vetor = new Double[3];
		vetor[0] = v1;
		vetor[1] = v2;
		vetor[2] = v3;
	}
	
	public void preencherValorVetor(int nlinha, double valor) {
		vetor[nlinha] = valor;
	}
	
	@Override
	public void imprime() {
		for (int i = 0; i < 3; i++) {
			System.out.println("i[" + i + "] = " + this.vetor[i]);
		}
	}

	@Override
	public double getValor(int linha) {
		return this.vetor[linha];
	}
	
	@Override
	public Vetor3x1 multiplica(Vetor3x1 vetorParametro) {
		Vetor novoVetorDaMultiplicacao = new Vetor();
		for (int i = 0; i < 3; i++) {
			novoVetorDaMultiplicacao.preencherValorVetor(i, this.vetor[i] * vetorParametro.getValor(i));
		}
		return novoVetorDaMultiplicacao;
	}

}
