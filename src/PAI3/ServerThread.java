package PAI3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServerThread extends Thread {
	
	Socket socket;
	ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
			
			File secretFile = new File("secretMessages");
			
			List<String> userList = new ArrayList<String>();
			userList.add("userInformation1");
			userList.add("userInformation2");
			userList.add("userInformation3");
			
			//open printwriter for writing data to client
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			
			//open buffered reader for reading data from client
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String username = bufferedReader.readLine();
			String password = bufferedReader.readLine();
			String secret = bufferedReader.readLine();
			int i = 0;
			
			for(String user: userList) {
				File file = new File(user);
				Scanner input = new Scanner(file);
				List<String> list = new ArrayList<String>();
				while (input.hasNextLine()) {
				    list.add(input.nextLine());
				}
				if(username.equals(list.get(0)) && password.equals(list.get(1))) {
					System.out.println("Username and password '"+ username + "' '" + password +"' received correctly and confirmed");
					System.out.println("Your secret message will be saved");
					printWriter.println("Username and password '"+ username + "' '" + password +"' received correctly and confirmed");
					printWriter.println("Your secret message will be saved");
					FileWriter fw = new FileWriter(secretFile.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(username + ": ");
			        bw.write(secret + "\n");
			        bw.close();
				}else {
					i++;
				}
			}
			if(i == 3) {
				System.out.println("Wrong username or password");
				printWriter.println("Wrong username or password");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
