package gestor.menu;

import gestor.comun.Dialogo;

public class AgregarCantidadComando extends Comando {
	
	public AgregarCantidadComando() {
		super("Agregar cantidad a cierto c�digo.");
	}

	@Override
	public void ejecutar() {
		int codigo = Dialogo.instance().read("�C�digo? ", 100);
		int cantidad = Dialogo.instance().read("�Cantidad? ", 100);
		almacen.agregar(codigo, cantidad);
	}

}
