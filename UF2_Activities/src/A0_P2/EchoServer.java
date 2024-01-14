package A0_P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 60009;

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(PORT);
				Socket clientSocket = serverSocket.accept();
				SocketInterface SI = new SocketInterface(clientSocket);) {
			System.out.println("Connection stablished at port " + clientSocket.getPort() + " and local port "
					+ clientSocket.getLocalPort());
			SI.sendReceive(ProtocolPhases.WELCOME,ProtocolPhases.HI);
			String response=SI.Receive();
			while(!response.contains("BBYE")) {
				SI.send(response);
				response = SI.Receive();
			}
			SI.send(ProtocolPhases.KTHXBYE);
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + PORT + " or listening for a connection");
			System.out.println(e.getMessage());
		} catch (NotMatchingTextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
