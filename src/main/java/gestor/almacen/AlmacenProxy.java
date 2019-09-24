package gestor.almacen;

import gestor.gestor.Almacen;

public class AlmacenProxy implements Almacen {
	
	private Estado estado;
	
	public AlmacenProxy() {
		try {
			estado = new EstadoProxy();
		} catch (Exception e) {
			estado = new EstadoLocal();
		}
	}

	@Override
	public void agregar(int codigo, int cantidad) {
		estado.agregar(codigo, cantidad);
		estado = estado.siguiente();
	}

	@Override
	public void retirar(int codigo, int cantidad) {
		estado.retirar(codigo, cantidad);
		estado = estado.siguiente();
	}

	@Override
	public boolean existe(int codigo, int cantidad) {
		boolean booleano = estado.existe(codigo, cantidad);
		estado = estado.siguiente();
		return booleano;
	}

	@Override
	public int[][] listar() {
		int[][] resultado = estado.listar();
		estado = estado.siguiente();
		return resultado;
	}
	
	public void desconectar() {
		estado.desconectar();
	}

}
