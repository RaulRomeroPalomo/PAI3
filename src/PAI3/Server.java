package PAI3;

import java.io.IOException;
import java.net.ServerSocket;

import javax.net.ssl.SSLServerSocketFactory;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("javax.net.ssl.keyStore", "cert.store");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		ServerSocket serverSocket = ((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(4444);
		System.out.println("Server up & ready for connections....");
		while (true) new ServerThread(serverSocket.accept()).start();
	}

}
