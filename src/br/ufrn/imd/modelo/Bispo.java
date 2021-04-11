package br.ufrn.imd.modelo;

import java.util.ArrayList;
import br.ufrn.imd.controle.Tabuleiro;

public class Bispo extends Peca{

	public Bispo() {
		this.setEstado(true);
		String refs[] = {"file:img/bispoPreto.png","file:img/bispoBranco.png"};
		this.setImagem(refs);
		this.setNome("Bispo");
	}
	@Override
	public ArrayList<Casa> andar(Tabuleiro T) {
		ArrayList<Casa> possiveis = new ArrayList<Casa>(); 
		int lin = this.getPosicao(1);
		int col = this.getPosicao(0);
		int a = -1;
		int b = -1;
		for(int dir=0;dir<4;dir++) {
			if(dir/2==1) a= 1;
			if(dir%2==1) b= 1;
			else b=-1;
			for(int i=1;i<8;i++) {
				if (lin+a*i<8 && lin+a*i>=0 && col+b*i<8 && col+b*i>=0) {
					if(T.getCasa()[lin+a*i][col+b*i].getOcupada()==null) {
						if(!possiveis.contains(T.getCasa()[lin+a*i][col+b*i])) {
							possiveis.add(T.getCasa()[lin+a*i][col+b*i]);
						}
					} else break;
				}else break;
			}
		}

		return possiveis;
	}

	@Override
	public br.ufrn.imd.modelo.Peca comer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void morrer() {
		// TODO Auto-generated method stub

	}

}
