 
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
public abstract class Enemy extends Role{
	protected Image img;
	protected Image Item_img;
	protected ArrayList<Item> item_list = new ArrayList<Item>();
	protected Item item_power;
	protected double shoot_speed;
	protected int shoot_level;
	protected int move_offset;
	protected int life;
	protected Boom boom;

	protected double rotate_clock=1.0;
	public static final double STATIC_OFFSET=5.0;
	public static final double STATIC_ADDSPEED=1.0;
	
	public void moveX(){	
		//System.out.println(model.get_X()+"  "+model.getDirection_DX()+" "+model.get_move_offset()+" "+model.getAddspeed());
		double x=model.get_X()+model.getDirection_DX()*model.get_move_offset()*model.getAddspeed();

		model.setArea_X(x);
		
	}
	public void moveY(){
		
		model.setArea_Y(model.get_Y()+model.getDirection_DY()*model.get_move_offset()*model.getAddspeed());
		//model.setArea_Y(model.get_Y()+model.get_move_offset()*model.getAddspeed());

	}
	public void EnemyBulletCDClear(){
		for(int i=0;i<model.getClip_list().size();i++){
			model.getClip_list().get(i).set_bullet_speed_count(0.0);			
		}
	}
	//public abstract void Enemy_Crash_player();
	public void gethurt(){
		int i=getlife();
			i=i-1;
			model.setLife(i);
			model.setAction_state("Hurt");
		if(i==0){
			double chan=Math.random();
			for(int q=0;q<model.getItemlist().size();q++){
				if(model.getItemlist().get(q).getItemState().getTresure_chance()>0.0){
					model.getItemlist().get(q).getItemState().set_current_state("flying");		
					model.getItemlist().get(q).getItemState().setArea_Y(model.get_Y()+model.get_H()/2);		
					model.getItemlist().get(q).getItemState().setArea_X(model.get_X()+model.get_W()/2);		

				}
			}
			(new Music_Manage()).playboom();
		}else{
			//(new Music_Manage()).playhurt();
		}

	}
	public boolean planeState(){
		Model es=model;
			if(getlife()<=0){
				if(model.getBoom().getItemState().getTresure_chance()==0.0){
					model.getBoom().getItemState().setArea_X(model.get_X()+model.get_W()/2-model.getBoom().getItemState().get_W()/2);
					model.getBoom().getItemState().setArea_Y(model.get_Y()+model.get_H()/2-model.getBoom().getItemState().get_H()/2);
					model.getBoom().getItemState().setTresure_chance(1.0);
					model.getBoom().getItemState().setAction_CD(0.0);

				}
					changeState("Died");
			}
			if(es.get_current_state().equals("Died")){
				return true;
			}else{
				return false;
			}
		
	}
}
