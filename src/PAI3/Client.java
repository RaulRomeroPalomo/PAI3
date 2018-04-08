package PAI3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("javax.net.ssl.trustStore", "cert.store");
		Socket socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost", 4444);
		BufferedReader socketbufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader commandPromptBufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter a username: ");
		printWriter.println(commandPromptBufferedReader.readLine());
		String message = null;
		while (true) {
			System.out.println("Please enter a message to send to server: ");
			message = commandPromptBufferedReader.readLine();
			if(message.equals("quit")) {
				socket.close();
				break;
			}
			printWriter.println(message);
			System.out.print("Message reply from server: ");
			System.out.println(socketbufferedReader.readLine());
		}
	}

}
