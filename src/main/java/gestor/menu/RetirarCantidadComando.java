package gestor.menu;

import gestor.comun.Dialogo;
import gestor.comun.IO;

public class RetirarCantidadComando extends Comando {
	
	public RetirarCantidadComando() {
		super("Retirar cantidad de un cierto c�digo.");
	}

	@Override
	public void ejecutar() {
		int codigo = Dialogo.instance().read("�C�digo? ", 100);
		int cantidad = Dialogo.instance().read("�Cantidad? ", 100);
		if (almacen.existe(codigo, cantidad)) {
			almacen.retirar(codigo, cantidad);
		} else {
			IO.instance().writeln("Error!!! No hay existencias");
		}
	}

}
