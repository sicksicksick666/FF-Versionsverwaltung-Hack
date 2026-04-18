package t3FX_LT3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T3FX_LT3 extends Application {

// Florian Svetina - 2410640016 - HA4
	
	public static void main(String[] args) {
		launch(args);
		}

	// Ganze Zahl eingegeben?

	private boolean isInteger(String zahl) {
		try {
			Integer.parseInt(zahl);
			return true;
		} catch (NumberFormatException e) {
			return false;
			}
		}

	// Quadrat
	
	private int quadrat(int z) {
		return z * z;
		}

	// Kubik

	private int kubik(int z) {
		return z * z * z;
		}

	
	@Override
	public void start(Stage arg0) {
		int n = 5;

		// Arrays für tf & lbl
		
		TextField[] tf = new TextField[n];
		Label[] l1 = new Label[n];
		Label[] l2 = new Label[n];

		// Überschriften

		Label h1 = new Label("Zahl");
		h1.setPrefWidth(150);
		Label h2 = new Label("Quadrat");
		h2.setPrefWidth(150);
		Label h3 = new Label("Kubik");
		h3.setPrefWidth(150);
		
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(5));
		gp.setHgap(10);
		gp.setVgap(10);
		
		gp.add(h1, 0, 0);
		gp.add(h2, 1, 0);
		gp.add(h3, 2, 0);
		
		// 5 Zeilen mit tf, l1, l2

		for (int i = 0; i < n; i++) {

			tf[i] = new TextField();
			tf[i].setPromptText("Ganze Zahl eingeben:");

			l1[i] = new Label("-");
			l2[i] = new Label("-");

			gp.add(tf[i], 0, i + 1);
			gp.add(l1[i], 1, i + 1);
			gp.add(l2[i], 2, i + 1);

			
			final int ergebnis = i;

			//Ergebnis
			
			tf[ergebnis].setOnAction(e -> {
				String zahl = tf[ergebnis].getText();
    
				if (isInteger(zahl)) {
					int wert = Integer.parseInt(zahl);
					l1[ergebnis].setText(String.valueOf(quadrat(wert)));
					l2[ergebnis].setText(String.valueOf(kubik(wert)));
				} else {
					l1[ergebnis].setText("Keine Zahl");
					l2[ergebnis].setText("Keine Zahl");
					}
				} );
			}

		arg0.setScene(new Scene(gp));
		arg0.setTitle("T3FX_LT3");
		arg0.show();
	}
}
