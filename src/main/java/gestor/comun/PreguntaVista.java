package gestor.comun;

public class PreguntaVista {
	
	private static PreguntaVista preguntaVista;
	
	public static PreguntaVista instance() {
		if (preguntaVista == null) {
			preguntaVista = new PreguntaVista();
		}
		return preguntaVista;
	}
	
	private PreguntaVista() {
	}
	
	public boolean leer(String pregunta) {
		assert pregunta != null;
		char respuesta;
		boolean ok;
		do {
			respuesta = IO.instance().readChar(pregunta + "? (s/n): ");
			ok = respuesta == 's' || respuesta == 'S' || respuesta == 'n'
					|| respuesta == 'N';
			if (!ok) {
				IO.instance().writeln("El valor debe ser 's' o 'n'");
			}
		} while (!ok);
		return respuesta == 's' || respuesta == 'S';
	}

}
