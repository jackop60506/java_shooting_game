 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.File;

import javax.imageio.ImageIO;

public class Bullet_Player extends Bullet {
	public Bullet_Player(){
		
		X=-500;
		Y=-500;
		Width=20;
		Height=20;
		CurrentState="Nothing";
		dx=0.0;
		dy=-1.0;
		moveoffset=20;
		angle=0.0;
		model=new Model(addspeed,angle,moveoffset,X,Y,Width,Height,dx,dy,CurrentState,null,action_cd_count);
		
		try{
				//bullet= ImageIO.read(new File("pic/bullet3_test2_back.png"));
				bullet= ImageIO.read(new File("pic/bullet7.png"));
		}catch(Exception e){
			System.out.println(12334);
		}
	}
	public void display(Graphics g){
		AffineTransform at = new AffineTransform();
		double angle =(((model.getAngle()/180)*Math.PI)+(1.0*Math.PI))*-1;
		double preX=(int)model.get_X();
		double preY=(int)model.get_Y();

		at.translate(preX, preY);
		at.rotate(angle);
		at.translate(-(model.get_W()/2),0.0);
		at.scale(0.55, 0.55);
        Graphics2D g2 = (Graphics2D) g;
        
		if(model.get_current_state().equals("flying")){
			
			moveY();
			moveX();
		}else if(model.get_current_state().equals("Nothing")){
			model.setArea_Y(-100);
			
		}
		g2.drawImage(bullet, at, null);
	}
	public void moveX(){
		model.setArea_X(model.get_X()+model.getDirection_DX()*model.get_move_offset());
	}
	public void moveY(){
		model.setArea_Y(model.get_Y()+model.getDirection_DY()*model.get_move_offset());
	}
	
}
