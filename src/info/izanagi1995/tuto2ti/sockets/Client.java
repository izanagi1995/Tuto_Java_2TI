package info.izanagi1995.tuto2ti.sockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	private static final int PORT = 6666;
	
	public static void main(String[] args) {
		new Client();
	}
	
	public Client(){
		try {
			Socket s = new Socket(InetAddress.getByName("localhost"), PORT);
			
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter w = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
			
			ClientThread clientThread = new ClientThread(w, r);
			new Thread(clientThread).start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class ClientThread implements Runnable{
		
		private PrintWriter w;
		private Scanner scanner;
		private BufferedReader r;

		public ClientThread(PrintWriter w, BufferedReader r) {
			this.w = w;
			this.r = r;
			this.scanner = new Scanner(System.in);
		}

		@Override
		public void run() {
			while(true){
				String line = this.scanner.nextLine();
				w.println(line);
				try {
					System.out.println(r.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
