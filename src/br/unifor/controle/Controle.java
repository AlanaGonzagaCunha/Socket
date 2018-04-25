package br.unifor.controle;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import br.unifor.servidor.Servidor;

public class Controle {

	ArrayList<Socket> conexoes = new ArrayList<Socket>();

	public Controle() {
		Servidor servidor = new Servidor(this);
		
	}

	public void adicionaConexao(Socket con) {
		System.out.println("Nova conexão foi adionada: " + con.getInetAddress().getHostAddress());
		this.conexoes.add(con);
	}

//	public Boolean isConexao(String ip) {
//
//		for (Socket s : conexoes) {
//			if (s.getInetAddress().getHostAddress().equals(ip)) {
//				return true;
//			}
//		}
//		return false;
//	}

	public void enviaMessagem(String mgs) {
		System.out.println("Total de servidores conectados: " + this.conexoes.size());

		for (Socket c : conexoes) {
			try {
				System.out.println("Enviando messgens, para " + c.getInetAddress().getHostAddress());
				PrintStream ps = new PrintStream(c.getOutputStream());

				ps.println(mgs);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public ArrayList<Socket> getConexoes() {
		return conexoes;
	}

	public void setConexoes(ArrayList<Socket> conexoes) {
		this.conexoes = conexoes;
	}

}
