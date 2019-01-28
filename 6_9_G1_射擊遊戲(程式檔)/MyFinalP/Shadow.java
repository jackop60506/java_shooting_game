 

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Shadow extends Role{
	private int move_offset;
	private ImageSequence_plane ims_plane;
	private Image img;

	private double action_cd_count=0.0;
	public Shadow(double W,double H,double XX,double YY,Image i){
		X=XX;
		Y=YY;
		Width=W;
		Height=H;
		CurrentState="Nothing";
		move_offset=4;
		dx=0.0;
		dy=1.0;
		angle=0.0;
		model=new Model(addspeed,angle,move_offset,X,Y,Width,Height,dx,dy,CurrentState,null,action_cd_count,0.0);
		ims_plane= new  ImageSequence_plane();
		img=i;
	}
	@Override
	public void display(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		double alpha = 0.7; 
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)alpha);
		
		g2.setComposite(ac);
		
		g2.drawImage(img, (int)model.get_X(), (int)model.get_Y(),(int)model.get_W(),(int)model.get_H(), null);
		
	}
	public void moveX(){	
		//System.out.println(model.get_X()+"  "+model.getDirection_DX()+" "+model.get_move_offset()+" "+model.getAddspeed());
		double x=model.get_X()+model.getDirection_DX()*model.get_move_offset()*model.getAddspeed();

		model.setArea_X(x);
		
	}
	public void moveY(){
		
		model.setArea_Y(model.get_Y()+model.getDirection_DY()*model.get_move_offset()*model.getAddspeed());
		//model.setArea_Y(model.get_Y()+model.get_move_offset()*model.getAddspeed());

	}
}
