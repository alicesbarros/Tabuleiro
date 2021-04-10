package br.ufrn.imd.modelo;

public class Rainha extends Peca implements Movimentos {

	public Rainha() {
		this.setNome("Rainha");
		String refs[] = {"file:rainhaPreta.png","file:rainhaBranca.png"};
		this.setImagem(refs);
	}
	@Override
	public Casa andar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Peca comer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void morrer() {
		// TODO Auto-generated method stub

	}
}
