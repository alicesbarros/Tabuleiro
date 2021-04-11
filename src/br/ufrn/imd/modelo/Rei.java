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
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				if(lin+i<8 && lin+1>=0 && col+j<8 && col+j>=0) {
					if(T.getCasa()[lin+i][col+j].getOcupada()==null) {
						possiveis.add(T.getCasa()[lin+i][col+j]);			
					}
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
