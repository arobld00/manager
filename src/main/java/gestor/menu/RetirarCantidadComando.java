package gestor.menu;

import gestor.comun.Dialogo;
import gestor.comun.IO;

public class RetirarCantidadComando extends Comando {
	
	public RetirarCantidadComando() {
		super("Retirar cantidad de un cierto código.");
	}

	@Override
	public void ejecutar() {
		int codigo = Dialogo.instance().read("¿Código? ", 100);
		int cantidad = Dialogo.instance().read("¿Cantidad? ", 100);
		if (almacen.existe(codigo, cantidad)) {
			almacen.retirar(codigo, cantidad);
		} else {
			IO.instance().writeln("Error!!! No hay existencias");
		}
	}

}
