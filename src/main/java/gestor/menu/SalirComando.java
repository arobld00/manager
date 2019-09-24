package gestor.menu;

public class SalirComando extends Comando {

	private boolean cerrado;
	
	public SalirComando() {
		super("Salir.");
		this.reiniciar();
	}

	@Override
	public void ejecutar() {
		cerrado = true;
	}

	public boolean estado() {
		return cerrado;
	}
	
	public void reiniciar() {
		cerrado = false;
	}
}
