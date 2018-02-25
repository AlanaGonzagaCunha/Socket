import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente implements Runnable{

	private static Socket cliente;

	public Cliente(Socket c) {
		this.cliente = c;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("192.168.1.20", 8090);
		Cliente c = new Cliente(socket);
		Thread t = new Thread(c);
		t.start();

	}

	public void run() {

		try {

			PrintStream saida;
			System.out.println("O cliente conectou ao servidor  "+ cliente.getLocalSocketAddress());

			Scanner teclado = new Scanner(System.in);

			saida = new PrintStream(this.cliente.getOutputStream());
			
			System.out.println("\nEntre com uma mgs de txt: ");
			while (teclado.hasNextLine()) {
				saida.println(teclado.nextLine());
			}
			saida.close();
			teclado.close();
			this.cliente.close();
			System.out.println("Fim do cliente!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
