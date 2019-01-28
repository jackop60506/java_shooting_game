 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.File;

import javax.imageio.ImageIO;

public class Item_life_up extends Item{
	private ImageSequence_item ims_enemy;
	private double Image_sep=0.0;
	private int Image_sep_temp=0;
	private static boolean power_up_mutex=true;
	public Item_life_up(){
			ims_enemy = new ImageSequence_item();
			X=100;
			Y=-100;
			Width=25;
			Height=25;
			CurrentState="Nothing";
			treasure_chance=1.0;
			moveoffset=4;
			dx=0.0;
			dy=1.0;
			angle=0.0;
			model=new Model(addspeed,angle,moveoffset,X,Y,Width,Height,dx,dy,CurrentState,null,action_cd_count,treasure_chance);
			try{
				Item= ImageIO.read(new File("pic/life_upitem_0.png"));
					
			}catch(Exception e){
				System.out.println(134);
			}
		}
		public void display(Graphics g){
			AffineTransform at = new AffineTransform();
			double angle =(((model.getAngle()/180)*Math.PI)+(1.0*Math.PI))*-1;
			
			double preX=(int)model.get_X();
			double preY=(int)model.get_Y();
			at.translate(preX, preY);
			//at.rotate(angle);
			//at.translate(-(int)model.get_W()/2,-(int)model.get_H()/2);
			at.scale(1.0,1.0);
	        Graphics2D g2 = (Graphics2D) g;
	       
			if(model.get_current_state().equals("flying")){
				moveY();
				moveX();
				if(Image_sep>5.0*Image_sep_temp){
					Item=ims_enemy.nextlifeupImage();
					Image_sep_temp++;
				}
			}else if(model.get_current_state().equals("Nothing")){
				model.setArea_Y(-100);
				Image_sep=0.0;
				Image_sep_temp=0;
			}
			g2.drawImage(Item, at, null);
			Image_sep++;
		}
		public void Specialtoplane(Player p){
			
			if(p.getItemState().getLife()<Player.PLAYER_LIFE){
				p.getItemState().setLife(p.getItemState().getLife()+1);
			}
		}
}
