package tablahash;

public class Nodo {
	private String Nombre,Apellido1,Apellido2;
	private String Dni;
	private int CodigoPostal,Telefono;
	//Constructor
	public Nodo(String Nombre,String Apellido1,String Apellido2) {
		this.Nombre=Nombre;this.Apellido1=Apellido1;this.Apellido2=Apellido2;
	}
	//Observadores y modificadores
	public String getNombre() {return this.Nombre;}
	public String getApellido1() {return this.Apellido1;}
	public String getApellido2() {return this.Apellido2;}
	public String getDni() {return this.Dni;}
	public int    getCodigoPostal() {return this.CodigoPostal;}
	public int    getTelefono() {return this.Telefono;}
	
	public void   setNombre(String nombre) {this.Nombre=nombre;}
	public void   setApellido1(String apellido1) {this.Apellido1=apellido1;}
	public void   setApellido2(String apellido2) {this.Apellido2=apellido2;}
	public void   setDni(String dni) {this.Dni=dni;}
	public void   setCodigoPostal(int codigopostal) {this.CodigoPostal=codigopostal;}
	public void   setTelefono(int telefono) {this.Telefono=telefono;}
	
	public String [] getString() {
		String valor []=new String[3];
		valor[0]=this.Nombre;valor[1]=this.Apellido1;valor[2]=this.Apellido2;
		return valor;
					}
	
}
