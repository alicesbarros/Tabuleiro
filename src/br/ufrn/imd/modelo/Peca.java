package br.ufrn.imd.modelo;

public abstract class Peca {
	private String nome;
	private String imagem;
	private boolean estado;
	private boolean moveu;
	private Casa posicao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
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
	public void setPosicao(Casa posicao) {
		this.posicao = posicao;
	}
}
