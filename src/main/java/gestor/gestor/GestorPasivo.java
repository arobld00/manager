/**
 * @author Alberto Robles
 *
 * modified last on 2019-06-16 00:28:25.690
 */

package gestor.gestor;

import gestor.almacen.AlmacenProxy;
import gestor.menu.Menu;
import gestor.menu.MenuRemoto;

public class GestorPasivo extends Gestor {

	@Override
	protected Almacen instance() {
		return new AlmacenProxy();
	}

	@Override
	protected Menu getMenu() {
		return new MenuRemoto();
	}
	
	@Override
	public void administrar() {
		super.administrar();
		((AlmacenProxy) almacen).desconectar();
	}
	
	public static void main(String[] args) {
		new GestorPasivo().administrar();
	}

}
