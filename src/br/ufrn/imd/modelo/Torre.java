package br.ufrn.imd.modelo;

public class Torre extends Peca implements Movimentos {
	
	public Torre() {
		this.setEstado(true);
		this.setNome("Torre");
		this.setImagem("T");
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
