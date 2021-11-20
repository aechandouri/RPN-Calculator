package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InterfaceGraphique extends Scene implements IView {

	Controleur cont;
	VBox calculatrice;
	List<Button> boutonsCh = new ArrayList<Button>();
	List<Label> labels = new ArrayList<Label>();
	Label accumulateur;

	public InterfaceGraphique(VBox calculatrice, double width, double height, Controleur cont) {
		super(calculatrice, width, height);
		this.calculatrice = calculatrice;
		this.cont = cont;
		this.cont.setInterG(this);
		
		//Création de la liste de boutons pour les chiffres
		for (int i=0; i<10; i++) {
			boutonsCh.add(new Button(String.valueOf(i)));
		}
		
		//Création de la liste de labels de la pile
		for (int i=0; i<4; i++) {
			labels.add(new Label(""));
		}
		
		accumulateur = new Label("");
	}
	
	
	//Affichage de l'interface graphique
	public void affiche() {
		
		//Construction des éléments de l'interface à afficher
		
		//Elément pile+accumulateur
		VBox pile = new VBox();
		this.calculatrice.getChildren().add(pile);
		pile.setSpacing(2);
		
		pile.getChildren().addAll(labels.get(3), labels.get(2), labels.get(1), labels.get(0));
		pile.getChildren().add(accumulateur);
		
		pile.setAlignment(Pos.CENTER);
		accumulateur.setAlignment(Pos.CENTER_RIGHT);
		accumulateur.setMinWidth(calculatrice.getWidth());
		for (Label lb : labels) {
			lb.setAlignment(Pos.CENTER_RIGHT);
			lb.setMinWidth(calculatrice.getWidth());
		}
		
		//Elément clavier
		HBox clavier = new HBox();
		calculatrice.getChildren().add(clavier);
		calculatrice.setPadding(new Insets(25, 0, 25, 0));
		
		GridPane chClavier = new GridPane();
		VBox opClavier = new VBox();
		clavier.getChildren().addAll(chClavier, opClavier);
		
		Button btVirg = new Button(".");
		btVirg.addEventHandler(ActionEvent.ACTION, event -> { cont.handleCh(event);});
		Button btNeg = new Button("+/-");
		btNeg.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btC = new Button("C");
		btC.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btSwap = new Button("<->");
		btSwap.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btBS = new Button("<-");
		btBS.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		
		for (int j=0; j<3; j++) {
			for (int i=0; i<3; i++) {
				boutonsCh.get(boutonsCh.size()-1).addEventHandler(ActionEvent.ACTION, event -> { cont.handleCh(event);});
				chClavier.add(boutonsCh.get(boutonsCh.size()-1), i, j);
				boutonsCh.remove(boutonsCh.size()-1);
			}
		}
		chClavier.add(boutonsCh.get(0), 0, 3);
		boutonsCh.get(0).addEventHandler(ActionEvent.ACTION, event -> { cont.handleCh(event);});
		chClavier.add(btVirg, 1, 3);
		chClavier.add(btNeg, 2, 3);
		chClavier.add(btC, 0, 4);
		chClavier.add(btSwap, 1, 4);
		chClavier.add(btBS, 2, 4);
		
		
		Button btPlus = new Button("+");
		btPlus.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btMoins = new Button("-");
		btMoins.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btFois = new Button("*");
		btFois.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btDiv = new Button("/");
		btDiv.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btPush = new Button("<>");
		btPush.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		Button btR = new Button("R");
		btR.addEventHandler(ActionEvent.ACTION, event -> { cont.handle(event);});
		
		
		opClavier.getChildren().addAll(btPlus, btMoins, btFois, btDiv, btPush, btR);

		clavier.setSpacing(2);
		clavier.setAlignment(Pos.CENTER);
		clavier.setPadding(new Insets(15, 20, 20, 10));
		chClavier.setAlignment(Pos.CENTER);
		chClavier.setPadding(new Insets(15, 20, 20, 10));
		opClavier.setPadding(new Insets(15,20, 10,10));
		
	}
	
	
	//Changement de la valeur des opérandes de la pile
	public void change(List<String> data) {
		
		for (int i=0; i<labels.size(); i++) {
			labels.get(i).setText(data.get(i));
		}
		
	}
	
	
	//Changement du nombre présent dans l'accumulateur
	public void change(String accu) {
		
		accumulateur.setText(accu);
		
	}
	
}
