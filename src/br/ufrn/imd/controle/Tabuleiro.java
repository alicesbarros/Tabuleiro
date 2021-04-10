package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.Casa;
import br.ufrn.imd.modelo.Peca;

public class Tabuleiro {
	private Jogador branco;
	private Jogador preto;
	private Casa casa[][];

	public Tabuleiro() {
		branco = new Jogador(false);
		preto = new Jogador(true);
		casa = new Casa[8][8];
		for (int ii=0;ii<8;ii++) {
			for (int jj=0;jj<8;jj++) {
				casa[ii][jj] = new Casa();
				casa[ii][jj].setLocal(ii, jj);
			}
		}
		ocupar(casa[0][0],branco.getTorre(0));
		ocupar(casa[0][7],branco.getTorre(1));
		ocupar(casa[7][0],preto.getTorre(0));
		ocupar(casa[7][7],preto.getTorre(1));
		ocupar(casa[0][1],branco.getCavalo(0));
		ocupar(casa[0][6],branco.getCavalo(1));
		ocupar(casa[7][1],preto.getCavalo(0));
		ocupar(casa[7][6],preto.getCavalo(1));
		ocupar(casa[0][2],branco.getBispo(0));
		ocupar(casa[0][5],branco.getBispo(1));
		ocupar(casa[7][2],preto.getBispo(0));
		ocupar(casa[7][5],preto.getBispo(1));
		ocupar(casa[0][3],branco.getRainha());
		ocupar(casa[0][4],branco.getRei());
		ocupar(casa[7][4],preto.getRainha());
		ocupar(casa[7][3],preto.getRei());
		for (int ii=0;ii<8;ii++) {
			ocupar(casa[1][ii],branco.getPeao(ii));
			ocupar(casa[6][ii],preto.getPeao(ii));
		}
	}
	
	public void ocupar(Casa c,Peca p) {
		c.setOcupada(p);
		p.setPosicao(c);
	}
	
	public Jogador getBranco() {
		return branco;
	}
	public void setBranco(Jogador branco) {
		this.branco = branco;
	}
	public Jogador getPreto() {
		return preto;
	}
	public void setPreto(Jogador preto) {
		this.preto = preto;
	}
	public Casa[][] getCasa() {
		return casa;
	}
	public void setCasa(Casa casa[][]) {
		this.casa = casa;
	}
}
