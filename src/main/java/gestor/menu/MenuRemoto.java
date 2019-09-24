package gestor.menu;

public class MenuRemoto extends Menu {

	@Override
	protected void setComandos() {
		listaComandos.add(new AgregarCantidadComando());
		listaComandos.add(new RetirarCantidadComando());
	}

}
