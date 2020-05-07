package Server;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MainClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream input;
		
		try {
			socket = new Socket("172.22.237.78",8989);
			
			input = socket.getInputStream();
			
			byte[] receiveBuffer = new byte[100];
			input.read(receiveBuffer);
			
			System.out.println(new String(receiveBuffer));
				
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {if(socket != null) socket.close();} catch(Exception e) {}
		}
	}
}
