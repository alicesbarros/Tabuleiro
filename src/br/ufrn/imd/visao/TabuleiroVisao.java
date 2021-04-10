package br.ufrn.imd.visao;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import br.ufrn.imd.controle.Tabuleiro;
import br.ufrn.imd.modelo.Peca;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TabuleiroVisao {
	GridPane base;
	Rectangle[][] casas;
	Rectangle[][] ocupadas;
	Tabuleiro tabula;	
	StackPane niveis;
	GridPane pecas;
	
	public TabuleiroVisao(){
		base = new GridPane();
		pecas = new GridPane();
		base.setHgap(2);
		base.setVgap(2);
		pecas.setHgap(2);
		pecas.setVgap(2);
		
		casas = new Rectangle[8][8];
		ocupadas = new Rectangle[8][8];
		tabula = new Tabuleiro();
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				casas[i][j]=new Rectangle(60,60);	
				ocupadas[i][j]=new Rectangle(60,60);
				
				if((i+j)%2==0)casas[i][j].setFill(Color.BROWN); 
				else casas[i][j].setFill(Color.BURLYWOOD);
				base.add(casas[i][j], i, j);
				ocupadas[i][j].setFill(Color.TRANSPARENT);
				pecas.add(ocupadas[i][j], i, j);
			}
		}	
		atualizarPecas();
		niveis = new StackPane();
		niveis.getChildren().add(base);
		niveis.getChildren().add(pecas);
	}
	
	public StackPane getTudo() {
		return niveis;
	}
	
	public GridPane getBase() {
		return base;
	}
	
	public void ajustar(double lado) {
		double medida = (lado - 1)/8;
		for(int i=0;i<8;i++) {			
			for(int j=0;j<8;j++) {
				casas[i][j].setWidth(medida);
				casas[i][j].setHeight(medida);			
				ocupadas[i][j].setWidth(medida);
				ocupadas[i][j].setHeight(medida);				
			}
		}
		atualizarPecas();
	}
	public void atualizarPecas() {
		for(Peca essa : tabula.getBranco().getPecas()) {
			ImagePattern ip = new ImagePattern(new Image(essa.getImagem(1)));
			ocupadas[essa.getPosicao(1)][essa.getPosicao(0)].setFill(ip);			
		}
		for(Peca essa : tabula.getPreto().getPecas()) {
			/*ImageView temp = new ImageView(new Image(essa.getImagem(1)));
			temp.setPreserveRatio(true);
			temp.setFitWidth(medida*0.9);
			temp.setFitHeight(medida*0.9);
			pecas.add(temp, essa.getPosicao(1), essa.getPosicao(0));*/
		}
	}
}
