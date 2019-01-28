 
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;


public class Special_affect {
	public double count;
	public double static_pos_X=100;
	public double static_pos_Y=100;
	public double static_offset=100;
	public double bsetx=1,bsety=1;
	public double Xoffset=0.1,Yoffset=0.1;
	AImanage aimanage;
	public Special_affect(){
		aimanage = new AImanage();
	}
	public void shadow(Player p,Shadow s,double speed){
			aimanage.tosomewhere(s, s.getItemState().get_X(), s.getItemState().get_Y(),
					p.getItemState().get_X(),p.getItemState().get_Y(), speed, false);
	}
	public void shadow(Boss2 p,Shadow s,double speed){
			aimanage.tosomewhere(s, s.getItemState().get_X(), s.getItemState().get_Y(),
					p.getItemState().get_X(),p.getItemState().get_Y(), speed, false);
	}
	public void Useshadow(Model model){
		if(Math.abs(model.get_X()-static_pos_X)<3 &&
		   Math.abs(model.get_Y()-static_pos_Y)<3 	
				){
			static_offset=0.01;			
		}else if(Math.abs(model.get_X()-static_pos_X)>500 ||
				Math.abs(model.get_Y()-static_pos_X)>500 
				){
			static_offset=25;
		}else{
			static_offset=18;
		}
		
		
		double angle=get_Angle(static_pos_X,static_pos_Y,model.get_X(),model.get_Y());
		//只差方向設定
		Xoffset=(Math.sin(
				 Math.toRadians(angle+180)
				));
		
	    Yoffset=(Math.cos(
	    		Math.toRadians(angle+180)
	    		));
		
	    
	}
	public void Useshadow(Model model,double angle){
		if(Math.abs(model.get_X()-static_pos_X)<3 &&
		   Math.abs(model.get_Y()-static_pos_Y)<3 	
				){
			static_offset=0.01;			
		}else if(Math.abs(model.get_X()-static_pos_X)>500 ||
				Math.abs(model.get_Y()-static_pos_X)>500 
				){
			static_offset=25;
		}else{
			static_offset=18;
		}
		
		
		//double angle=get_Angle(static_pos_X,static_pos_Y,model.get_X(),model.get_Y());
		//只差方向設定
		Xoffset=(Math.sin(
				 Math.toRadians(angle+180)
				));
		
	    Yoffset=(Math.cos(
	    		Math.toRadians(angle+180)
	    		));
		model.setAngle(angle);
	    
	}
	public void Stopshadow(Model model){
		static_offset=0;
	}
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
	}
}


/*
public class Special_affect {
	public double count;
	public double static_pos_X=100;
	public double static_pos_Y=100;
	public double static_offset=100;
	public double bsetx=1,bsety=1;
	public double Xoffset=0.1,Yoffset=0.1;
	public Special_affect(Model p){
		count=0.0;
		static_pos_X=p.get_X();
		static_pos_Y=p.get_Y();
	}
	public void shadow_start(){
		
	}
	public void shadow(Model model,Graphics g,Image img){
		
			if((Math.abs(static_pos_X-model.get_X())<15) && (Math.abs(static_pos_Y-model.get_Y())<15)){
				
				static_pos_X=model.get_X();
				static_pos_Y=model.get_Y();
				Stopshadow(model);
			}else{
				
				  static_pos_X=static_pos_X+Xoffset*static_offset;
				  static_pos_Y=static_pos_Y+Yoffset*static_offset;
			}
			Graphics2D g2 = (Graphics2D)g;
			double alpha = 0.7; 
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)alpha);
			
			g2.setComposite(ac);
			g2.drawImage(img, (int)static_pos_X , (int)static_pos_Y,(int)model.get_W(),(int)model.get_H(),null);		
			
	}
	public void BeOpacity(){
		
	}
	public void Useshadow(Model model){
		if(Math.abs(model.get_X()-static_pos_X)<3 &&
		   Math.abs(model.get_Y()-static_pos_Y)<3 	
				){
			static_offset=0.01;			
		}else if(Math.abs(model.get_X()-static_pos_X)>500 ||
				Math.abs(model.get_Y()-static_pos_X)>500 
				){
			static_offset=25;
		}else{
			static_offset=18;
		}
		
		
		double angle=get_Angle(static_pos_X,static_pos_Y,model.get_X(),model.get_Y());
		//只差方向設定
		Xoffset=(Math.sin(
				 Math.toRadians(angle+180)
				));
		
	    Yoffset=(Math.cos(
	    		Math.toRadians(angle+180)
	    		));
		
	    
	}
	public void Useshadow(Model model,double angle){
		if(Math.abs(model.get_X()-static_pos_X)<3 &&
		   Math.abs(model.get_Y()-static_pos_Y)<3 	
				){
			static_offset=0.01;			
		}else if(Math.abs(model.get_X()-static_pos_X)>500 ||
				Math.abs(model.get_Y()-static_pos_X)>500 
				){
			static_offset=25;
		}else{
			static_offset=18;
		}
		
		
		//double angle=get_Angle(static_pos_X,static_pos_Y,model.get_X(),model.get_Y());
		//只差方向設定
		Xoffset=(Math.sin(
				 Math.toRadians(angle+180)
				));
		
	    Yoffset=(Math.cos(
	    		Math.toRadians(angle+180)
	    		));
		model.setAngle(angle);
	    
	}
	public void Stopshadow(Model model){
		static_offset=0;
	}
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
	}
}
*/