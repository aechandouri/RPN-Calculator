package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controleur implements EventHandler<ActionEvent>, PropertyChangeListener {

	InterfaceGraphique interG;
	Accumulateur accumulateur;
	
	
	public Controleur() {
		this.accumulateur = new Accumulateur(); //Création du modèle rattaché au controleur
		this.accumulateur.addPropertyChangeListener(this);
	}
	
	
	//Gestion des événements associés aux boutons (hors clavier chiffre)
	@Override
	public void handle(ActionEvent event) {
		
		//Analyse du bouton qui a déclenché l'événement et action sur le modèle en conséquence
		String bouton = ((Button)event.getSource()).getText();
		
		if (bouton == "+") {
			accumulateur.add();	
		}
		
		if (bouton == "-") {
			accumulateur.sub();
		}
		
		if (bouton == "*") {
			accumulateur.mult();
		}
		
		if (bouton == "/") {
			accumulateur.div();
		}
		
		if (bouton == "<>") {
			accumulateur.push();
		}
		
		if (bouton == "+/-") {
			accumulateur.neg();
		}
		
		if (bouton == "R") {
			accumulateur.reset();
		}
		
		if (bouton == "C") {
			accumulateur.drop();
		}
		
		if (bouton == "<->") {
			accumulateur.swap();
		}
		
		if (bouton == "<-") {
			accumulateur.backspace();
		}
		
		
		//Mise à jour de l'affichage des nombres de la pile
		List<String> memoireSt = new ArrayList<String>();
		Stack<Double> memoire = accumulateur.memoire.pile;
		
		for (int i=0; i<4-memoire.size(); i++) {
			memoireSt.add("");
			
		}
		
		for (int i=memoire.size()-1; i>-1; i--) {
			memoireSt.add(String.valueOf(memoire.get(i)));
		}
		
		interG.change(memoireSt);
		
		//Mise à jour de l'affichage de l'accumulateur
		interG.change(accumulateur.listener);
		
		
	}

	
	//Gestion des événements associés aux boutons du clavier de chiffres
	public void handleCh (ActionEvent event) {
		
		//Changement de la valeur de l'accumulateur en fonction du modèle et du bouton utilisé
		String valeur = ((Button)event.getSource()).getText();
		accumulateur.accumuler(valeur);
		interG.change(accumulateur.listener);
		
	}

	
	//Attribution d'une interface graphique au controleur
	public void setInterG(InterfaceGraphique interG) {
		
		this.interG = interG;
		
	}

	
	//Changement de l'affichage de l'accumulateur en réaction à un événement
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		
		this.interG.change((String) event.getNewValue());
		
	}

	
	
}
