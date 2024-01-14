package A0_P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import A0_P2.ProtocolPhases;

public class EchoClient {

	public static void main(String[] args) {
		String hostName = "localhost";
		int portNumber = 60009;
		try (Socket echoSocket = new Socket(hostName, portNumber);
				SocketInterface SI = new SocketInterface(echoSocket);
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
			SI.Receive(ProtocolPhases.WELCOME);
			SI.send(ProtocolPhases.HI);
			SI.sendReceive(ProtocolPhases.BBYE, ProtocolPhases.KTHXBYE);
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
