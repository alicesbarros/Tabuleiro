package br.ufrn.imd.modelo;

public class Cavalo extends Peca implements Movimentos {

	public Cavalo() {
		this.setNome("Cavalo");
		String refs[] = {"file:img/cavaloPreto.png","file:/img/cavaloPreto.png"};
		this.setImagem(refs);
		this.setEstado(true);
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
