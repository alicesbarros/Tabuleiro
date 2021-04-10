module Xadrez {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens br.ufrn.imd.visao to javafx.graphics, javafx.fxml;
}
