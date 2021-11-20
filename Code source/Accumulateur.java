package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Accumulateur implements IAccumulateur {

	Pile memoire;
	String listener; // Valeur entrée dans l'accumulateur par l'utilisateur
	PropertyChangeSupport changeP = new PropertyChangeSupport(this);

	public Accumulateur() {

		this.memoire = new Pile();
		this.listener = "";

	}

	// Ajout d'une valeur à la mémoire (pile)
	@Override
	public void push() {
		memoire.pile.push(Double.parseDouble(listener));
		String listenerPr = this.listener;
		listener = "";

		// Avertissement de changement de valeur
		this.changeP.firePropertyChange("value", listenerPr, listener);
	}

	@Override
	public void drop() {
		this.memoire.drop();
	}

	@Override
	public void add() {

		double nb1 = this.memoire.pile.pop();
		double nb2 = this.memoire.pile.pop();
		memoire.pile.push(nb1 + nb2);

		changeP.firePropertyChange("value", this.listener, String.valueOf(nb1 + nb2));

	}

	@Override
	public void sub() {

		double nb1 = memoire.pile.pop();
		double nb2 = memoire.pile.pop();
		memoire.pile.push(nb1 - nb2);

		changeP.firePropertyChange("value", listener, String.valueOf(nb1 - nb2));

	}

	@Override
	public void mult() {

		double nb1 = memoire.pile.pop();
		double nb2 = memoire.pile.pop();
		memoire.pile.push(nb1 * nb2);

		changeP.firePropertyChange("value", listener, String.valueOf(nb1 * nb2));

	}

	@Override
	public void div() {

		double nb1 = memoire.pile.pop();
		double nb2 = memoire.pile.pop();
		memoire.pile.push(nb1 / nb2);

		changeP.firePropertyChange("value", listener, String.valueOf(nb1 / nb2));

	}

	@Override
	public void neg() {

		String listenerPr = listener;
		listener = "-" + listener;

		changeP.firePropertyChange("value", listenerPr, listener);

	}

	// Supprimer le dernier chiffre entré dans l'accumulateur
	@Override
	public void backspace() {

		String listenerPr = listener;
		listener = listener.substring(0, listener.length() - 1);

		changeP.firePropertyChange("value", listenerPr, listener);

	}

	// Réinisialiser la mémoire
	@Override
	public void reset() {

		String listenerPr = listener;
		listener = "";

		changeP.firePropertyChange("value", listenerPr, listener);

		memoire.clear();

	}

	// Échanger la place des deux derniers nombre entrés dans la pile mémoire
	public void swap() {
		double nb1 = memoire.pile.pop();
		double nb2 = memoire.pile.pop();
		memoire.pile.push(nb1);
		memoire.pile.push(nb2);

	}

	// Ajouter un chiffre/virgule à la valeur de l'accumulateur
	@Override
	public void accumuler(String character) {

		String listenerPr = this.listener;
		listener += character;

		changeP.firePropertyChange("value", listenerPr, this.listener);
	}

	// Indiquer que les changements de propriétés seront "écoutés" par l'objet passé
	// en paramètre
	public void addPropertyChangeListener(PropertyChangeListener listener) {

		changeP.addPropertyChangeListener(listener);

	}

}
