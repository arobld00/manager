package gestor.prototype;

import gestor.gestor.Almacen;
import gestor.gestor.Servidor;

public abstract class Operador {
	
	protected Almacen almacen;
	
	protected Servidor servidor;
	
	public Operador(Almacen almacen, Servidor servidor) {
		this.almacen = almacen;
		this.servidor = servidor;
	}
	
	public abstract void ejecutar();
	
	public abstract Operador clone();

}
