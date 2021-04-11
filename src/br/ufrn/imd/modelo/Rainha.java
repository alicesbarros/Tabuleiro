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
		int[] a = {-1,1,0,0};
		int[] b = {0,0,-1,1};
		for(int dir=0;dir<4;dir++) {			
			for(int i=0;i<8;i++) {
				if(lin+a[dir]*i>=0 && lin+a[dir]*i<8 && col+b[dir]*i<8 && col+b[dir]*i>=0) {
					if(T.getCasa()[lin+a[dir]*i][col+b[dir]*i].getOcupada()==null) {
						if(!possiveis.contains(T.getCasa()[lin+a[dir]*i][col+b[dir]*i]))
							possiveis.add(T.getCasa()[lin+a[dir]*i][col+b[dir]*i]);
					} else i=8;
				}
			}
		}
		for(int i=-7;i<8;i++) {
			if(lin-i==0 && col-i>=0 && lin-i<8 && col-i<8) {
				if(T.getCasa()[lin-i][col-i].getOcupada()==null) {
					if(!possiveis.contains(T.getCasa()[lin-i][col-i]))
						possiveis.add(T.getCasa()[lin-i][col-i]);
				}
			}
			if(lin-i>=0 && col+i>=0 && lin-i<8 && col-i<8) {
				if(T.getCasa()[lin-i][col+i].getOcupada()==null) {
					if(!possiveis.contains(T.getCasa()[lin-i][col+i]))
						possiveis.add(T.getCasa()[lin-i][col+i]);
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
