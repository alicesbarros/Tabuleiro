package br.ufrn.imd.modelo;

import java.util.ArrayList;

import br.ufrn.imd.controle.Tabuleiro;

public class Rei extends Peca{

	public Rei() {
		this.setNome("Rei");
		String refs[] = {"file:img/reiPreto.png","file:img/reiBranco.png"};
		this.setImagem(refs);
	}
	@Override
	public ArrayList<Casa> andar(Tabuleiro T) {
		ArrayList<Casa> possiveis = new ArrayList<Casa>(); 
		int lin = this.getPosicao(1);
		int col = this.getPosicao(0);
		for(int i=lin-1;i<=lin+1;i++) {
			if(i<0) i++;
			if(i>7)break;
			for(int j=col-1;j<=col+1;j++) {
				if(j<0) j++;
				if(j>7)break;
				if(T.getCasa()[j][i].getOcupada()==null) {
					possiveis.add(T.getCasa()[i][j]);				
				}
			}				
		}			
		return possiveis;
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
