package gestor.almacen;

import gestor.comun.PreguntaVista;

public class EstadoLocal implements Estado {
	
	private AlmacenLocal almacen;
	
	public EstadoLocal() {
		almacen = new AlmacenLocal();
	}
	
	public EstadoLocal(int[][] buffer) {
		this();
		for (int[] articulo : buffer) {
			almacen.agregar(articulo[0], articulo[1]);
		}
	}

	@Override
	public void agregar(int codigo, int cantidad) {
		almacen.agregar(codigo, cantidad);
	}

	@Override
	public void retirar(int codigo, int cantidad) {
		almacen.retirar(codigo, cantidad);
	}

	@Override
	public boolean existe(int codigo, int cantidad) {
		return almacen.existe(codigo, cantidad);
	}

	@Override
	public int[][] listar() {
		return almacen.listar();
	}

	@Override
	public void desconectar() {
		boolean salir;
		do {
			System.out.println("Sin conexión al servidor, los datos se perderán");
			salir = PreguntaVista.instance().leer("Abandonar? ");
			if (!salir) {
				try {
					EstadoProxy estadoProxy = new EstadoProxy();
					int[][] lista = almacen.listar();
					for (int[] articulo : lista) {
						estadoProxy.agregar(articulo[0], articulo[1]);
					}
					salir = true;
					System.out.println("Datos almacenados en servidor!");
					estadoProxy.desconectar();		
				} catch (Exception e) {
				}
			}
							
		} while (!salir);
	}

	@Override
	public Estado siguiente() {
		try {
			EstadoProxy estadoProxy = new EstadoProxy();
			int[][] lista = almacen.listar();
			for (int[] articulo : lista) {
				estadoProxy.agregar(articulo[0], articulo[1]);
			}
			return estadoProxy;
		} catch (Exception e) {
			return this;
		}
	}

}
