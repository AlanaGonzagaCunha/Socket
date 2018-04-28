package br.unifor.cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.unifor.controle.Controle;

public class RecebeConexaoCliente implements Runnable {

	private String ip;
	private int porta;
	private Controle controle;

	public RecebeConexaoCliente(String ip, int porta, Controle controle) {
		this.ip = ip;
		this.porta = porta;
		this.controle= controle;
	}

	@Override
	public void run() {

		try {
			Socket abreConexao= new Socket(this.ip, this.porta);
			System.out.println("Cliene conectado no servidor!!!");
			this.controle.adicionaConexao(abreConexao);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
