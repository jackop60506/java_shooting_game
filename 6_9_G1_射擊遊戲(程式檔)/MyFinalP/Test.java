 
import javax.imageio.ImageIO;
//hashp map �� python ��diciotnaray
//enum �� �C�| �ѨM����P�_�����ҩw�q���@
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
//add listener to component (keybinding)
//use timer
//enum �O public static final �� �C�| �ѨM����P�_�����ҩw�q���@ �ŧi�覡 enum XXX{A,B,C,D;..��Ʀ����F ��k}
//�]��V dir -> setkeybinding
public class Test extends JPanel{
	public HashMap<Direction,Boolean> dirmap= new HashMap<Direction,Boolean>();
	public BufferedImage img=null;
	public int PlayerX,PlayerY;
	private int w;
	private int h;
	public enum Direction {
		UP(KeyEvent.VK_UP,0,-1),
		DOWN(KeyEvent.VK_DOWN,0,1),
		EAST(KeyEvent.VK_RIGHT,1,0),
		WEST(KeyEvent.VK_LEFT,-1,0);
		private int key;
		private int X;
		private int Y;
		
		private Direction(int k, int x,int y){
			this.key=k;
			this.X=x;
			this.Y=y;
		}
		public int getKey(){
			return key;
		}
		public int getX(){
			return X;
		}
		public int getY(){
			return Y;
		}
		
	}
	
	public Test(){
		PlayerX=0;
		PlayerY=0;
		w=100;
		h=100;
		try{
		img = ImageIO.read(new File("C:/Users/jackop60506/Desktop/1.png"));
		}catch(Exception e){
			
		}
		for(Direction d:Direction.values()){
			dirmap.put(d, false);
		}
		setKeybindings();
		Timer timer = new Timer(40,new TimerListen());
		timer.start();
	}
	public void setKeybindings(){
		//inputmap �ت��N KeyStroke ���@�ӹ�H
		InputMap inm =getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap acm=getActionMap();
		for(final Direction d:Direction.values()){
			//KeyStroke �w�� press release
			//acm �w��W�r���� method
			KeyStroke press =KeyStroke.getKeyStroke(d.getKey(),0,false);
			KeyStroke release =KeyStroke.getKeyStroke(d.getKey(),0,true);
			inm.put(press,d.toString()+":press");
			inm.put(release,d.toString()+":release");
			
			acm.put(d.toString()+":press",  new AbstractAction() {
				
				public void actionPerformed(ActionEvent e){
					
					dirmap.put(d, true);
				}
			});
			acm.put(d.toString()+":release",new AbstractAction(){
				public void actionPerformed(ActionEvent e){
					dirmap.put(d, false);
				}
			});
			//acm.put(d.toString()+":release", arg1);
		}
	}
	//�p�ɾ��ӭ��ư��� �Yaction
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println(PlayerX);
		
		g.drawImage(img, 0, 0, null);
		g.drawRect(PlayerX, PlayerY, 100, 100);
	}
	private class TimerListen implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			boolean move =false;
			for(Direction d :Direction.values()){
				
				if(dirmap.get(d)){
					
					PlayerX=PlayerX+d.getX()*5;
					PlayerY=PlayerY+d.getY()*5;
					move=true;
				}
				
			}
			if(move){
				int x=PlayerX-2*5;
				int y=PlayerY-2*5;
				
				Test.this.repaint(x,y,100,100);
			}
		}
	}
	
	public static void createAndShowUI(){
		JFrame frame = new JFrame("Main Frame");
		
		frame.getContentPane().add(new Test());
		frame.setLocation(0, 580);
		frame.setPreferredSize(new Dimension(300,500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		/*
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<100;i++){
			map.put("i:"+i, i);
		}		
		for(String key: map.keySet()){
			System.out.println(map.get(key));
		}
		*/
		System.out.println(Direction.values().length);
		
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
        
    }
}
