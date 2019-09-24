package gestor.comun;

public class IntervaloVista {
	
	private String titulo;
	
	private Intervalo intervalo;
	
	public IntervaloVista(String titulo, Intervalo intervalo) {
		assert titulo != null;
		assert intervalo != null;
		this.titulo = titulo;
		this.intervalo = intervalo;
	}
	
	@Override
	public String toString() {
		return "[" + intervalo.getMin() + ", " + intervalo.getMax() + "]";
	}

	public void escribir() {
		IO.instance().writeln(titulo + " " + this.toString());
	}

}
