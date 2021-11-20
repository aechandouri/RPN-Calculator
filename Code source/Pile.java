package application;

import java.util.Stack;


public class Pile extends Stack<Double> {

	Stack<Double> pile;

	
	public Pile(){

		this.pile = new Stack<Double>();

		}

	
	//Suppresion du dernier nombre ajout� � la m�moire (pile)
	public void drop() {

		if(pile.size()>0) {
			pile.pop();
		}

	}

	
	//R�inisialisation de la m�moire (pile vid�e)
	public void clear() {

		while(pile.size()>0) {
			pile.pop();
		}
		
	}
	
	
}
