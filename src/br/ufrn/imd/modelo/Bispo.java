package br.ufrn.imd.modelo;

public class Bispo extends Peca implements Movimentos {

	public Bispo() {
		this.setEstado(true);
		String refs[] = {"file:img/bispoPreto.png","file:img/bispoBranco.png"};
		this.setImagem(refs);
		this.setNome("Bispo");
	}
	@Override
	public Casa andar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public br.ufrn.imd.modelo.Peca comer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void morrer() {
		// TODO Auto-generated method stub

	}

}
