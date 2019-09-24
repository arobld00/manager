package gestor.menu;

import gestor.almacen.AlmacenLocal;
import gestor.almacen.Pedido;
import gestor.comun.Dialogo;

public class RealizarPedidoComando extends Comando {
	
	public RealizarPedidoComando() {
		super("Realizar pedido.");
	}

	@Override
	public void ejecutar() {
		int codigo = Dialogo.instance().read("¿Código? ", 100);
		int cantidad = Dialogo.instance().read("¿Cantidad? ", 100);
		try {
			new Pedido(codigo, cantidad);
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

}
