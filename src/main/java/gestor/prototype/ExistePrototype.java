package gestor.prototype;

import gestor.almacen.Trama;
import gestor.gestor.Almacen;
import gestor.gestor.Servidor;

public class ExistePrototype extends Operador {
	
	public ExistePrototype(Almacen almacen, Servidor servidor) {
		super(almacen, servidor);
	}
	
	@Override
	public void ejecutar() {
		try {
			int codigo = Integer.parseInt(servidor.leer());
			int cantidad = Integer.parseInt(servidor.leer());
			servidor.escribir(Trama.ACK.name());
			servidor.escribir(almacen.existe(codigo, cantidad));
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Operador clone() {
		return new ExistePrototype(almacen, servidor);
	}

}

