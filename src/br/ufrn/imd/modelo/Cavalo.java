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
		int mod[][]= {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
		
		for(int i=0;i<8;i++) {
			if(lin-mod[i][0]>=0 && lin-mod[i][0]<8 && col-mod[i][1]<8 && col-mod[i][1]>=0) {
				if(T.getCasa()[lin-mod[i][0]][col-mod[i][1]].getOcupada()==null) {
					possiveis.add(T.getCasa()[lin-mod[i][0]][col-mod[i][1]]);										
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
