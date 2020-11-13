package tablahash;

import java.util.ArrayList;

public class RowHash {
	private ArrayList<Nodo> InnerArray=new ArrayList<>();//Array interno de una posici�n concreta de la tabla hash
	//M�todos

	//clearArray: limpia el ArrayList interno de una posici�n en concreto del hash
	public void clearArray() {this.InnerArray.clear();}
	//getSize   : devuelve el tama�o del ArrayList interno de una posici�n concreta del hash
	public int  getSize() {return this.InnerArray.size();}
	//getArray  : devuelve el ArrayList interno de una posici�n concreta del hash
	public ArrayList<Nodo> getArray(){return this.InnerArray;}
	//addNodo   : a�ade un nodo al ArrayList interno de una posici�n concreta del hash
	public void addNodo(Nodo nodo) {this.InnerArray.add(nodo);}
	
}
