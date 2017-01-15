package info.izanagi1995.tuto2ti.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	
	private static final int PORT = 6666;
	
	public static void main(String[] args) {
		new Serveur();
	}

	private ServerSocket serveurSocket;
	
	public Serveur(){
		try {
			this.serveurSocket = new ServerSocket(PORT);
			while(true){
				Socket c = this.serveurSocket.accept();
				Repondre rep = new Repondre(c);
				new Thread(rep).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class Repondre implements Runnable{
		
		Socket client;
		
		public Repondre(Socket client){
			this.client = client;
		}

		@Override
		public void run() {
			try {
				String ligne = "";
				boolean run = true;
				while(run){
					BufferedReader r = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
					PrintWriter w = new PrintWriter(new OutputStreamWriter(this.client.getOutputStream()), true);
					ligne = r.readLine();
					if(ligne.equals("Bonjour")){
						w.println("Salut!");
					}else if(ligne.equals("A+")){
						run = false;
					}else{
						w.println("J'ai pas bien compris");
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
