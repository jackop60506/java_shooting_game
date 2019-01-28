 
import java.awt.*;
/*
 ä¸??‹InputMapå°‡ä??‹Keystrokeå°æ?‰åˆ°ä¸??‹å?è±¡ï¼?
 ActionMapå°‡ä??‹å?è±¡å°æ?‰åˆ°ä¸??‹è?Œçˆ²ï¼ˆActionï¼‰ã??
 ?šå¸¸InputMapä¸­KeyStroke??å°æ?‰ç?„å?è±¡?˜¯ä¸??‹å?—ç¬¦ä¸²ï??
 ?šé?é?™å?‹å?—ç¬¦ä¸²å¯ä»¥åœ¨ActionMapä¸­æŸ¥?‰¾?ˆ°?›¸??‰ç?„è?Œçˆ²
 */
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

public class View{
	JFrame jframe;
	PaintPanel paint_p;
	ControlPanel control_p;
	Controller ctl;
	HashMap<Direction,Boolean> dirmap = new HashMap<Direction,Boolean>();
	HashMap<Plane_skill,Boolean> planeskillmap = new HashMap<Plane_skill,Boolean>();
	HashMap<Enum_gamekey,Boolean> gamekeymap = new HashMap<Enum_gamekey,Boolean>();

	public JButton b1,b2,b3;
	public JLabel t1,t2;
	Timer timer;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double screen_width = screenSize.getWidth();
	double screen_height = screenSize.getHeight();
	
	double background_moveX=-10;
	double background_moveY=-10;
	public static final int FRAME_WIDTH= 600;
	public static final int FRAME_HEIGHT=950;
	public static final int PAINT_WIDTH=600;
	public static final int PAINT_HEIGHT=850;
	public static final int CONTROL_WIDTH=600;
	public static final int CONTROL_HEIGHT=100;
	public View(Controller c){
		
		ctl=c;
		jframe= new JFrame();
		paint_p= new PaintPanel();
		control_p= new ControlPanel();
		
		jframe.getContentPane().setLayout(new BoxLayout(jframe.getContentPane(),BoxLayout.Y_AXIS));
		jframe.setLocation((int)(screen_width-FRAME_WIDTH)/2,(int)(screen_height-FRAME_HEIGHT)/2-60); 
		paint_p.setPreferredSize(new Dimension(PAINT_WIDTH,PAINT_HEIGHT));
		 
		 //paint_p.setBorder(BorderFactory.createTitledBorder("Paint"));
		 
		 paint_p.setFocusable(true);
		 paint_p.requestFocusInWindow();
		   
		 control_p.setPreferredSize(new Dimension(CONTROL_WIDTH,CONTROL_HEIGHT));
		 control_p.setBorder(BorderFactory.createTitledBorder("ControlButton"));
		   
		jframe.getContentPane().add(paint_p);
		jframe.getContentPane().add(control_p);
			
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setVisible(true);
	}
	public void refresh(){
		
		paint_p.repaint();
	}
	public void setdelay(int x){
		timer.stop();
		timer.setDelay(x);
		timer.start();
	}
	public class PaintPanel extends JPanel{
		
		
		public PaintPanel(){
			for(Direction d : Direction.values()){
				dirmap.put(d,false);
			}
			for(Plane_skill p : Plane_skill.values()){
				planeskillmap .put(p,false);
			}
			for(Enum_gamekey g : Enum_gamekey.values()){
				gamekeymap .put(g,false);
			}
			setKeyBindings();
			timer = new Timer(30,new TimerListen(ctl,dirmap,planeskillmap,gamekeymap,this));
			
			timer.start();
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			try{
				background_moveY=background_moveY+1;
				if(background_moveY>500){
					background_moveY=background_moveY-500;
				}
				g.drawImage(ImageIO.read(new File("pic/background.png")), -10,(int)background_moveY-500 ,700,1500,null);
			}catch(Exception e){
				System.out.println(123124);
			}
			t2.setText("?›®??é?›æ?Ÿç?Ÿå‘½??:"+ctl.player.getlife());
			
			
			t2.setFont(new Font("?–°ç´°æ?é??", Font.PLAIN , 20));
			ctl.display(g);
		}
		public void setKeyBindings(){
			//è¨­ç½®keybind ??è¦? InputMap Action Map KeyStorke ä¾†å?‡æ?‰éµ->??å??->??•ä??
			InputMap inm =getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap actm=getActionMap();
			for(Direction d : Direction.values()){
				KeyStroke press= KeyStroke.getKeyStroke(d.getKey(),0,false);
				KeyStroke release=KeyStroke.getKeyStroke(d.getKey(),0,true);
				
				inm.put(press, d.toString()+":press");
				inm.put(release,d.toString()+":release");
				actm.put(d.toString()+":press", new AbstractAction(){
					public void actionPerformed(ActionEvent e){
						dirmap.put(d,true);
					}
				});
				actm.put(d.toString()+":release", new AbstractAction(){
					public void actionPerformed(ActionEvent e){
						dirmap.put(d,false);
					}
				});
			}
			for(Plane_skill p : Plane_skill.values()){
				KeyStroke press= KeyStroke.getKeyStroke(p.getKey(),0,false);
				KeyStroke release=KeyStroke.getKeyStroke(p.getKey(),0,true);
				
				inm.put(press, p.toString()+":press");
				inm.put(release,p.toString()+":release");
				actm.put(p.toString()+":press", new AbstractAction(){
					public void actionPerformed(ActionEvent e){
						planeskillmap.put(p,true);
					}
				});
				actm.put(p.toString()+":release", new AbstractAction(){
					public void actionPerformed(ActionEvent e){
						planeskillmap.put(p,false);
					}
				});
			}
			for(Enum_gamekey ga : Enum_gamekey.values()){
				KeyStroke press= KeyStroke.getKeyStroke(ga.getKey(),0,false);
				KeyStroke release=KeyStroke.getKeyStroke(ga.getKey(),0,true);
				
				inm.put(press, ga.toString()+":press");
				inm.put(release,ga.toString()+":release");
				actm.put(ga.toString()+":press", new AbstractAction(){
					public void actionPerformed(ActionEvent e){
						gamekeymap.put(ga,true);
					}
				});
				actm.put(ga.toString()+":release", new AbstractAction(){
					public void actionPerformed(ActionEvent e){
						gamekeymap.put(ga,false);
					}
				});
			}
		}
	}
	public class ControlPanel extends JPanel implements ActionListener{
		public ControlPanel(){
			
			
			t1= new JLabel("Z ?µå°„æ?? ?–¹??‘éµç§»å??");
			t1.setPreferredSize(new Dimension(220,70));
			t1.setFont(new Font("?–°ç´°æ?é??", Font.PLAIN , 20));
			add(t1);
			t2 = new JLabel("?›®??é?›æ?Ÿç?Ÿå‘½??:");
			t2.setPreferredSize(new Dimension(220,70));
			add(t2);
			
			//b1= new JButton("Start");
			//b1.setPreferredSize(new Dimension(100,100));
			//add(b1);
			/*
			b2= new JButton("Reset");
			b2.setPreferredSize(new Dimension(70,70));
			add(b2);
			*/
			
			
			
			//b1.addActionListener(this);
			//b2.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e){
			
			if(e.getActionCommand()=="Start"){
				
				  setdelay(30);
		          
		          ctl.gameStart();
			}else if(e.getActionCommand()=="Reset"){
				setdelay(30);
				
				 ctl.gameReset();
			}
		}
	}
	
	
	
	

}
