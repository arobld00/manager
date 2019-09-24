package gestor.gestor;

public interface Almacen {
	
	void agregar(int codigo, int cantidad);
	
	void retirar(int codigo, int cantidad);
	
	boolean existe(int codigo, int cantidad);
	
	int[][] listar();

}
