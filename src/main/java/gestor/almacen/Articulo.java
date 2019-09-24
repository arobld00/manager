package gestor.almacen;

public class Articulo {

	private int codigo;
	
	private int cantidad;
	
	public Articulo(int codigo, int cantidad) {
		this.codigo = codigo;
		this.cantidad = cantidad;
	}
	
	public void agregar(int cantidad) {
		this.cantidad = this.cantidad + cantidad;
	}
	
	public void retirar(int cantidad) {
		this.cantidad = this.cantidad - cantidad;
	}
	
	public boolean existe(int cantidad) {
		return this.cantidad >= cantidad;
	}
	
	public int cantidad() {
		return this.cantidad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", cantidad=" + cantidad + "]";
	}

}