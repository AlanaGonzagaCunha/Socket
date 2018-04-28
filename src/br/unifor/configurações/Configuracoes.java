package br.unifor.configurações;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Configuracoes {
	private  int porta;
	private  String ip;

	public Configuracoes(int porta) {
		this.porta = porta;
		descobrirIpv4();
	}
	
	public void descobrirIpv4() {
		InetAddress iAddress;
		try {
			
			iAddress = InetAddress.getLocalHost();
			
			this.setIp(iAddress.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public int getPorta() {
		return porta;
	}

	public  void setPorta(int porta) {
		this.porta = porta;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
