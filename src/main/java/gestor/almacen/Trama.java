package gestor.almacen;

public enum Trama {
	AGREGAR,
	EXISTE,
	LISTAR,
	RETIRAR,
	DESCONECTAR,
	ACK;
	
	public static Trama conversor(String string) {
		assert string != null;
		for(Trama trama: Trama.values()) {
			if (trama.name().equals(string)) {
				return trama;
			}
		}
		return null;
	}
	

}

