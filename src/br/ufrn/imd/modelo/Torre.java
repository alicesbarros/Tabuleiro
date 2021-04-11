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
		int cont=0;
		while(col+cont<8 && T.getCasa()[lin][col+cont].getOcupada()==null) {
			possiveis.add(T.getCasa()[lin][col+cont]);
			cont++;
		}
		cont=0;
		while(col-cont>=0 && T.getCasa()[lin][col-cont].getOcupada()==null) {
			possiveis.add(T.getCasa()[lin][col-cont]);
			cont++;
		}
		cont=0;
		while(lin+cont<8 && T.getCasa()[lin+cont][col].getOcupada()==null) {
			possiveis.add(T.getCasa()[lin+cont][col]);
			cont++;
		}
		cont=0;
		while(lin-cont>=0 && T.getCasa()[lin-cont][col].getOcupada()==null) {
			possiveis.add(T.getCasa()[lin-cont][col]);
			cont++;
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
