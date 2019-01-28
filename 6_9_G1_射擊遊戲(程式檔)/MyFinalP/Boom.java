 

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Boom extends Item{
	Image Item;
	Double dx,dy;
	int Type,moveoffset;
	ImageSequence_boom imgboom;
	Image img;
	public static double BOOM_ACTION=27.0;
	public Boom(int w,int h){
		X=100;
		Y=100;
		Width=w;
		Height=h;
		treasure_chance=0.0;
		imgboom = new ImageSequence_boom();
		model=new Model(0.0,0.0,0.0,X,Y,Width,Height,0.0,0.0,"",null,0.0,treasure_chance);
		
	}
	public void display(Graphics g) {

		
	
		if(
				model.getAction_CD()<BOOM_ACTION 
				&& 
				model.getTresure_chance()==1.0){
			
			if(model.getAction_CD()%3==0){
				img=imgboom.nextBoomImage();
			}

			g.drawImage(img,(int) model.get_X(),(int)model.get_Y(),(int)model.get_W(),(int)model.get_H(),null);
			model.setAction_CD(model.getAction_CD()+1);
		}else{

			model.setTresure_chance(0.0);
			imgboom.setIndex(0);
			//model.setAction_CD(0.0); <-create
		}
		
	}

	
	public void Specialtoplane(Player p) {
				
	}
}
