package gestor.almacen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class AlmacenLocalTest {
	
	private AlmacenLocal almacen;
	
	@Before
	public void before() {
		almacen = new AlmacenLocal();
	}
	
	@Test
	public void testAlmacenLocal() {
		almacen.agregar(1, 1);
		assertTrue(almacen.existe(1, 1));
		almacen.agregar(1, 3);
		assertTrue(almacen.existe(1, 4));
		almacen.retirar(1, 2);
		assertTrue(almacen.existe(1, 2));
		almacen.retirar(1, 1);
		assertTrue(almacen.existe(1, 1));
		almacen.retirar(1, 1);
		assertFalse(almacen.existe(1, 0));
	}
	
	@Test
	public void testObtenerInventario() {
		almacen.agregar(1, 1);
		assertThat(almacen.obtenerInventario(1), is(1));
		almacen.agregar(1, 1);
		assertThat(almacen.obtenerInventario(1), is(2));
		almacen.retirar(1, 1);
		assertThat(almacen.obtenerInventario(1), is(1));
	}
	
	

}
