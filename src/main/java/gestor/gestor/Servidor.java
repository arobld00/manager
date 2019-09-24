package gestor.gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import gestor.comun.IO;

public class Servidor {
	
	private ServerSocket servidor;
	
	private Socket socket;
	
	private PrintWriter escritura; 
	
	private BufferedReader lectura; 
	
	public Servidor() {
		try {
			servidor = new ServerSocket(2020);
			IO.instance().writeln("Servidor> Esperando conexión...");
			socket = servidor.accept();
			IO.instance().writeln(
					"Servidor> Recibida conexion de "
							+ socket.getInetAddress().getHostAddress() + ":"
							+ socket.getPort());
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream(); 
			escritura = new PrintWriter(out); 
			lectura = new BufferedReader(new InputStreamReader(in));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void desconectar() {
		try {
			lectura.close();
			escritura.close();
			socket.close();
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String leer() {
		String linea = null;
		try {
			linea = lectura.readLine();
		} catch (IOException e) {
			System.out.println("Error en servidor!!! Lectura de string");
		}
		return linea;
	}
	
	public void escribir(int valor) {
		escritura.println("" + valor);
		escritura.flush();
	}
	
	public void escribir(boolean valor) {
		escritura.println("" + valor);
		escritura.flush();
	}
	
	public void escribir(String valor) {
		escritura.println(valor);
		escritura.flush();
	}
	
	

}
