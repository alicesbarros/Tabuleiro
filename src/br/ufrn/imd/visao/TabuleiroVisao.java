package br.ufrn.imd.visao;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import br.ufrn.imd.controle.*;
import br.ufrn.imd.modelo.Casa;
import br.ufrn.imd.modelo.Peca;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
import java.util.ArrayList;
import javafx.scene.text.Text;

public class TabuleiroVisao {
	private GridPane base;
	private Rectangle[][] casas;
	private Rectangle[][] ocupadas;
	private Rectangle[][] espacos;
	private Tabuleiro tabula;	
	private StackPane niveis;
	private GridPane pecas;
	private GridPane informativa;
	private Rectangle selecionada;
	private ArrayList<Rectangle> podeIr;
	private int selecao[];
	private Jogador daVez;	
	private Text mensagem;
	
	public TabuleiroVisao(){
		base = new GridPane();
		pecas = new GridPane();
		informativa = new GridPane();
		base.setHgap(2);
		base.setVgap(2);
		pecas.setHgap(2);
		pecas.setVgap(2);
		informativa.setHgap(2);
		informativa.setVgap(2);
		selecao = new int[2];
		selecao[0] = -1;
		selecao[1] = -1;
		
		
		casas = new Rectangle[8][8];
		ocupadas = new Rectangle[8][8];
		espacos = new Rectangle[8][8];
		
		selecionada = new Rectangle(60,60);
		selecionada.setFill(Color.TRANSPARENT);
		selecionada.setStroke(Color.AZURE);
		selecionada.setStrokeWidth(4);
		selecionada.setStrokeType(StrokeType.INSIDE);
		
		podeIr = new ArrayList<Rectangle>();
		for(int i=0;i<24;i++) {
			Rectangle tempAzul = new Rectangle(60,60);
			tempAzul.setFill(Color.TRANSPARENT);
			tempAzul.setStroke(Color.GREENYELLOW);
			tempAzul.setStrokeWidth(4);
			tempAzul.setStrokeType(StrokeType.INSIDE);
			podeIr.add(tempAzul);
		}
		
		tabula = Tabuleiro.getInstance();
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				casas[i][j]=new Rectangle(60,60);	
				ocupadas[i][j]=new Rectangle(60,60);
				espacos[i][j]=new Rectangle(60,60);
				
				if((i+j)%2==0)casas[i][j].setFill(Color.BROWN); 
				else casas[i][j].setFill(Color.BURLYWOOD);
				base.add(casas[i][j], i, j);
				ocupadas[i][j].setFill(Color.TRANSPARENT);
				espacos[i][j].setFill(Color.TRANSPARENT);
				informativa.add(espacos[i][j], i, j);
				pecas.add(ocupadas[i][j], i, j);
			}
		}	
		atualizarPecas();
		niveis = new StackPane();
		mensagem = new Text();
		mensagem.setText("Pronto");
		informativa.add(mensagem, 0,8,8,1);
		niveis.getChildren().add(base);
		niveis.getChildren().add(pecas);
		niveis.getChildren().add(informativa);
		pecas.setAlignment(Pos.TOP_CENTER);		
		eventosGrid(informativa);
		daVez=tabula.getBranco();
	}
	
	public void eventosGrid(GridPane p) {
		p.getChildren().forEach(casa->{
			casa.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@SuppressWarnings("static-access")
				@Override
				public void handle(MouseEvent event) {
					int j=p.getRowIndex(casa);			
					int i=p.getColumnIndex(casa);
					if(informativa.getChildren().contains(selecionada)) {
						int k = informativa.getColumnIndex(selecionada);
						int l = informativa.getRowIndex(selecionada);
						informativa.getChildren().remove(selecionada);
						boolean movimentoConcluido = false;
						for(Rectangle possivel:podeIr) {
							if(!informativa.getChildren().contains(possivel))
								break;
							int m = informativa.getColumnIndex(possivel);
							int n = informativa.getRowIndex(possivel);							
							if(i==n && j==m) {
								tabula.getCasa()[k][l].getOcupada().mover(tabula.getCasa()[m][n]);	
								System.out.println(tabula.getCasa()[m][n].toString());
								atualizarPecas();
								movimentoConcluido = true;
							}
						}
						if(!movimentoConcluido) {							
							int cont=0;
							while(informativa.getChildren().contains(podeIr.get(cont))) {
								informativa.getChildren().remove(podeIr.get(cont));
								cont++;
							}
						}else {
							if(daVez==tabula.getBranco()) daVez=tabula.getPreto();
							else daVez = tabula.getBranco();
						}
					}					
					else if(tabula.getCasa()[i][j].getOcupada()!=null) {	
						if(tabula.getCasa()[i][j].getOcupada().getDono()==daVez) {
							informativa.getChildren().remove(selecionada);
							informativa.add(selecionada, i, j);
							mensagem.setText(String.format("%d %d",i,j));
							mover(tabula.getCasa()[i][j]);
						}						
					}
				}
			});
		});
	}
	
	public void mover(Casa daPeca) {		
		int cont=0;
		while(informativa.getChildren().contains(podeIr.get(cont))) {
			informativa.getChildren().remove(podeIr.get(cont));
			cont++;
		}
		cont=0;
		for(Casa essa:daPeca.getOcupada().andar(tabula)) {
			informativa.add(podeIr.get(cont),essa.getLocal()[1],essa.getLocal()[0]);
			cont++;
		}
	}
	
	public StackPane getTudo() {
		return niveis;
	}
	
	public GridPane getBase() {
		return base;
	}
	
	public void ajustar(double lado) {
		base.setPrefWidth(lado-1);
		informativa.setPrefWidth(lado-1);
		pecas.setPrefWidth(lado-1);
		base.setPrefHeight(lado-1);
		informativa.setPrefHeight(lado+30);
		pecas.setPrefHeight(lado-1);
		double medida = (lado - 1)/8;
		for(int i=0;i<8;i++) {					
			for(int j=0;j<8;j++) {
				casas[i][j].setWidth(medida);
				casas[i][j].setHeight(medida);			
				ocupadas[i][j].setWidth(medida);
				ocupadas[i][j].setHeight(medida);		
				espacos[i][j].setWidth(medida);		
				espacos[i][j].setHeight(medida);
			}
		}
		selecionada.setWidth(medida);
		selecionada.setHeight(medida);
		
		atualizarPecas();
	}
	public void atualizarPecas() {
		double medida = 0.9*casas[0][0].getWidth();
		for(Peca essa : tabula.getBranco().getPecas()) {
			ImageView iv = new ImageView(new Image(essa.getImagem(1),medida,medida,true,true));			
			iv.setFitWidth(50);
			iv.setFitHeight(50);
			pecas.add(iv,essa.getPosicao(0),essa.getPosicao(1));			
		}
		for(Peca essa : tabula.getPreto().getPecas()) {
			ImageView iv = new ImageView(new Image(essa.getImagem(0),medida,medida,true,true));
			iv.setFitHeight(50);
			iv.setFitWidth(50);
			pecas.add(iv,essa.getPosicao(0),essa.getPosicao(1));			
		}
	}
}
