package gestor.menu;

import java.util.ArrayList;

import java.util.List;

import gestor.comun.Dialogo;
import gestor.comun.IO;
import gestor.gestor.Almacen;

public abstract class Menu {
	
	protected List<Comando> listaComandos;
	
	private SalirComando salirComando;
	
	public Menu() {
		listaComandos = new ArrayList<Comando>();
		this.setComandos();
		salirComando = new SalirComando();
		listaComandos.add(salirComando);
	}
	
	protected abstract void setComandos();
	
	protected void set(Almacen almacen) {
		assert almacen != null;
		for(Comando comando : listaComandos){
			comando.set(almacen);
		}
	}
	
	public void ejecutar(Almacen almacen) {
		assert almacen != null;
		this.set(almacen);
		salirComando.reiniciar();
		do {
			this.mostrarAlmacen(almacen);
			this.escribir();
			int opcion = this.devolverOpcion();
			listaComandos.get(opcion).ejecutar();	
		} while (!salirComando.estado());
	}
	
	private void escribir() {
		IO.instance().writeln();
		IO.instance().writeln("---------------------");
		for (int i = 0; i < listaComandos.size(); i++) {
			IO.instance().writeln(
					(i + 1) + ". " + listaComandos.get(i).devolverTitulo());
		}
	}
	
	private int devolverOpcion() {
		return Dialogo.instance().leer("Opción", 1, listaComandos.size())-1;
	}
	
	private void mostrarAlmacen(Almacen almacen) {
		assert almacen != null;
		int[][] lista = almacen.listar();
		IO.instance().writeln();
		IO.instance().writeln("ALMACEN");
		for (int[] articulo : lista) {
			IO.instance().writeln(
					"Código: " + articulo[0] + ", cantidad:" + articulo[1]);
		}
		IO.instance().writeln();
	}
}
