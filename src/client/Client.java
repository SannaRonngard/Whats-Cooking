package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
		
	public static void main (String[]args) throws UnknownHostException, IOException{
		int number, temp;
		
		Scanner sc = new Scanner (System.in);
		Socket simpleSocket = new Socket("127.0.0.1",1342);
		Scanner sc1 = new Scanner (simpleSocket.getInputStream());
		System.out.println("Enter any number");
		number = sc.nextInt();
		PrintStream ps = new PrintStream(simpleSocket.getOutputStream());
		ps.println(number);
		temp = sc1.nextInt();
		System.out.println(temp);

}
}
