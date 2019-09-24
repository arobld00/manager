package gestor.almacen;

public class EstadoProxy implements Estado {
	
	private Cliente cliente;
	
	private int[][] buffer;
	
	private EstadoLocal estadoLocal;
	
	public EstadoProxy() throws Exception {
		cliente = new Cliente();
	}

	@Override
	public void agregar(int codigo, int cantidad) {
		try {
			cliente.enviar(Trama.AGREGAR.name());
			cliente.enviar(codigo);
			cliente.enviar(cantidad);
			cliente.ACK();
		} catch (Exception e) {
			estadoLocal = new EstadoLocal(buffer);
			estadoLocal.agregar(codigo, cantidad);
		}
	}

	@Override
	public void retirar(int codigo, int cantidad) {
		try {
			cliente.enviar(Trama.RETIRAR.name());
			cliente.enviar(codigo);
			cliente.enviar(cantidad);
			cliente.ACK();
		} catch (Exception e) {
			estadoLocal = new EstadoLocal(buffer);
			estadoLocal.retirar(codigo, cantidad);
		}
	}

	@Override
	public boolean existe(int codigo, int cantidad) {
		try {
			cliente.enviar(Trama.EXISTE.name());
			cliente.enviar(codigo);
			cliente.enviar(cantidad);
			cliente.ACK();
			return cliente.confirmacion();
		} catch (Exception e) {
			estadoLocal = new EstadoLocal(buffer);
			return estadoLocal.existe(codigo, cantidad);
		}
	}

	@Override
	public int[][] listar() {
		try {
			cliente.enviar(Trama.LISTAR.name());
			cliente.ACK();
			buffer = new int[0][2];
			int lineas = cliente.leer();
			buffer = new int[lineas][2];
			for(int i = 0; i < lineas; i++){
				buffer[i][0] = cliente.leer();
				buffer[i][1] = cliente.leer();
			}
			return buffer;
		} catch (Exception e) {
			estadoLocal = new EstadoLocal(buffer);
			return estadoLocal.listar();
		}
	}

	@Override
	public void desconectar() {
		cliente.desconectar();
	}

	@Override
	public Estado siguiente() {
		return (estadoLocal != null) ? estadoLocal : this;
	}

}
