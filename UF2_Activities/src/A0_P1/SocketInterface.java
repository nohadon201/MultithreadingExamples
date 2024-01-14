package A0_P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketInterface implements AutoCloseable {
	private PrintWriter out;
	private BufferedReader in;
	private boolean verbose;

	public SocketInterface(Socket socket) throws IOException {
		ini(socket);
		this.verbose = true;
	}

	public SocketInterface(Socket socket, boolean verbose) throws IOException {
		ini(socket);
		this.verbose = verbose;
	}

	public void ini(Socket socket) throws IOException {
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public void send(String text) {
		if(verbose) {
			System.err.println("######################## LOG_TEXT ### Sending: "+text);
		}
		this.out.println(text);
	}

	public String Receive() throws IOException {
		String text = this.in.readLine();
		if(verbose) {
			System.err.println("######################## LOG_TEXT ### receiving: "+text);
		}
		return text;
	}

	public String Receive(String text) throws NotMatchingTextException, IOException {

		String n = Receive();
		if (!n.equals(text)) {
			throw new NotMatchingTextException();
		}else {
			return n; 
		}
	}

	public void close() throws IOException {
		in.close();
		out.close();
	}
	public String sendReceive(String text) throws IOException {
		send(text);
		return Receive();
	}
	public void sendReceive(String req, String res) throws IOException, NotMatchingTextException {
		send(req);
		Receive(res);
	}
}
