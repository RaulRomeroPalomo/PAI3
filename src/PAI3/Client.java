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
		System.setProperty("javax.net.ssl.trustStore", "cert.store");
		Socket socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost", 4444);
		//Recibir lo que venga del servidor
		BufferedReader socketbufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//Mensajero que lleva mensajes al servidor
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		//Recoge lo que escribas en la consola
		BufferedReader commandPromptBufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter your username: ");
		//Envia al servidor el username que has escrito
		printWriter.println(commandPromptBufferedReader.readLine());
		System.out.println("Please enter your password: ");
		//Envia al servidor la password que has escrito
		printWriter.println(commandPromptBufferedReader.readLine());
		System.out.println("Please enter the secret message: ");
		//Envia al servidor el mensaje secreto que has escrito
		printWriter.println(commandPromptBufferedReader.readLine());
		System.out.println(socketbufferedReader.readLine());
		System.out.println(socketbufferedReader.readLine());
//		while (true) {
//			System.out.println("Please enter a message to send to server: ");
//			message = commandPromptBufferedReader.readLine();
//			if(message.equals("quit")) {
//				socket.close();
//				break;
//			}
//			printWriter.println(message);
//			System.out.print("Message reply from server: ");
//			//printea el mensaje que has enviado
//			System.out.println(socketbufferedReader.readLine());
	}
}
