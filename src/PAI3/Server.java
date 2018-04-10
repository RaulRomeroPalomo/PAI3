package PAI3;

import java.io.IOException;
import java.net.ServerSocket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

import PAI3.ServerThread;

public class Server {

	public static void main(String[] args) throws IOException {
		System.setProperty("javax.net.ssl.keyStore", "cert.store");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(4444);
		String[] cipherSuites = {"TLS_RSA_WITH_AES_128_CBC_SHA", 
				"TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
				"TLS_DHE_DSS_WITH_AES_128_CBC_SHA",
				"SSL_RSA_WITH_3DES_EDE_CBC_SHA"};
		serverSocket.setEnabledCipherSuites(cipherSuites);
		System.out.println("Server up & ready for connections....");
		while (true) new ServerThread(serverSocket.accept()).start();
	}

}
