package br.ufrn.imd.modelo;


public class Casa {
	private Peca ocupada;
	private int[] local;
	
	public Casa() {
		ocupada = null;
		local = new int[2];
	}
	public Peca getOcupada() {
		return ocupada;
	}
	public void setOcupada(Peca ocupada) {
		this.ocupada = ocupada;
	} 
	public void setLocal(int x,int y) {		
		local[0] = x;
		local[1] = y;
	}
	public int[] getLocal() {
		return local;
	}
}
