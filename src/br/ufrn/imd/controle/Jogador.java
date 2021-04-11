package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.modelo.*;

public class Jogador {
	private boolean cor;
	private ArrayList<Peca> pecas;
	private Peao[] peoes;
	private Torre[] torres;
	private Bispo[] bispos;
	private Cavalo[] cavalos;
	private Rei rei;
	private Rainha rainha;
	public Jogador(boolean cor) {
		this.setCor(cor);
		pecas = new ArrayList<Peca>();
		peoes = new Peao[8];
		torres = new Torre[2];
		bispos = new Bispo[2];
		cavalos = new Cavalo[2];
		for(int ii=0;ii<2;ii++) {
			torres[ii]= new Torre();
			bispos[ii]=new Bispo();
			cavalos[ii] = new Cavalo();
			pecas.add(torres[ii]);
			pecas.add(bispos[ii]);
			pecas.add(cavalos[ii]);
			torres[ii].setDono(this);
			bispos[ii].setDono(this);
			cavalos[ii].setDono(this);
		}
		for(int ii=0;ii<8;ii++) {
			peoes[ii] = new Peao();
			pecas.add(peoes[ii]);
			peoes[ii].setDono(this);
		}
		this.setRei(new Rei());
		this.setRainha(new Rainha());
		pecas.add(rei);
		pecas.add(rainha);
		rei.setDono(this);
		rainha.setDono(this);
	}
	public boolean isCor() {
		return cor;
	}
	public void setCor(boolean cor) {
		this.cor = cor;
	}
	public Peao[] getPeoes() {
		return peoes;
	}
	public Peao getPeao(int indice) {
		return peoes[indice];
	}
	public void setPeoes(Peao[] peoes) {
		this.peoes = peoes;
	}
	public Torre[] getTorres() {
		return torres;
	}
	public void setTorres(Torre[] torres) {
		this.torres = torres;
	}
	public Torre getTorre(int indice) {
		return torres[indice];
	}
	public Bispo[] getBispos() {
		return bispos;
	}
	public void setBispos(Bispo[] bispos) {
		this.bispos = bispos;
	}
	public Bispo getBispo(int indice) {
		return bispos[indice];
	}
	public Cavalo[] getCavalos() {
		return cavalos;
	}
	public void setCavalos(Cavalo[] cavalos) {
		this.cavalos = cavalos;
	}
	public Cavalo getCavalo(int indice) {
		return cavalos[indice];
	}
	public Rei getRei() {
		return rei;
	}
	public void setRei(Rei rei) {
		this.rei = rei;
	}
	public Rainha getRainha() {
		return rainha;
	}
	public void setRainha(Rainha rainha) {
		this.rainha = rainha;
	}
	public ArrayList<Peca> getPecas(){
		return pecas;
	}
	public void troca(Peao nobre) {
		Rainha nova = new Rainha();
		nova.setDono(this);
		nova.setPosicao(nobre.getPosicao());
		this.pecas.remove(nobre);
		this.pecas.add(nova);
	}
}
