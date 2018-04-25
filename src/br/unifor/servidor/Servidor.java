package br.unifor.servidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.Scanner;

import br.unifor.controle.Controle;


public class Servidor {

	public static Socket cliente;
	private static int porta = 2121;
	static ServerSocket servidor;
	public static Controle control;
	private static Thread thread;
	
	

	public Servidor(Controle controle) {
		this.control = controle;
		iniciaServicos(cliente);	
	}
	
	public void adicionaConexao(Socket cliente) {
		control.adicionaConexao(cliente);
	}

	public void iniciaServicos(Socket c) {
		try {
			System.out.println("Servidor iniciado na porta: "+ porta);
			servidor = new ServerSocket(porta);

			RecebeConexaoServidor recebeConexao= new RecebeConexaoServidor(this);
			
			thread = new Thread(recebeConexao);
			thread.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Socket getCliente() {
		return cliente;
	}



	public static void setCliente(Socket cliente) {
		Servidor.cliente = cliente;
	}



	public static int getPorta() {
		return porta;
	}



	public static void setPorta(int porta) {
		Servidor.porta = porta;
	}



	public static ServerSocket getServidor() {
		return servidor;
	}



	public static void setServidor(ServerSocket servidor) {
		Servidor.servidor = servidor;
	}



}
