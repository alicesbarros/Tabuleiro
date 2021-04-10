package br.ufrn.imd.visao;


import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import br.ufrn.imd.controle.Tabuleiro;
import br.ufrn.imd.modelo.Peca;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TabuleiroVisao {
	GridPane base;
	Rectangle[][] casas;
	Tabuleiro tabula;	
	
	public TabuleiroVisao(){
		base = new GridPane();
		
		base.setHgap(2);
		base.setVgap(2);
		
		casas = new Rectangle[8][8];
		
		tabula = new Tabuleiro();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				casas[i][j]=new Rectangle(60,60);	
				
				if((i+j)%2==0)casas[i][j].setFill(Color.BROWN); 
				else casas[i][j].setFill(Color.BURLYWOOD);
				base.add(casas[i][j], i, j);
			}
		}	
		atualizarPecas();
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
			}
		}
	}
	public void atualizarPecas() {
        Image temp = new Image("file:bispoPreto.png");
        base.add(new ImageView(temp), 0, 0);
		//base.add(new ImageView(getClass().getResource("\\Xadrez\\img\\bispoPreto.png").toExternalForm()),0,0);
		/*for(Peca essa:tabula.getBranco().getPecas()) {
			ImageView dessa = new ImageView(essa.getImagem(0));
			base.add(dessa, essa.getPosicao().getLocal()[0], essa.getPosicao().getLocal()[1]);
		}*/
	}
}
