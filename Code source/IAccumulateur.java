package application;

public interface IAccumulateur {

	void push() ;
	void drop();
	void add();
	void sub();
	void mult();
	void div();
	void neg();
	void backspace();
	void reset();
	void accumuler(String character);
	
}
