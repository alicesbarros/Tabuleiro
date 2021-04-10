package br.ufrn.imd.visao;

import br.ufrn.imd.modelo.Peca;
import javafx.scene.image.Image;


public class PecaVisao {
	private Peca peca;
	
	public Image figura() {
		Image fig = new Image(peca.getImagem(0));
		return fig;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
}
