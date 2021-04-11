package br.ufrn.imd.modelo;

import java.util.ArrayList;

import br.ufrn.imd.controle.Tabuleiro;

public class Cavalo extends Peca{

	public Cavalo() {
		this.setNome("Cavalo");
		String refs[] = {"file:img/cavaloPreto.png","file:img/cavaloBranco.png"};
		this.setImagem(refs);
		this.setEstado(true);
	}
	@Override
	public ArrayList<Casa> andar(Tabuleiro T) {
		ArrayList<Casa> possiveis = new ArrayList<Casa>(); 
		int lin = this.getPosicao(1);
		int col = this.getPosicao(0);
		int[][] dir = {{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,-1},{-2,1}};
		for(int[] mod :dir) {
			int i = lin+mod[0];
			int j = col+mod[1];
			if(i<0 || i>7 || j<0 || j>7) continue;
			else {
				if(T.getCasa()[j][i].getOcupada()==null) {
					if(!possiveis.contains(T.getCasa()[i][j])) {
						possiveis.add(T.getCasa()[i][j]);
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
