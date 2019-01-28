 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Enemy_smile_face extends Enemy{
	private ImageSequence_enemy ims_enemy;
	
	//public Clip_normal_enemy ce;
	
	private ArrayList<Clip> clip_list;
	private int CLIP_NUMBER=3;
	
	public final double ACTION_CD=5.0;
	public static final int SMILE_LIFE=4;

	public double action_cd_count=0.0;
	private double cantattack_cd=0;
	private double CANTATTACK_CD=2.0;
	private double CANTATTACK_CD_SEP=1.0;
	private String Action_state="NotHurt";
	private double testan=0.0;
	private Special_affect special_affect;
	protected Shoot_type shoot_type;
	public Enemy_smile_face(){
		//X=(int)(Math.random()*700);
		//Y=(int)(Math.random()*700);
		X=-100.0;
		Y=-100.0;
		Width=75;
		Height=75;
		CurrentState="Died";
		//shoot_speed=(Math.random()*10+5);
		shoot_speed=22;
		move_offset=3;
		life=3;
		dx=0.0;
		dy=1.0;
		shoot_level=1;
		clip_list = new ArrayList<Clip>();
		for(int i=0;i<CLIP_NUMBER;i++){
			clip_list.add(new Clip_rocket_enemy());
		}
		boom=new Boom(60,60);

		item_list.add(new Item_power_up());
		item_list.add(new Item_life_up());
		ims_enemy = new ImageSequence_enemy();
		music_manage = new Music_Manage();
		shoot_type= new Shoot_type(music_manage);
		
		angle=180.0;
		model=new Model(boom,shadow_list,shoot_type,rotate_clock,addspeed,ims_enemy,Action_state,cantattack_cd,action_cd_count,angle,clip_list,shoot_speed,move_offset,X,Y,Width,Height,dx,dy,CurrentState,life,item_list);
		//special_affect= new Special_affect(model);

		try{
			img= ImageIO.read(new File("pic/enemy_3_0.png"));
		}catch(Exception e){
			System.out.println(12334);
		}
	}
	public void display(Graphics g){
		model.getBoom().display(g);

		AffineTransform at = new AffineTransform();
		
		double preX=(int)model.get_X()+(model.get_W()/2);
		double preY=(int)model.get_Y()+(model.get_H()/2);
		at.translate(preX,preY);
		double angle =(((model.getAngle()/180)*Math.PI)+(1.0*Math.PI))*-1;

		at.rotate(angle);
		
		at.scale(0.3,0.3);
		at.translate(-model.get_W()*1.4,-model.get_H()*1.4);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, at, null);

		if(model.get_current_state().equals("Died")){
			model.setArea_X(-100);model.setArea_Y(-100);
		}else if(model.get_current_state().equals("Nothing")){
			
		}
		
		
		//Rectangle2D myRect = new Rectangle2D.Double(0, -30, model.getLife()*(int)(model.get_W()/(life/3)),(int)(model.get_H()/10));
		//g2.setPaint(Color.RED);
	
		
	
		//AffineTransform.getRotateInstance(Math.PI/4, 150, 150);
		//Shape rotatedRect = at.createTransformedShape(myRect);
		
		
		if(model.getAction_state().equals("Hurt") && model.getCantattack_CD()<CANTATTACK_CD){
			CantAttack(true);
		}else{
			CantAttack(false);
		}
		//angle.g2.draw(rotatedRect);
		//g2.fill(rotatedRect);
		//g2.setColor(Color.RED);
		
		
		for(int q=0;q<CLIP_NUMBER;q++){
			Clip_rocket_enemy cl=(Clip_rocket_enemy)model.getClip_list().get(q);
			for(int i=0;i<cl.get_bullet_list_MAX();i++){
				cl.get_bullet_list().get(i).display(g);
			}
		}
		for(int i=0;i<item_list.size();i++){
			model.getItemlist().get(i).display(g);;
		}
		//special_affect.shadow(model,g,img);
		//special_affect.Useshadow(model,angle);
	}
	public void shoot(Player p){
		//model.getShootType().Shoot_tosomeone(this, p);
		model.getShootType().Shoot_normal(model, 2);
	}
	
	
	public void CantAttack(boolean t){
		double chance=0.0;
		for(int i=0;i<model.getItemlist().size();i++){
			if(model.getItemlist().get(i).getItemState().getTresure_chance()>0.0){
				chance=model.getItemlist().get(i).getItemState().getTresure_chance();
				break;
			}
			
		}
			switch((int)chance){
			case 1:
			if(t==true){
				model.setCantattack_CD(model.getCantattack_CD()+CANTATTACK_CD_SEP);
				img=model.getimsEnmey().nextSmilesenemyImage();
			}else{
				model.setCantattack_CD(0);
				model.setAction_state("NotHurt");
				
				img=model.getimsEnmey().getSmilesenemyImage(0);
			}
			break;
		case 0:
			if(t==true){
				model.setCantattack_CD(model.getCantattack_CD()+CANTATTACK_CD_SEP);
				img=model.getimsEnmey().nextSmileenemyImage();
			}else{
				model.setCantattack_CD(0);
				model.setAction_state("NotHurt");
				
				img=model.getimsEnmey().getSmileenemyImage(0);
			}
			break;
		
	}	
	}
	public void plane_crash(Player p){
		Model plane=p.getItemState();		
		double pW=plane.get_W(),pH=plane.get_H(),pX=plane.get_X(),pY=plane.get_Y();
		double RW=411.0,RH=313.0;
		
		
		if(
			(
				(pY+pH*(10/RH)>model.get_Y()+5)
				&& (pY+pH*(10/RH)<model.get_Y()+model.get_H()-5)
			)
			||
			(
					(pY+pH*(35/RH)>model.get_Y()+5)
					&& (pY+pH*(35/RH)<model.get_Y()+model.get_H()-5)
			)
		  ){
			
			if(
					(
						(pX+pW/2+(pW*(10.5/RW)) >model.get_X()+35)
						&& (pX+pW/2+(pW*(10.5/RW))<model.get_X()+model.get_W()-35)
					)
					||
					(
						(pX+pW/2-(pW*(10.5/RW)) >model.get_X()+35)
						&& (pX+pW/2-(pW*(10.5/RW))<model.get_X()+model.get_W()-35)
					)
				  ){
		 		
					p.gethurt();
					
				}	
		}
		if(
					(
					(pY+pH*(35/RH)>model.get_Y()+10)
					&& (pY+pH*(35/RH)<model.get_Y()+model.get_H()-20)
					)
					||
					(
							(pY+pH*(60/RH)>model.get_Y()+10)
							&& (pY+pH*(60/RH)<model.get_Y()+model.get_H()-20)
					)
			){
				if(
						(
							(pX+pW/2+(pW*(33.5/RW)) >model.get_X()+20)
							&& (pX+pW/2+(pW*(33.5/RW))<model.get_X()+model.get_W()-20)
						)
						||
						(
							(pX+pW/2-(pW*(33.5/RW)) >model.get_X()+20)
							&& (pX+pW/2-(pW*(33.5/RW))<model.get_X()+model.get_W()-20)
						)
					  ){
			 		
						p.gethurt();
						
					}	
		}
		if(
					(
					(pY+pH*(60/RH)>model.get_Y()+20)
					&& (pY+pH*(60/RH)<model.get_Y()+model.get_H()-20)
					)
					||
					(
							(pY+pH*(115/RH)>model.get_Y()+20)
							&& (pY+pH*(115/RH)<model.get_Y()+model.get_H()-20)
					)
		){
			if(
					(
						(pX+pW/2+(pW*(55.5/RW)) >model.get_X()+10)
						&& (pX+pW/2+(pW*(55.5/RW))<model.get_X()+model.get_W()-10)
					)
					||
					(
						(pX+pW/2-(pW*(55.5/RW)) >model.get_X()+10)
						&& (pX+pW/2-(pW*(55.5/RW))<model.get_X()+model.get_W()-10)
					)
				  ){
		 		
					p.gethurt();
					
				}	
		} 
		if(
				(
				(pY+pH*(110/RH)>model.get_Y()+15)
				&& (pY+pH*(110/RH)<model.get_Y()+model.get_H()-15)
				)
				||
				(
						(pY+pH*(160/RH)>model.get_Y()+15)
						&& (pY+pH*(160/RH)<model.get_Y()+model.get_H()-15)
				)
		){
			if(
					(
						(pX+pW/2+(pW*(205.5/RW)) >model.get_X()+11)
						&& (pX+pW/2+(pW*(205.5/RW))<model.get_X()+model.get_W()-11)
					)
					||
					(
						(pX+pW/2-(pW*(205.5/RW)) >model.get_X()+11)
						&& (pX+pW/2-(pW*(205.5/RW))<model.get_X()+model.get_W()-11)
					)
				  ){
		 		
					p.gethurt();
					
				}	
		}
		if(
				(
				(pY+pH*(160/RH)>model.get_Y()+10)
				&& (pY+pH*(160/RH)<model.get_Y()+model.get_H()-10)
				)
				||
				(
						(pY+pH*(310/RH)>model.get_Y()+10)
						&& (pY+pH*(310/RH)<model.get_Y()+model.get_H()-10)
				)
		){
			if(
					(
						(pX+pW/2+(pW*(25.5/RW)) >model.get_X()+7)
						&& (pX+pW/2+(pW*(25.5/RW))<model.get_X()+model.get_W()-7)
					)
					||
					(
						(pX+pW/2-(pW*(25.5/RW)) >model.get_X()+7)
						&& (pX+pW/2-(pW*(25.5/RW))<model.get_X()+model.get_W()-7)
					)
				  ){
		 		
					p.gethurt();
					
				}	
		}
	}

}
