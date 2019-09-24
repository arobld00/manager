package gestor.almacen;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;


import mockit.*;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class PedidoDobleStubTest {
	
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
		assertTrue(pedido.cumplimentada());
	}
	
	@Test
	public void testFillingRemovesIfNotEnoughInStock() {
		codigo = 1;
		cantidad = 2;
		Pedido pedido = new Pedido(codigo, cantidad);
		new Expectations() {{
			almacen.obtenerInventario(codigo); result = cantidad-1;
			}};
			pedido.completar(almacen);
		assertFalse(pedido.cumplimentada());
	}

}
