package br.ufrn.imd.visao;

import br.ufrn.imd.modelo.Casa;
import javafx.scene.image.Image;

public class CasaVisao {
	private Casa casa;
	
	public Image getImagem() {
		if(casa.isCor()) {			 
			return new Image("img/casaClara.png"); 
		}else {
			return new Image("CasaEscura.png");
		}
	}
	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
}
