package br.ufrn.imd.modelo;

import br.ufrn.imd.controle.Jogador;

public abstract class Peca implements Movimentos {
	private String nome;
	private String[] imagem;
	private boolean estado;
	private boolean moveu;
	private Casa posicao;
	private Jogador dono;
	
	public void setDono(Jogador Dono) {
		dono = Dono;
	}
	
	public Jogador getDono() {
		return dono;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagem(int jogador) {
		return imagem[jogador];
	}
	public void setImagem(String[] imagem) {
		this.imagem = imagem;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean isMoveu() {
		return moveu;
	}
	public void setMoveu(boolean moveu) {
		this.moveu = moveu;
	}
	public Casa getPosicao() {
		return posicao;
	}
	public int getPosicao(int i) {
		return posicao.getLocal()[i];
	}
	public void setPosicao(Casa posicao) {
		this.posicao = posicao;
	}
	public void mover(Casa nova) {
		this.getPosicao().setOcupada(null);
		System.out.println(this.getPosicao().getOcupada());
		System.out.println(this.getPosicao());
		nova.setOcupada(this);
		System.out.println(this.getPosicao());
		this.setPosicao(nova);
		this.setMoveu(true);
	}
}
