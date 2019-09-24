package gestor.almacen;

public interface Estado {
	
	void agregar(int codigo, int cantidad);
	
	void retirar(int codigo, int cantidad);
	
	boolean existe(int codigo, int cantidad);
	
	int[][] listar();
	
	void desconectar();
	
	Estado siguiente();

}
