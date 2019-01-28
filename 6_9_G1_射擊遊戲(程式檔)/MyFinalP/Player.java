 

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Player extends Role{
	private ImageSequence_plane ims_plane;
	private Image img,firebottom;
	private int img_slow_tag=0;
	public static final double PLAYER_LIFE=10;
	private double shoot_speed=5;
	private int move_offset;
	private int life;
	private int shoot_level;
	private Direction d;
	private ArrayList<Clip> clip_list;
	private int CLIP_NUMBER=8;
	
	private Shoot_type shoot_type;
	
	private double skill_supershoot_cd=0;
	private double cantattack_cd=0;
	private double CANTATTACK_CD=30.0;
	private double CANTATTACK_CD_SEP=1.0;
	private String Action_state="NotHurt";
	private Special_affect special_affect;
	private Special_affect special_affect2;
	private double All_SLOW_DOWN_EXEMAX=10.0;
	private double All_slow_down_CD=5.0;
	private double all_slow_down_cdcount=0.0;
	public ArrayList<Shadow> shadow_list = new ArrayList<Shadow>();

	
	public final double ACTION_CD=5.0;
	public static final double BLOODLENGTH=PLAYER_LIFE/70.0;
	
	public static final double STATIC_DX=0.0;
	public static final double STATIC_DY=1.0;
	public Boom boom;
	public double DIEDTIME=5.0;
	public double died_time=0.0;
	public boolean died_lock=true;
	public Player(){
		X=300;
		Y=600;
		Width=70;
		Height=70;
		CurrentState="Nothing";
		Action_state="NotHurt";
		shoot_speed=5;
		move_offset=20;
		ims_plane = new ImageSequence_plane();
		life=(int)PLAYER_LIFE;
		boom=new Boom(60,60);

		d=Direction.UP;
		try{
			img= ImageIO.read(new File("pic/plane2_0.png"));
			firebottom= ImageIO.read(new File("pic/fire_bottom_0.png"));
		}catch(Exception e){
			System.out.println(12334);
		}
		shadow_list.add(new Shadow(Width,Height,X,Y,img));
		shadow_list.add(new Shadow(Width,Height,X,Y,img));
		

		//clip_player_list
		clip_list = new ArrayList<Clip>();
		for(int i=0;i<CLIP_NUMBER;i++){
			clip_list.add(new Clip_player());
		}
		shoot_level=1;
		music_manage = new Music_Manage();
		shoot_type= new Shoot_type(music_manage);
		
		model=new Model(boom,shadow_list,addspeed,Action_state,cantattack_cd,shoot_type,shoot_level,skill_supershoot_cd,clip_list,d,shoot_speed,move_offset,X,Y,Width,Height,CurrentState,ims_plane,life);
		special_affect= new Special_affect();
		//special_affect2= new Special_affect(model);
	
		
	}
	public void display(Graphics g){
		if(model.getLife()>0){
			if(model.get_current_state().equals("Flying")){
				img_slow_tag++;
				if(img_slow_tag==2){
					firebottom=model.getimsPlane().getImage(0);
				}else if(img_slow_tag==5){
					firebottom=model.getimsPlane().getImage(1);
				}
				else if(img_slow_tag>11){
					img_slow_tag=12;
					firebottom=model.getimsPlane().getImage(2);
				}
				
			}
			else if(model.get_current_state().equals("Nothing")){
				
				
				img_slow_tag--;
					if(img_slow_tag==5){
						firebottom=model.getimsPlane().getImage(0);
					}else if(img_slow_tag==-2){
						img_slow_tag=10;
						firebottom=model.getimsPlane().getImage(1);
					}
					
			}
			else if(model.get_current_state().equals("Died")){
				
				model.setArea_X(-100);model.setArea_Y(-100);
				
			}

			
			if(model.getAction_state().equals("Hurt") && model.getCantattack_CD()<CANTATTACK_CD){
				
				CantAttack(true);
			}else{
				CantAttack(false);
			}
			for(int c=0;c<model.getShadow().size();c++){
				
				special_affect.shadow(this,model.getShadow().get(c),c*0.8+4.2);
				shadow_list.get(c).display(g);
			}
			
			Graphics2D g2 = (Graphics2D)g;
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)1.0);
			
			g2.setComposite(ac);
			g.drawImage(img, (int)model.get_X(), (int)model.get_Y(),(int)model.get_W(),(int)model.get_H(), null);
			g.setColor(Color.RED);
			g.fillRect((int)model.get_X(), (int)model.get_Y()+(int)(model.get_H()),(int)(model.getLife()/BLOODLENGTH),(int)(model.get_H()/15));
			g.drawImage(firebottom,(int) model.get_X()+27, (int)model.get_Y()+61, null);
			
			
			
			for(int q=0;q<CLIP_NUMBER;q++){
				Clip_player cl=(Clip_player)model.getClip_list().get(q);
				for(int i=0;i<cl.get_bullet_list_MAX();i++){
					cl.get_bullet_list().get(i).display(g);
				}
			}
		
		}else{
			model.getBoom().display(g);

		}
		
		
		
		//special_affect.shadow(model,g,img);
		//special_affect.Useshadow(model);
		
	}
	
	
	public void moveX(Direction d){
		model.setDirection(d);
		
		double x=model.get_X()+model.getDirection().getX()*model.get_move_offset();
		model.setArea_X(x);
		
	}
	public void moveY(Direction d){
		model.setDirection(d);
		model.setArea_Y(model.get_Y()+model.getDirection().getY()*model.get_move_offset());
	}
	public void shoot_normal_upgrade(){
		if(model.getShootlevel()==5){
			model.setShootlevel(5);
		}else{
			model.setShootlevel(model.getShootlevel()+1);
		}
	}
	public void shoot(){
		model.getShootType().Shoot_normal(model,model.getShootlevel());
		//model.getShootType().Shoot_normal(model,5);


	}
	public void gethurt(){
		int i=getlife();
		if(model.getAction_state().equals("NotHurt")){
			
			i=i-1;
			model.setLife(i);
			model.setAction_state("Hurt");
			music_manage.playhurt();
		}
	}
	public void PlayerBulletCDClear(){
		for(int i=0;i<model.getClip_list().size();i++){
			model.getClip_list().get(i).set_bullet_speed_count(0.0);			
		}
	}
	public void CantAttack(boolean t){
		
		if(t==true){
			model.setCantattack_CD(model.getCantattack_CD()+CANTATTACK_CD_SEP);
			img=ims_plane.PlanenextImage();
		}else{
			model.setCantattack_CD(0);
			model.setAction_state("NotHurt");
			img=ims_plane.planegetImage(0);
		}		
	}
	//skill
	public void shoot_type2(Model e){

		model.getShootType().Shoot_tosomeone(model, e);
	}
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
	}
	public void player_TimeStop(ArrayList<Enemy_normal> eNl, ArrayList<Enemy_Rocket> eRl){
		for(int q=0;q<eNl.size();q++){
			if(eNl.get(q).getItemState().get_current_state().equals("Nothing")){
				eNl.get(q).getItemState().set_move_offset(0.1);
			}
		}
		for(int q=0;q<eRl.size();q++){
			if(eRl.get(q).getItemState().get_current_state().equals("Nothing")){
				eRl.get(q).getItemState().set_move_offset(0.1);
				
			}
		}
	}
	
	public void Time_slow(ArrayList<Enemy_normal> eNl, ArrayList<Enemy_Rocket> eRl){
		
	}
	
	
	
	
	
		
	
	public boolean planeState(){
		
		Model p_state=model;
		
		double PX=p_state.get_X();
		double PY=p_state.get_Y();
		double PW=p_state.get_W();
		double PH=p_state.get_H();
		if(model.getLife()==0){
			
			if(died_time<50.0){
				if(model.getBoom().getItemState().getTresure_chance()==0.0 && died_lock){
					died_lock=false;
					model.getBoom().getItemState().setArea_X(model.get_X()+model.get_W()/2-model.getBoom().getItemState().get_W()/2);
					model.getBoom().getItemState().setArea_Y(model.get_Y()+model.get_H()/2-model.getBoom().getItemState().get_H()/2);
					model.getBoom().getItemState().setTresure_chance(1.0);
					model.getBoom().getItemState().setAction_CD(0.0);
					p_state.set_current_state("Died");
					(new Music_Manage()).playboom();
					Controller.music_tag_lock=true;

				}

				died_time++;
				return true;
			}else{
				
				return false;
			}
		}
		if(p_state.get_current_state().equals("Flying")){
			
				if(PX>510){
					p_state.setArea_X(510);
					
				}
								
				if(PX<20){
					p_state.setArea_X(20);
				}
				if(PY>760 ){
					p_state.setArea_Y(759);
				}
				if(PY<15 ){
					p_state.setArea_Y(15);
				}
				
		}else{
			
		}
		
		return true;
	}	
	public void player_crash(Model m){
		double pW=model.get_W(),pH=model.get_H(),pX=model.get_X(),pY=model.get_Y();
		double RW=411.0,RH=313.0;
		
		
		
		
		
		 if((pY+pH*(10/RH)>model.get_Y())
					&& (pY+pH*(35/RH)<model.get_Y()+model.get_H())
			)
			{

			 	if(
						(
							(pX+pW/2+(pW*(10.5/RW)) >model.get_X())
							&& (pX+pW/2+(pW*(10.5/RW))<model.get_X()+model.get_W()-5)
						)
						||
						(
							(pX+pW/2-(pW*(10.5/RW)) >model.get_X())
							&& (pX+pW/2-(pW*(10.5/RW))<model.get_X()+model.get_W()-5)
						)
					  ){
			 		
						gethurt();
						
					}	
			}
		 
		 else if((pY+pH*(35/RH)>model.get_Y())
					&& (pY+pH*(60/RH)<model.get_Y()+model.get_H())
					)
					{
				
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
						
						gethurt();
						
					}	
				
				
				
			}/*
			else if((pY+pH*(60/RH)>model.get_Y())
					&& (pY+pH*(115/RH)<model.get_Y()+model.get_H())
					){
				System.out.println(pX+pW+(pW*(55.5/RW)));
				System.out.println(pX+pW-(pW*(55.5/RW)));
				System.out.println(model.get_X());
				System.out.println(model.get_X()+model.get_W());
					if(
						(
							(pX+pW+(pW*(55.5/RW)) >model.get_X())
							&& (pX+pW+(pW*(55.5/RW))<model.get_X()+model.get_W())
						)
						||
						(
							(pX+pW-(pW*(55.5/RW)) >model.get_X())
							&& (pX+pW-(pW*(55.5/RW))<model.get_X()+model.get_W())
						)
					  ){
						
						p.gethurt();
						
					}							
			}
			*/
	}
}
