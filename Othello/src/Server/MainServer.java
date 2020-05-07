package Server;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		OutputStream output = null;
		try {
			server = new ServerSocket(8989);
			client = server.accept();
			
			output = client.getOutputStream();
			
			String message = "¼­¹ö Welcome";
			output.write(message.getBytes());
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {if(server != null) server.close();} catch(Exception e) {}
			try {if(client != null) client.close();} catch(Exception e) {}
			System.out.println("¼­¹ö ´ÝÈû");
		}
	}
}
