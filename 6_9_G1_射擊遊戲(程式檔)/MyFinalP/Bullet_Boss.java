 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.File;

import javax.imageio.ImageIO;

public class Bullet_Boss extends Bullet {
public Bullet_Boss(int tag){
		
		X=-500;
		Y=-500;
		Width=25;
		Height=25;
		CurrentState="Nothing";
		moveoffset=12;
		dx=0.0;
		dy=1.0;
		angle=0.0;
		model=new Model(addspeed,angle,moveoffset,X,Y,Width,Height,dx,dy,CurrentState,null,action_cd_count);
		try{
			switch(tag){
			case 1:bullet= ImageIO.read(new File("pic/boss_bullet.png"));break;
			case 2:bullet= ImageIO.read(new File("pic/boss2_bullet.png"));break;
			}
		}catch(Exception e){
			System.out.println(12334);
		}
	}
	public void display(Graphics g){
		AffineTransform at = new AffineTransform();
		double angle =(((model.getAngle()/180)*Math.PI)+(1.0*Math.PI))*-1;
		
		double preX=(int)model.get_X()+(int)model.get_W()/2;
		//double preY=(int)model.get_Y();
		double preY=(int)model.get_Y()+(int)model.get_H()/2;
		at.translate(preX, preY);
		at.rotate(angle);
		at.translate(-(int)model.get_W()/2,-(int)model.get_H()/2);
		//at.translate(-(int)model.get_W()/2,0);
		at.scale(0.2, 0.4);
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
