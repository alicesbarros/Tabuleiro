package br.ufrn.imd.modelo;

import java.util.ArrayList;

import br.ufrn.imd.controle.Tabuleiro;

public class Peao extends Peca{

	public Peao() {
		this.setEstado(true);
		String refs[] = {"file:img/peaoPreto.png","file:img/peaoBranco.png"};
		this.setImagem(refs);
		this.setNome("Peao");
	}
	@Override
	public ArrayList<Casa> andar(Tabuleiro T) {
		ArrayList<Casa> possiveis = new ArrayList<Casa>(); 
		int lin = this.getPosicao(1);
		int col = this.getPosicao(0);
		if(!this.isMoveu()) {
			if(this.getDono()==T.getBranco())
				possiveis.add(T.getCasa()[lin][col+2]);
			else
				possiveis.add(T.getCasa()[lin][col-2]);
		}
		if(this.getDono()==T.getBranco())
			possiveis.add(T.getCasa()[lin][col+1]);
		else
			possiveis.add(T.getCasa()[lin][col-1]);
		return possiveis;
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
