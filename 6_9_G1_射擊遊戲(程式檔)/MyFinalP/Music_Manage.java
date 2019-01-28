 

import java.io.File;
import java.io.FileInputStream;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class Music_Manage {
	FileInputStream fis ;
	Player p;
	Music_Manage me;
	static String path ="src/sounds/";
	static String filetype=".mp3";
	MP3Player player;
	MP3Player player2;
	MP3Player player3;
	MP3Player player4;

	int ran;
	
	public Music_Manage(){
		 player = new MP3Player();
		 player2 = new MP3Player();
		 player3 = new MP3Player();
		 player4 = new MP3Player();

			player.addToPlayList(new File("sounds/background3.mp3"));//normal
			player2.addToPlayList(new File("sounds/background4.mp3"));//boss
			player3.addToPlayList(new File("sounds/background2.mp3"));//title
			player4.addToPlayList(new File("sounds/background1.mp3"));//title

			//player.addToPlayList(new File("sounds/background2.mp3"));
		    //player.addToPlayList(new File("sounds/background3.mp3"));
		    //player.addToPlayList(new File("sounds/background4.mp3"));
	}
	public void playhurt(){
		new MP3Player(new File("sounds/damage7.mp3")).play();
	}
	public void playitem(){
		new MP3Player(new File("sounds/item.mp3")).play();
	}
	public void playboom(){
		new MP3Player(new File("sounds/explosion1.mp3")).play();
	}
	public void playshoot(){
		
		new MP3Player(new File("sounds/laser2.mp3")).play();
		
	}
	public void playBossBoom(){
		
		new MP3Player(new File("sounds/destruction1.mp3")).play();
		
	}
	public void playexplore(){
		new MP3Player(new File("sounds/laser2.mp3")).play();
	}
	public void playbackground(int tag){
		
		switch(tag){
			case 0:
				player3.stop();
				player2.stop();
				player4.stop();

				player.play();
				player.setRepeat(true);
				break;
			case 1:
				player.stop();
				player3.stop();
				player4.stop();

				player2.play();
				player2.setRepeat(true);
				break;
			case 2:
				player2.stop();
				player.stop();
				player4.stop();

				player3.play();
				player3.setRepeat(true);
				break;
			case 3:
				player2.stop();
				player.stop();
				player3.stop();
				
				player4.play();
				player4.setRepeat(true);
				break;
		}
		
		
		
	}
}
