package br.ufrn.imd.visao;

import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.animation.AnimationTimer;

public class Tempo extends AnimationTimer{
	Text total;
	Text branco;
	Text preto;
	boolean qualJogador;
	long inicio;
	long troca;
	long tempoBranco;
	long tempoPreto;
	long tempoTotal;
	VBox timers;
	long ultimoPulso;
	
	@Override
	public void handle(long now) {
		if(inicio==0) {
			inicio = now;
		}
		if((now-ultimoPulso)>1000000000) {
			ultimoPulso=now;			
			tempoTotal++;
			if(qualJogador) {
				tempoBranco++;
			}else {
				tempoPreto++;
			}
			total.setText(String.format("%02d:%02d:%02d",tempoTotal/360,(tempoTotal/360)%60,tempoTotal%60));
			branco.setText(String.format("%02d:%02d:%02d",tempoBranco/360,(tempoBranco/360)%60,tempoBranco%60));
			preto.setText(String.format("%02d:%02d:%02d",tempoPreto/360,(tempoPreto/360)%60,tempoPreto%60));
		}
	}
	
	public Tempo() {
		inicio = 0;		
		tempoBranco=0;
		tempoPreto=0;
		tempoTotal=0;
		ultimoPulso = inicio;
		total = new Text("00:00:00");
		branco = new Text("00:00:00");
		preto = new Text("00:00:00");
		timers = new VBox();
		timers.getChildren().add(total);
		timers.getChildren().add(branco);
		timers.getChildren().add(preto);
		qualJogador = true;
	}
	
	public VBox getTimers() {
		return timers;
	}
	
	public void mudaJogador() {
		if(qualJogador) qualJogador = false;
		else qualJogador=true;
	}	
}
