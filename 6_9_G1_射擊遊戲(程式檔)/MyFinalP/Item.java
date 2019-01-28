 

import java.awt.Graphics;
import java.awt.Image;

public abstract class Item extends Role{
	Image Item;
	Double dx,dy;
	int Type,moveoffset;
	public double action_cd_count=0.0;
	public double treasure_chance=0.0;

	public boolean Item_crash(Player p){
		Model plane=p.getItemState();		
		double pW=plane.get_W(),pH=plane.get_H(),pX=plane.get_X(),pY=plane.get_Y();
		double RW=411.0,RH=313.0;
		boolean check=false;
		if(
			(
				(pY+pH*(10/RH)>model.get_Y())
				&& (pY+pH*(10/RH)<model.get_Y()+model.get_H())
			)
			||
			(
					(pY+pH*(35/RH)>model.get_Y())
					&& (pY+pH*(35/RH)<model.get_Y()+model.get_H())
			)
		  ){
			
				if(
					(
						(pX+pW/2+(pW*(10.5/RW)) >model.get_X())
						&& (pX+pW/2+(pW*(10.5/RW))<model.get_X()+model.get_W())
					)
					||
					(
						(pX+pW/2-(pW*(10.5/RW)) >model.get_X())
						&& (pX+pW/2-(pW*(10.5/RW))<model.get_X()+model.get_W())
					)
				  ){
		 		
					check=true;
					
				}	
		}
		if(
					(
					(pY+pH*(35/RH)>model.get_Y())
					&& (pY+pH*(35/RH)<model.get_Y()+model.get_H())
					)
					||
					(
							(pY+pH*(60/RH)>model.get_Y()+10)
							&& (pY+pH*(60/RH)<model.get_Y()+model.get_H())
					)
			){
				if(
						(
							(pX+pW/2+(pW*(33.5/RW)) >model.get_X())
							&& (pX+pW/2+(pW*(33.5/RW))<model.get_X()+model.get_W())
						)
						||
						(
							(pX+pW/2-(pW*(33.5/RW)) >model.get_X())
							&& (pX+pW/2-(pW*(33.5/RW))<model.get_X()+model.get_W())
						)
					  ){
			 		
						check=true;
						
					}	
		}
		if(
					(
					(pY+pH*(60/RH)>model.get_Y())
					&& (pY+pH*(60/RH)<model.get_Y()+model.get_H())
					)
					||
					(
							(pY+pH*(115/RH)>model.get_Y())
							&& (pY+pH*(115/RH)<model.get_Y()+model.get_H())
					)
		){
			if(
					(
						(pX+pW/2+(pW*(55.5/RW)) >model.get_X())
						&& (pX+pW/2+(pW*(55.5/RW))<model.get_X()+model.get_W())
					)
					||
					(
						(pX+pW/2-(pW*(55.5/RW)) >model.get_X())
						&& (pX+pW/2-(pW*(55.5/RW))<model.get_X()+model.get_W())
					)
				  ){
		 		
					check=true;
					
				}	
		} 
		if(
				(
				(pY+pH*(110/RH)>model.get_Y())
				&& (pY+pH*(110/RH)<model.get_Y()+model.get_H())
				)
				||
				(
						(pY+pH*(160/RH)>model.get_Y())
						&& (pY+pH*(160/RH)<model.get_Y()+model.get_H())
				)
		){
			if(
					(
						(pX+pW/2+(pW*(170.5/RW)) >model.get_X())
						&& (pX+pW/2+(pW*(170.5/RW))<model.get_X()+model.get_W())
					)
					||
					(
						(pX+pW/2-(pW*(150.5/RW)) >model.get_X())
						&& (pX+pW/2-(pW*(150.5/RW))<model.get_X()+model.get_W())
					)
				  ){
		 		
					check=true;
					
				}	
		}
		if(
				(
				(pY+pH*(160/RH)>model.get_Y())
				&& (pY+pH*(160/RH)<model.get_Y()+model.get_H())
				)
				||
				(
						(pY+pH*(310/RH)>model.get_Y())
						&& (pY+pH*(310/RH)<model.get_Y()+model.get_H())
				)
		){
			if(
					(
						(pX+pW/2+(pW*(25.5/RW)) >model.get_X())
						&& (pX+pW/2+(pW*(25.5/RW))<model.get_X()+model.get_W())
					)
					||
					(
						(pX+pW/2-(pW*(25.5/RW)) >model.get_X())
						&& (pX+pW/2-(pW*(25.5/RW))<model.get_X()+model.get_W())
					)
				  ){
		 		
					check=true;
					
				}	
		}
		return check;
	}

	@Override
	public abstract void display(Graphics g);
	public  abstract  void Specialtoplane(Player p);
	public void moveX(){
		model.setArea_X(model.get_X()+model.getDirection_DX()*model.get_move_offset());
	}
	public void moveY(){
		model.setArea_Y(model.get_Y()+model.getDirection_DY()*model.get_move_offset());
	}
	
}
