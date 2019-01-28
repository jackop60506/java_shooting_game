 

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Boss2 extends Enemy {
private ImageSequence_enemy ims_enemy;
	
	//public Clip_normal_enemy ce;
	public static boolean Boss_CANATTACK=false;

	private ArrayList<Clip> clip_list;
	private int CLIP_NUMBER=16;
	public static final double REAL_WIDTH=120;
	public static final double REAL_HEIGHT=120;
	public static final double SKILL1_t=35;
	public static final double SKILL2_t=60;

	public final double ACTION_CD=5.0;
	public static int BOSS2_LIFE=800;
	public static final double BLOODLENGTH=BOSS2_LIFE/REAL_WIDTH;

	public double action_cd_count=0.0;
	private double cantattack_cd=0;
	private double CANTATTACK_CD=2.0;
	private double CANTATTACK_CD_SEP=1.0;
	private String Action_state="NotHurt";
	private double testan=0.0;
	private Special_affect special_affect;
	protected Shoot_type shoot_type;

	public Boss2(){
		X=-500.0;
		Y=-500.0;
		Width=REAL_WIDTH;
		Height=REAL_HEIGHT;
		CurrentState="Died";
		shoot_speed=10;
		move_offset=5;
		life=10;
		dx=0.0;
		dy=1.0;
		shoot_level=1;
		clip_list = new ArrayList<Clip>();
		for(int i=0;i<CLIP_NUMBER;i++){
			
				clip_list.add(new Clip_boss(2));
			
		}
		try{
			img= ImageIO.read(new File("pic/boss3_0.png"));
		}catch(Exception e){
			System.out.println(12334);
		}
		boom=new Boom(300,300);

		shadow_list.add(new Shadow(Width,Height,X,Y,img));
		shadow_list.add(new Shadow(Width,Height,X,Y,img));
		
		ims_enemy = new ImageSequence_enemy();
		music_manage = new Music_Manage();
		shoot_type= new Shoot_type(music_manage);
		angle=180.0;
		model=new Model(boom,shadow_list,shoot_type,rotate_clock,addspeed,ims_enemy,Action_state,cantattack_cd,action_cd_count,angle,clip_list,shoot_speed,move_offset,X,Y,Width,Height,dx,dy,CurrentState,life,null);
		//special_affect= new Special_affect(model);

	
		special_affect =  new Special_affect();
	}
	public void display(Graphics g){
		model.getBoom().display(g);

		for(int q=0;q<CLIP_NUMBER;q++){
			Clip_boss cl=(Clip_boss)model.getClip_list().get(q);
			for(int i=0;i<cl.get_bullet_list_MAX();i++){
				cl.get_bullet_list().get(i).display(g);
			}
		}
		/*
		for(int c=0;c<model.getShadow().size();c++){
			
			special_affect.shadow(this,model.getShadow().get(c),c*1.6+7.0);
			shadow_list.get(c).display(g);
		}
		*/
		Graphics2D g2 = (Graphics2D)g;
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)1.0);
		
		g2.setComposite(ac);
		
		AffineTransform at = new AffineTransform();
		
		double preX=(int)model.get_X()+(model.get_W()/2);
		double preY=(int)model.get_Y()+(model.get_H()/2);
		at.translate(preX,preY);
		double angle =(((model.getAngle()/180)*Math.PI)+(1.0*Math.PI))*-1;

		at.rotate(angle);
		
		at.scale(1.0,1.0);
		at.translate(-model.get_W()/2,-model.get_H()/2);
		g2.drawImage(img, at, null);

		if(model.get_current_state().equals("Died")){
			model.setArea_X(-500);model.setArea_Y(-500);
		}else if(model.get_current_state().equals("Nothing")){
			
		}
		
		
		Rectangle2D myRect = new Rectangle2D.Double(0, -30, model.getLife()/BLOODLENGTH,(int)(model.get_H()/10));
		g2.setPaint(Color.RED);
	
	
		
	
		AffineTransform.getRotateInstance(Math.PI/4, 150, 150);
		Shape rotatedRect = at.createTransformedShape(myRect);
		
		
		if(model.getAction_state().equals("Hurt") && model.getCantattack_CD()<CANTATTACK_CD){
			CantAttack(true);
		}else{
			CantAttack(false);
		}
		g2.draw(rotatedRect);
		g2.fill(rotatedRect);
		g2.setColor(Color.RED);
		//special_affect.shadow(model,g,img);
		//special_affect.Useshadow(model,angle);
	}
	public void shoot(Player p,int tag){
		switch(tag){
			case 0:model.getShootType().Shoot_normal(model, 2);break;
			case 1:model.getShootType().Shoot_normal(model, 3);break;
			case 2:model.getShootType().Shoot_tosomeone(this, p);break;	
			case 4:model.getShootType().Shoot_normal(model, 4);break;	
			case 8:model.getShootType().Shoot_normal(model, 8);break;
			case 82:model.getShootType().Shoot_normal(model, 82);break;
			case 16:model.getShootType().Shoot_normal(model, 16);break;
		}
		
	}
	public void gethurt(){
		if(Boss_CANATTACK)
		{
		int i=getlife();
			i=i-1;
			if(i==0){
				music_manage.playBossBoom();
			}
			model.setLife(i);
			model.setAction_state("Hurt");
		}
	}
	public void shoot(int tag,double s_angle){
		switch(tag){
			case 41:model.getShootType().Boss2_Shoot_to_angle(this,s_angle,41);break;
			case 42:model.getShootType().Boss2_Shoot_to_angle(this,s_angle,42);break;
			case 43:model.getShootType().Boss2_Shoot_to_angle(this,s_angle,43);break;
			case 20:model.getShootType().Boss2_Shoot_to_normal(this,s_angle);break;

			//case 3:model.getShootType().Boss2_Shoot_to_angle(this,s_angle);break;
			//case 2:model.getShootType().BossShoot_right_Y(this,s_angle);break;

		}
	}
	
	public void CantAttack(boolean t){
		
		if(t==true){
			model.setCantattack_CD(model.getCantattack_CD()+CANTATTACK_CD_SEP);
			img=model.getimsEnmey().nextBoss2enemyImage();
		}else{
			model.setCantattack_CD(0);
			model.setAction_state("NotHurt");
			img=model.getimsEnmey().getBoss2enemyImage(0);
		}		
	}
	public void plane_crash(Player p){
		Model plane=p.getItemState();		
		double pW=plane.get_W(),pH=plane.get_H(),pX=plane.get_X(),pY=plane.get_Y();
		double RW=411.0,RH=313.0;
				
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
		 		
					p.gethurt();
					
				}	
		}
		if(
					(
					(pY+pH*(35/RH)>model.get_Y())
					&& (pY+pH*(35/RH)<model.get_Y()+model.get_H())
					)
					||
					(
							(pY+pH*(60/RH)>model.get_Y())
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
			 		
						p.gethurt();
						
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
		 		
					p.gethurt();
					
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
						(pX+pW/2+(pW*(205.5/RW)) >model.get_X())
						&& (pX+pW/2+(pW*(205.5/RW))<model.get_X()+model.get_W())
					)
					||
					(
						(pX+pW/2-(pW*(205.5/RW)) >model.get_X())
						&& (pX+pW/2-(pW*(205.5/RW))<model.get_X()+model.get_W())
					)
				  ){
		 		
					p.gethurt();
					
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
		 		
					p.gethurt();
					
				}	
		}
		//---------------------------
		
	}
}
