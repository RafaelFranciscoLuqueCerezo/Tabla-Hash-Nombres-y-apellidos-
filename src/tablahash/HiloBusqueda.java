package tablahash;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class HiloBusqueda implements Runnable{
	private int index;           //Indice del hilo
	private RowHash row;         //Objeto fila del hash
	private String object [];    //Array de String que contiene los parámetros que se van a comparar
	private int hilos;           //Número de hilos que van a operar concurrentemente.
	private Semaphore sem;
	private ArrayList<Nodo> nodos;
	//Constructor
	public HiloBusqueda(int index,RowHash row,String [] object,int hilos,Semaphore sem,ArrayList<Nodo> nodos) {
		this.index=index;
		this.row=row;
		this.object=object;
		this.hilos=hilos;
		this.sem=sem;
		this.nodos=nodos;
		}
	//Método
	@Override
	public void run() {
		for(int i=this.index;i<this.row.getSize();i+=hilos) {
			if( (row.getArray().get(i).getNombre().toUpperCase().equals(object[0].toUpperCase()))
			   && (row.getArray().get(i).getApellido1().toUpperCase().equals(object[1].toUpperCase()))
			   && (row.getArray().get(i).getApellido2().toUpperCase().equals(object[2].toUpperCase()))
			   ) {
				try {
					this.sem.acquire(1);
					this.nodos.add(row.getArray().get(i));
					this.sem.release(1);
				} catch (InterruptedException e) {e.printStackTrace();}

			}	
		}//fin for
	}//fin run


}
