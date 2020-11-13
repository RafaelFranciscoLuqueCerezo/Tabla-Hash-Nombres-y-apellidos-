package tablahash;

import java.util.ArrayList;

public class RowHash {
	private ArrayList<Nodo> InnerArray=new ArrayList<>();//Array interno de una posición concreta de la tabla hash
	//Métodos

	//clearArray: limpia el ArrayList interno de una posición en concreto del hash
	public void clearArray() {this.InnerArray.clear();}
	//getSize   : devuelve el tamaño del ArrayList interno de una posición concreta del hash
	public int  getSize() {return this.InnerArray.size();}
	//getArray  : devuelve el ArrayList interno de una posición concreta del hash
	public ArrayList<Nodo> getArray(){return this.InnerArray;}
	//addNodo   : añade un nodo al ArrayList interno de una posición concreta del hash
	public void addNodo(Nodo nodo) {this.InnerArray.add(nodo);}
	
}
