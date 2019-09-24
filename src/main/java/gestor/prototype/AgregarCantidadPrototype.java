package gestor.prototype;

import gestor.almacen.Trama;
import gestor.gestor.Almacen;
import gestor.gestor.Servidor;

public class AgregarCantidadPrototype extends Operador {
	
	public AgregarCantidadPrototype(Almacen almacen, Servidor servidor) {
		super(almacen, servidor);
	}
	
	@Override
	public void ejecutar() {
		try {
			int codigo = Integer.parseInt(servidor.leer());
			int cantidad = Integer.parseInt(servidor.leer());
			almacen.agregar(codigo, cantidad);
			servidor.escribir(Trama.ACK.name());
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Operador clone() {
		return new AgregarCantidadPrototype(almacen, servidor);
	}

}

