package gestor.prototype;

import gestor.almacen.Trama;
import gestor.gestor.Almacen;
import gestor.gestor.Servidor;

public class ListarPrototype extends Operador {
	
	public ListarPrototype(Almacen almacen, Servidor servidor) {
		super(almacen, servidor);
	}

	@Override
	public void ejecutar() {
		int[][] resultado = almacen.listar();
		servidor.escribir(Trama.ACK.name());
		servidor.escribir(resultado.length);
		for(int[] articulo : resultado) {
			servidor.escribir(articulo[0]);
			servidor.escribir(articulo[1]);
		}
	}

	@Override
	public Operador clone() {
		return new ListarPrototype(almacen, servidor);
	}

}