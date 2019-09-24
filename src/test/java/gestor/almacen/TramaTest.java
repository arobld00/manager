package gestor.almacen;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class TramaTest {
	
	@Test(expected = AssertionError.class)
	public void testTramaWithNullError() {
		Trama.conversor(null);
	}
	
	@Test
	public void testGetTrama() {
		assertThat(Trama.conversor(Trama.AGREGAR.name()), is(Trama.AGREGAR));
	}

}
