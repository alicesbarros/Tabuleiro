package br.ufrn.imd.modelo;

public class Casa {
	private boolean cor;
	private Peca ocupada;
	public Casa() {
		ocupada = null;
	}
	public boolean isCor() {
		return cor;
	}
	public void setCor(boolean cor) {
		this.cor = cor;
	}
	public Peca getOcupada() {
		return ocupada;
	}
	public void setOcupada(Peca ocupada) {
		this.ocupada = ocupada;
	} 
}
