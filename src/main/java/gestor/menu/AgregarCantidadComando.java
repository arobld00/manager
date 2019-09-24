package gestor.menu;

import gestor.comun.Dialogo;

public class AgregarCantidadComando extends Comando {
	
	public AgregarCantidadComando() {
		super("Agregar cantidad a cierto código.");
	}

	@Override
	public void ejecutar() {
		int codigo = Dialogo.instance().read("¿Código? ", 100);
		int cantidad = Dialogo.instance().read("¿Cantidad? ", 100);
		almacen.agregar(codigo, cantidad);
	}

}
