package gestor.almacen;

public class Pedido {
	
	private int codigo;
	
	private int cantidad;
	
	private boolean cumplimentada;
	
	public Pedido(int codigo, int cantidad) {
		this.codigo = codigo;
		this.cantidad = cantidad;
	}

	public void completar(AlmacenLocal almacen) {
		assert almacen != null;
		cumplimentada = almacen.obtenerInventario(codigo) >= cantidad;
		if (cumplimentada) {
			almacen.retirar(codigo, cantidad);
		}
	}
	
	public boolean cumplimentada() {
		return cumplimentada;
	}

}
