package gestor.gestor;

import gestor.menu.Menu;

public abstract class Gestor {
	
	protected Almacen almacen;
	
	protected Menu menu;
	
	protected Gestor() {
		menu = this.getMenu();
		almacen = this.instance();
	}
	
	protected abstract Almacen instance();
	
	protected abstract Menu getMenu();
	
	protected void administrar() {
		menu.ejecutar(almacen);
	}
	

}