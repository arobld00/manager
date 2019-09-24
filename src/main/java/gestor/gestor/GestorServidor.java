/**
 * @author Alberto Robles
 *
 * modified last on 2019-06-16 00:28:25.690
 */

package gestor.gestor;

import gestor.almacen.AlmacenLocal;
import gestor.almacen.Trama;
import gestor.prototype.OperadorPrototype;

public class GestorServidor {
	
	private Almacen almacen;
	
	private Servidor servidor;
	
	private OperadorPrototype operador;

	public GestorServidor() {
		almacen = new AlmacenLocal();
		servidor = new Servidor();
		operador = new OperadorPrototype(almacen, servidor);
	}
	
	private void ejecutar() {
		Trama trama = null;
		do {
			String linea = servidor.leer();
			System.out.println("acaba de llegar por socket: " + linea);
			trama = Trama.conversor(linea);
			if (trama != Trama.DESCONECTAR) {
				operador.ejecutar(trama);
			}
		} while(trama != Trama.DESCONECTAR);
		servidor.desconectar();
	}
	
	public static void main(String[] args) {
		new GestorServidor().ejecutar();
	}

}
