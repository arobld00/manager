package gestor.almacen;

import java.util.HashMap;
import java.util.Map;

import gestor.gestor.Almacen;

public class AlmacenLocal implements Almacen {
	
	private Map<Integer, Articulo> articulos;
	
	private final static int MIN_CANTIDAD = 1;
	
	public AlmacenLocal() {
		articulos = new HashMap<Integer, Articulo>();
	}

	@Override
	public void agregar(int codigo, int cantidad) {
		Articulo articulo = articulos.get(codigo);
		if (articulo != null) {
			articulo.agregar(cantidad);
		} else {
			articulos.put(codigo, new Articulo(codigo, cantidad));
		}
	}

	@Override
	public void retirar(int codigo, int cantidad) {
		Articulo articulo = articulos.get(codigo);
		articulo.retirar(cantidad);
		if (!articulo.existe(MIN_CANTIDAD)) {
			articulos.remove(codigo);
		}
		
	}

	@Override
	public boolean existe(int codigo, int cantidad) {
		Articulo articulo = articulos.get(codigo);
		return (articulo != null)? articulo.existe(cantidad) : false;
	}

	@Override
	public int[][] listar() {
		int[][] lista = new int[articulos.values().size()][2];
		int i = 0;
		for (int codigo : articulos.keySet()) {
			lista[i][0] = codigo;
			lista[i][1] = articulos.get(codigo).cantidad();
			i++;
		}
		return lista;
	}

	public int obtenerInventario(int codigo) {
		Articulo articulo = articulos.get(codigo);
		return articulo.cantidad();
	}

}
