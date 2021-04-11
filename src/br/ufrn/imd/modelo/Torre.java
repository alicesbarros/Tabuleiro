package br.ufrn.imd.modelo;

import java.util.ArrayList;

import br.ufrn.imd.controle.Tabuleiro;

public class Torre extends Peca{
	
	public Torre() {
		this.setEstado(true);
		this.setNome("Torre");
		String refs[] = {"file:img/torrePreta.png","file:img/torreBranca.png"};
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
				if(T.getCasa()[lin+a[dir]*i][col+b[dir]*i].getOcupada()==null && lin+a[dir]*i>=0 && lin+a[dir]*i<8 && col+b[dir]*i<8 && col+b[dir]*i>=0) {
					if(!possiveis.contains(T.getCasa()[lin+a[dir]*i][col+b[dir]*i]))
						possiveis.add(T.getCasa()[lin+a[dir]*i][col+b[dir]*i]);
				} else break;								
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
