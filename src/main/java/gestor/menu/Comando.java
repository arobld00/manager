package gestor.menu;

import gestor.gestor.Almacen;

public abstract class Comando {

	private String titulo;
	
	protected Almacen almacen;
	
	protected Comando(String titulo) {
		assert titulo != null;
		this.titulo = titulo;
	}
	
	public String devolverTitulo() {
		return titulo;
	}
	
	public void set(Almacen almacen) {
		this.almacen = almacen;
	}
	
	public abstract void ejecutar();

}
