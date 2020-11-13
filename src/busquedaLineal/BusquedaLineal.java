package busquedaLineal;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import tablahash.HiloBusqueda;
import tablahash.Nodo;

public class BusquedaLineal {
	protected static ArrayList<Nodo> nodos=new ArrayList<>();
	protected static ArrayList<Nodo> nodosR=new ArrayList<>();
	protected Semaphore sem=new Semaphore(1);
	public static String getLetra(int valor) {
		switch(valor) {
		case 0:return "A";case 1:return "B";
		case 2:return "C";case 3:return "D";
		case 4:return "E";case 5:return "F";
		case 6:return "G";case 7:return "H";
		case 8:return "I";case 9:return "J";
		case 10:return "K";case 11:return "L";
		case 12:return "M";case 13:return "N";
		case 14:return "Ñ";case 15:return "O" ;
		case 16:return "P";case 17:return "Q";
		case 18:return "R";case 19:return "S";
		case 20:return "T";case 21:return "U";
		case 22:return "V";case 23:return "W";
		case 24:return "X";case 25:return "Y";
		case 26:return "Z";default:return "Z";	
	}	
	}

	public static void main(String[] args) {
		System.out.println("rellenado vector");
		for(int i=0;i<1000000;i++) {
			int val1 = (int) Math.floor(Math.random()*(26-0+26)+0);  // Valor entre M y N, ambos incluidos
			int val2 = (int) Math.floor(Math.random()*(26-0+26)+0);  // Valor entre M y N, ambos incluidos
			int val3 = (int) Math.floor(Math.random()*(26-0+26)+0);  // Valor entre M y N, ambos incluidos
			//System.out.println(t_hash.getLetra(val1)+' '+t_hash.getLetra(val2)+' '+t_hash.getLetra(val3));
			nodos.add(new Nodo(getLetra(val1)+getLetra(val2),getLetra(val2)+getLetra(val3),getLetra(val3)));
		}
		nodos.add(new Nodo("Antonio","Aranda","Aguijon"));
		nodos.add(new Nodo("Antonio","Aranda","Aguijon"));
		System.out.println("fin relleno vector");
		long contador_start=System.currentTimeMillis();
		int hilos= (nodos.size()>100)?100:nodos.size();
		ExecutorService executor=Executors.newFixedThreadPool(hilos);
		String object []= {"Antonio","Aranda","Aguijon"};
		for(int i=0;i<hilos;i++) {
			executor.execute(new HiloBusquedaL(i,object,hilos));
		}
		executor.shutdown();
		while(!executor.isTerminated());
		long contador_end=System.currentTimeMillis();
		System.out.println("findNodo() tiempo(milisegundos): "+(contador_end-contador_start)+" ms");
		System.out.println(nodosR.size());

	}

}
