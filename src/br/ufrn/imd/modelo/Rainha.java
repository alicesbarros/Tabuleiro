package br.ufrn.imd.modelo;

import java.util.ArrayList;

import br.ufrn.imd.controle.Tabuleiro;

public class Rainha extends Peca{

	public Rainha() {
		this.setNome("Rainha");
		String refs[] = {"file:img/rainhaPreta.png","file:img/rainhaBranca.png"};
		this.setImagem(refs);
	}
	@Override
	public ArrayList<Casa> andar(Tabuleiro T) {
		ArrayList<Casa> possiveis = new ArrayList<Casa>(); 
		int lin = this.getPosicao(1);
		int col = this.getPosicao(0);
		int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		for (int[] mod:dir) {
			int i=lin;
			int j=col;
			while(i<8 && i>=0 && j<8 && j>=0 && T.getCasa()[j][i].getOcupada()==null) {
				possiveis.add(T.getCasa()[j][i]);
			}
			i = i+mod[0];
			j = j+mod[1];
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
