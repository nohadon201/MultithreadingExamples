package A0_P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hostName = "localhost";
		int portNumber = 60009;
		try (Socket echoSocket = new Socket(hostName, portNumber);
				SocketInterface SI = new SocketInterface(echoSocket);
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
			SI.Receive(ProtocolPhases.WELCOME);
			SI.send(ProtocolPhases.HI);
			boolean init=true;
			while (init) {
				int a = sc.nextInt();
				switch (a) {
				case 1:
					String temp = stdIn.readLine();
					if (!ProtocolPhases.BBYE.equals(temp)) {
						SI.send(temp);
						SI.Receive();
					} else {
						SI.send("BYE");
					}
					break;
				case 2:
					SI.sendReceive(ProtocolPhases.BBYE, ProtocolPhases.KTHXBYE);
					init=false;
					break;
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		} catch (NotMatchingTextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
