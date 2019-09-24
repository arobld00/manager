package gestor.menu;

public class MenuLocal extends Menu {

	@Override
	protected void setComandos() {
		listaComandos.add(new AgregarCantidadComando());
		listaComandos.add(new RetirarCantidadComando());
		listaComandos.add(new RealizarPedidoComando());
	}

}
