package busquedaLineal;


public class HiloBusquedaL extends BusquedaLineal implements Runnable{
	private int index;           //Indice del hilo
	private String object [];    //Array de String que contiene los parámetros que se van a comparar
	private int hilos;           //Número de hilos que van a operar concurrentemente.
	//Constructor
	public HiloBusquedaL(int index,String [] object,int hilos) {
		this.index=index;
		this.object=object;
		this.hilos=hilos;
		}
	//Método
	@Override
	public void run() {
		for(int i=this.index;i<nodos.size();i+=hilos) {
			if( (nodos.get(i).getNombre().toUpperCase().equals(object[0].toUpperCase()))
			   && (nodos.get(i).getApellido1().toUpperCase().equals(object[1].toUpperCase()))
			   && (nodos.get(i).getApellido2().toUpperCase().equals(object[2].toUpperCase()))
			   ) {
				try {
					super.sem.acquire(1);
					nodosR.add(nodos.get(i));
					super.sem.release(1);
				} catch (InterruptedException e) {e.printStackTrace();}

			}	
		}//fin for
	}//fin run

}
