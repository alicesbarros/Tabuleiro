package br.ufrn.imd.visao;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

public class Main extends Application {
	private Tempo cronometro;
	TabuleiroVisao tabuleiro;
	Scene cena;
	HBox Mesa = new HBox();
	VBox Controle = new VBox();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		cena = novaCena(); 
		stage.setTitle("Xadrez com FX");
		stage.setScene(cena);
		stage.widthProperty().addListener(observable->redesenha(stage));
		stage.heightProperty().addListener(observable->redesenha(stage));
		stage.show();
	}
	
	private Scene novaCena() {
		Mesa = new HBox();
		Controle = new VBox();
		Button novoJogo = new Button();
		cronometro = new Tempo();		
		novoJogo.setText("Novo Jogo");
		Controle.getChildren().add(novoJogo);
		Controle.getChildren().add(cronometro.getTimers());
		
		Controle.setMinWidth(120);
		tabuleiro = new TabuleiroVisao();
		
		Mesa.getChildren().add(tabuleiro.getTudo());
		Mesa.getChildren().add(Controle);		
		cronometro.start();
		Scene cena = new Scene(Mesa,Color.BEIGE);
		
		return cena;
	}
	
	private void redesenha(Stage stage) {
		if(stage.getHeight()-100>(stage.getWidth()-Controle.getWidth())) {
			tabuleiro.ajustar(stage.getWidth()-Controle.getWidth());
		}else {
			tabuleiro.ajustar(stage.getHeight()-100);
		}
		Controle.setLayoutX(stage.getWidth()-Controle.getWidth());
	}
	
}
