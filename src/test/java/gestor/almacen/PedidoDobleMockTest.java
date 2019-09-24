package gestor.almacen;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.*;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class PedidoDobleMockTest {
	
	private int codigo;
	
	private int cantidad;
	
	@Mocked
	private AlmacenLocal almacen;
	

	
	@Test
	public void testFillingRemovesInventoryIfInStock() {
		codigo = 1;
		cantidad = 1;
		Pedido pedido = new Pedido(codigo, cantidad);
		new Expectations() {{
				almacen.obtenerInventario(codigo); result = cantidad;
			}};
		pedido.completar(almacen);
		new Verifications() {{
			almacen.obtenerInventario(codigo); times=1;
			almacen.retirar(codigo, cantidad); times=1;
		}};
	}

}
