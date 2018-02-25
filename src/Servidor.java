import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.Scanner;

public class Servidor implements Runnable {

	public static Socket cliente;
	private static int porta = 8090;

	public Servidor(Socket c) {
		this.cliente = c;
	}

	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(porta);

		System.out.println("Iniciando na porta: " + porta);

		System.out.println("Aguardando conexões com o cliente... ");

		while (true) {
			Socket cliente = servidor.accept();
			Servidor server = new Servidor(cliente);

			Thread t = new Thread(server);
			t.start();

		}
	}

	public void run() {
		System.out.println(
				"Uma nova conexão encontrada: Cliente IP: " + cliente.getInetAddress().getHostAddress() + "\n");

		try {
			Scanner s = null;
			s = new Scanner(this.cliente.getInputStream());

			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}

			s.close();
			this.cliente.close();
			System.out.println("Conexões fechada... ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
