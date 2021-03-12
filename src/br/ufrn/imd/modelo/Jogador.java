package br.ufrn.imd.modelo;

import java.util.ArrayList;

public class Jogador {
	private boolean cor;
	private ArrayList<Peao> peoes;
	private ArrayList<Torre> torres;
	private ArrayList<Bispo> bispos;
	private ArrayList<Cavalo> cavalos;
	private Rei rei;
	private Rainha rainha;
	public Jogador(boolean cor) {
		this.setCor(cor);
		peoes = new ArrayList<Peao>();
		torres = new ArrayList<Torre>();
		bispos = new ArrayList<Bispo>();
		cavalos = new ArrayList<Cavalo>();
		for(int ii=0;ii<2;ii++) {
			torres.add(new Torre());
			bispos.add(new Bispo());
			cavalos.add(new Cavalo());
		}
		for(int ii=0;ii<8;ii++) {
			peoes.add(new Peao());
		}
		this.setRei(new Rei());
		this.setRainha(new Rainha());
	}
	public boolean isCor() {
		return cor;
	}
	public void setCor(boolean cor) {
		this.cor = cor;
	}
	public ArrayList<Peao> getPeoes() {
		return peoes;
	}
	public Peao getPeao(int indice) {
		return peoes.get(indice);
	}
	public void setPeoes(ArrayList<Peao> peoes) {
		this.peoes = peoes;
	}
	public ArrayList<Torre> getTorres() {
		return torres;
	}
	public void setTorres(ArrayList<Torre> torres) {
		this.torres = torres;
	}
	public Torre getTorre(int indice) {
		return torres.get(indice);
	}
	public ArrayList<Bispo> getBispos() {
		return bispos;
	}
	public void setBispos(ArrayList<Bispo> bispos) {
		this.bispos = bispos;
	}
	public Bispo getBispo(int indice) {
		return bispos.get(indice);
	}
	public ArrayList<Cavalo> getCavalos() {
		return cavalos;
	}
	public void setCavalos(ArrayList<Cavalo> cavalos) {
		this.cavalos = cavalos;
	}
	public Cavalo getCavalo(int indice) {
		return cavalos.get(indice);
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
}
