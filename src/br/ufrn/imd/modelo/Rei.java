package br.ufrn.imd.modelo;

public class Rei extends Peca implements Movimentos {

	public Rei() {
		this.setNome("Rei");
		String refs[] = {"file:eiPreto.png","file:reiBranco.png"};
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
