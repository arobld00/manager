package gestor.comun;

public class Intervalo {
	
	private int min;
	
	private int max;
	
	public Intervalo(int min, int max) {
		assert min <= max;
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	public boolean incluye(int valor) {
		return min <= valor && valor <= max;
	}

}
