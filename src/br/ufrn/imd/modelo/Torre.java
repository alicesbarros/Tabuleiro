package br.ufrn.imd.modelo;

public class Torre extends Peca implements Movimentos {
	
	public Torre() {
		this.setEstado(true);
		this.setNome("Torre");
		String refs[] = {"file:img/torrePreta.png","file:img/torreBranca.png"};
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
