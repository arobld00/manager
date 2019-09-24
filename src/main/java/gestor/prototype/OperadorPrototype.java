package gestor.prototype;

import java.util.HashMap;
import java.util.Map;

import gestor.almacen.Trama;
import gestor.gestor.Almacen;
import gestor.gestor.Servidor;

public class OperadorPrototype {
	
	private Map<Trama, Operador> operadores;
	
	public OperadorPrototype(Almacen almacen, Servidor servidor) {
		operadores = new HashMap<Trama, Operador>();
		operadores.put(Trama.AGREGAR, new AgregarCantidadPrototype(almacen, servidor));
		operadores.put(Trama.RETIRAR, new RetirarCantidadPrototype(almacen, servidor));
		operadores.put(Trama.EXISTE, new ExistePrototype(almacen, servidor));
		operadores.put(Trama.LISTAR, new ListarPrototype(almacen, servidor));
	}
	
	public void ejecutar(Trama trama) {
		operadores.get(trama).clone().ejecutar();
	}

}
