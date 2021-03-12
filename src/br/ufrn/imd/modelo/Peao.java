package br.ufrn.imd.modelo;

public class Peao extends Peca implements Movimentos {

	public Peao() {
		this.setEstado(true);
		this.setImagem("p");
		this.setNome("Peao");
	}
	@Override
	public Casa andar() {
		return this.getPosicao();
	}

	@Override
	public Peca comer() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void morrer() {
		// TODO Auto-generated method stub

	}

}
