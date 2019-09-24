package gestor.comun;

public class Dialogo {
	
	private static Dialogo dialogo;

	public static Dialogo instance() {
		if (dialogo == null) {
			dialogo = new Dialogo();
		}
		return dialogo;
	}

	private Dialogo() {

	}
	
	public int leer(String titulo, int min, int max) {
		assert titulo != null;
		Intervalo limite = new Intervalo(min, max);
		IntervaloVista limiteVista = 
				new IntervaloVista(
						"El valor debe estar entre ",
						limite);
		int valor;
		boolean ok;
		do {
			valor = IO.instance().readInt(titulo + " " + limiteVista + ": ");
			ok = limite.incluye(valor);
			if (!ok) {
				limiteVista.escribir();
			}
		} while (!ok);
		return valor;
	}

	public int read(String titulo, int max) {
		return this.leer(titulo, 1, max);
	}

}
