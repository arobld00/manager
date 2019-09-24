/**
 * @author Alberto Robles
 *
 * modified last on 2019-06-16 00:28:25.690
 */

package gestor.gestor;

import gestor.almacen.AlmacenLocal;
import gestor.menu.Menu;
import gestor.menu.MenuLocal;

public class GestorActivo extends Gestor {

	@Override
	protected Almacen instance() {
		return new AlmacenLocal();
	}
	
	@Override
	protected Menu getMenu() {
		return new MenuLocal();
	}
	
	public static void main(String[] args) {
		new GestorActivo().administrar();
	}

}
