package gestor.almacen;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	private Socket socket;
	
	private PrintWriter escritura; 
	
	private BufferedReader lectura; 
	
	Cliente() throws Exception  {
		socket = new Socket("localhost", 2020);
		System.out.println("Cliente> Establecida conexion");
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream(); 
		escritura = new PrintWriter(out); 
		lectura = new BufferedReader(new InputStreamReader(in));
	}
	
	void enviar(String valor){
		assert valor != null;
		escritura.println(valor);
		escritura.flush();
	}
	
	void enviar(int valor){
		this.enviar("" + valor);
	}
	
	boolean confirmacion() throws Exception {
		return Boolean.parseBoolean(lectura.readLine());
	}
	
	int leer() throws Exception  {
		return Integer.parseInt(lectura.readLine());
	}
	
	void ACK() throws Exception {
		if (!lectura.readLine().equals(Trama.ACK.name())) 
		throw new Exception();
	}
	
	void desconectar() {
		try {
			this.enviar(Trama.DESCONECTAR.name());
			lectura.close();
			escritura.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
