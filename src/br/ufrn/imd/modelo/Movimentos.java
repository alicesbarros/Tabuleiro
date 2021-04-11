package br.ufrn.imd.modelo;
import java.util.ArrayList;
import br.ufrn.imd.controle.*;

public interface Movimentos {
	ArrayList<Casa> andar(Tabuleiro T);
	Peca comer();
	void morrer();	
}
