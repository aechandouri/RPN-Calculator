package application;

import java.util.Stack;


public class Pile extends Stack<Double> {

	Stack<Double> pile;

	
	public Pile(){

		this.pile = new Stack<Double>();

		}

	
	//Suppresion du dernier nombre ajouté à la mémoire (pile)
	public void drop() {

		if(pile.size()>0) {
			pile.pop();
		}

	}

	
	//Réinisialisation de la mémoire (pile vidée)
	public void clear() {

		while(pile.size()>0) {
			pile.pop();
		}
		
	}
	
	
}
