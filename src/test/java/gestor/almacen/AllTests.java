package gestor.almacen;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TramaTest.class,
	AlmacenLocalTest.class,
	PedidoDobleStubTest.class,
	PedidoDobleMockTest.class
})
public class AllTests {

}
