package tablahash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TablaHash {
	private final int MAX_HILOS=200;                //Numero máximo de hilos
	private int huecos;                             //Numero de huecos que se van a contemplar en el algoritmo       
	private RowHash[] HashArray;   			//Array del hash      
	private Semaphore sem=new Semaphore(1);         //Semáforo que controla la concurrencia de los hilos que agilizan la búsqueda
	private ArrayList<Nodo> nodos=new ArrayList<>();//ArrayList de nodos encontrados por el método finNodo
	//Constructor
	public TablaHash(int letras) {
		if(letras<3)
			this.huecos=3;
		else if(letras>6)
			this.huecos=6;
		else
			this.huecos=letras;
		int num=(int)Math.pow(27, this.huecos);
		System.out.println("generando hash de ("+num+") elementos");
		this.HashArray=new RowHash[num];
	}
	//Metodos
	//getLetra   : devuelve la letra perteneciente a un valor.
	public String getLetra(int valor) {
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
	//getValor    : devuelve el valor de la letra pasada por parámetro (valor usado para generar el hash)
	public int getValor(char letra) {
		switch(letra) {
			case 'A':return 0;case 'B':return 1;
			case 'C':return 2;case 'D':return 3;
			case 'E':return 4;case 'F':return 5;
			case 'G':return 6;case 'H':return 7;
			case 'I':return 8;case 'J':return 9;
			case 'K':return 10;case 'L':return 11;
			case 'M':return 12;case 'N':return 13;
			case 'Ñ':return 14;case 'O':return 15;
			case 'P':return 16;case 'Q':return 17;
			case 'R':return 18;case 'S':return 19;
			case 'T':return 20;case 'U':return 21;
			case 'V':return 22;case 'W':return 23;
			case 'X':return 24;case 'Y':return 25;
			case 'Z':return 26;default:return 26;	
		}
	}
	//findNodo    : encuentra todos los nodos que tengan los mismos parámetros de Nombre,Apellido1,Apellido2
	public ArrayList<Nodo> findNodo(String Nombre,String Apellido1,String Apellido2) {
		long contador_start=System.currentTimeMillis();
		String object []= {Nombre,Apellido1,Apellido2};
		int pos_memoria=funcionHash(object);
		nodos.clear();
		if(this.HashArray[pos_memoria]!=null) {
			int hilos= (this.HashArray[pos_memoria].getSize()>MAX_HILOS)?MAX_HILOS:this.HashArray[pos_memoria].getSize();
			ExecutorService executor=Executors.newFixedThreadPool(hilos);
			for(int i=0;i<hilos;i++) {
				executor.execute(new HiloBusqueda(i,this.HashArray[pos_memoria],object,hilos,this.sem,this.nodos));
			}
			executor.shutdown();
			while(!executor.isTerminated());
		}
		long contador_end=System.currentTimeMillis();
		System.out.println("findNodo() tiempo(milisegundos): "+(contador_end-contador_start)+" ms");
		return nodos;
	}
	//addNodo     : añade un nodo al array interno de una posición de memoria de la tabla de hash
	public void addNodo(Nodo nodo) {
		int pos_memoria=funcionHash(nodo.getString());
		if(this.HashArray[pos_memoria]==null)
			this.HashArray[pos_memoria]=new RowHash();
		this.HashArray[pos_memoria].addNodo(nodo);
	}
	//funcionHash : genera un hash mediante un algoritmo
	public int funcionHash(String Nombre []) {
		char values[]=new char[this.huecos];
		for(int i=0,j=0;i<this.huecos;i++,j++) {
			values[i]=Nombre[j].toUpperCase().charAt(0);
			if( (this.huecos-i-1)>1) {
				values[i+1]=Nombre[j].toUpperCase().charAt(1);
				i++;
			}	
		}
		//System.out.println(Arrays.toString(values));
		int valor=0;
		for(int i=(values.length-1),j=0;i>=0;i--,j++) {
			valor+=(getValor(values[i]) * (int)Math.pow(27,j));
		}
		return valor;
	}
}
