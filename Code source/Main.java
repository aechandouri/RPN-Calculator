package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Création d'une instance InterfaceGraphique
			VBox calculatrice = new VBox();
			Controleur cont = new Controleur();
			InterfaceGraphique scene = new InterfaceGraphique(calculatrice, 450, 600, cont);
			
			//Affichage de l'interface
			scene.affiche();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			primaryStage.show();
			
			
			//TEST
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
