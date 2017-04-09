package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[]args) throws IOException{
		
		int number, temp;
		ServerSocket serverSocket = new ServerSocket(1342);
		Socket simpleSocket = serverSocket.accept();
		Scanner scan = new Scanner (simpleSocket.getInputStream());
		number = scan.nextInt();
		
		temp=number*2;
		
		PrintStream pS = new PrintStream(simpleSocket.getOutputStream());
		pS.println(temp);
		
	}

}
