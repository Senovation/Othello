import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player;
	private boolean isLoop; // 현재곡이 무한반복인지 아닌지
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() { // 현재실행되고 있는 음악이 어디위치에 실행되고 있는지 
		if(player == null) return 0;
		return player.getPosition();
	}
	public void close() { // 언제든지 곡을 끌수있게
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 쓰레드를 중지상태로 만듬
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
