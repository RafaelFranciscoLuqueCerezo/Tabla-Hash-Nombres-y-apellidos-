package tablahash;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		TablaHash t_hash=new TablaHash(5);

		System.out.println("rellenado vector");
		for(int i=0;i<10000000;i++) {
			int val1 = (int) Math.floor(Math.random()*(26-0+26)+0);  // Valor entre M y N, ambos incluidos
			int val2 = (int) Math.floor(Math.random()*(26-0+26)+0);  // Valor entre M y N, ambos incluidos
			int val3 = (int) Math.floor(Math.random()*(26-0+26)+0);  // Valor entre M y N, ambos incluidos
			t_hash.addNodo(new Nodo(t_hash.getLetra(val1)+t_hash.getLetra(val2),t_hash.getLetra(val2)+t_hash.getLetra(val3),t_hash.getLetra(val3)));
		}
		System.out.println("fin relleno");
		t_hash.addNodo(new Nodo("Antonio","Aranda","Aguijon"));
		t_hash.addNodo(new Nodo("Antonio","Aranda","Aguijon"));
		ArrayList<Nodo> nodos=t_hash.findNodo("Antonio","Aranda","Aguijon");

		System.out.println(nodos.size());

	}

}
