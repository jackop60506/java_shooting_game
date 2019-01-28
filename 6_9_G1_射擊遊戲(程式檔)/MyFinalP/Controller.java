 
import java.awt.*;

import jaco.mp3.player.MP3Player;
import java.io.File;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class Controller extends Thread {
	public int music_tag=0;
	public static boolean music_tag_lock=true;

	public double angle_test;
	//玩家
	public Player player;
	
	//敵人 (Enemy_normal)
	public ArrayList<Enemy_normal> enemy_Normal_list = new ArrayList<Enemy_normal>();
	public int enemy_Normal_list_Max=20;
	//敵人 (Enemy_Rocket)
	public ArrayList<Enemy_Rocket> enemy_Rocket_list = new ArrayList<Enemy_Rocket>();
	public int enemy_Rocket_list_Max=20;
	//敵人 (Enemy_Rocket)
	public ArrayList<Enemy_smile_face> enemy_smile_list = new ArrayList<Enemy_smile_face>();
	public int enemy_smile_list_Max=20;
	
	public ArrayList<Boom> boom_list = new ArrayList<Boom>();
	public int boom_list_Max=62;
	
	public Boss Boss ;
	public Boss2 Boss2 ;
	
	public int Boss_list_Max=10;
	public AImanage aimanage;
	public Flying_type flying_type;
	public boolean playtag;
	public View view;
	public Graphics graphics;
	public boolean gametag;
	public boolean gamefirststart;
	public double enemya=0.0;
	public int dir_change=0;
	public double testingtime=0.0;
	public double change=1.0;
	public boolean stage_check=true;
	public Stage_1 stage_1;
	public Stage_2 stage_2;
	public int Stage_choose=1;
	public boolean win=false;
	public static Music_Manage music_manage;
	public Controller(){
		createItem();
		aimanage=new AImanage();
		flying_type= new Flying_type(aimanage);
		
		stage_1= new Stage_1(aimanage,flying_type,player,enemy_Normal_list,enemy_Rocket_list,enemy_smile_list,Boss);
		stage_2= new Stage_2(aimanage,flying_type,player,enemy_Normal_list,enemy_Rocket_list,enemy_smile_list,Boss2);

		gametag=false;
		gamefirststart=true;
		music_manage = new Music_Manage();
		
	}
	public int  GetPlayerlife(){
		return player.getlife();
	}
	public void Stage_clear(){
		Boss.getItemState().set_current_state("Died");
		Boss2.getItemState().set_current_state("Died");
		Boss2.EnemyBulletCDClear();
		Boss.EnemyBulletCDClear();
		for(int c=0;c<Boss.getItemState().getClip_list().size();c++){
			Clip cc=Boss.getItemState().getClip_list().get(c);
			for(int a=0;a<cc.get_bullet_list().size();a++){
				cc.get_bullet_list().get(a).getItemState().set_current_state("Nothing");
			}
		}
		for(int c=0;c<Boss2.getItemState().getClip_list().size();c++){
			Clip cc=Boss2.getItemState().getClip_list().get(c);
			for(int a=0;a<cc.get_bullet_list().size();a++){
				cc.get_bullet_list().get(a).getItemState().set_current_state("Nothing");
			}
		}
			
			for(int c=0;c<player.getItemState().getClip_list().size();c++){
				Clip cc=player.getItemState().getClip_list().get(c);
				for(int a=0;a<cc.get_bullet_list().size();a++){
					cc.get_bullet_list().get(a).getItemState().set_current_state("Nothing");
				}
			}
		
		
		
		for(int q=0;q<enemy_Normal_list_Max;q++){
			enemy_Normal_list.get(q).getItemState().set_current_state("Died");
			
			for(int c=0;c<enemy_Normal_list.get(q).getItemState().getClip_list().size();c++){
				Clip cc=enemy_Normal_list.get(q).getItemState().getClip_list().get(c);
				for(int a=0;a<cc.get_bullet_list().size();a++){
					cc.get_bullet_list().get(a).getItemState().set_current_state("Nothing");
				}
			}
		}
		
		for(int q=0;q<enemy_Rocket_list_Max;q++){
			enemy_Rocket_list.get(q).getItemState().set_current_state("Died");
			
			for(int c=0;c<enemy_Rocket_list.get(q).getItemState().getClip_list().size();c++){
				Clip cc=enemy_Rocket_list.get(q).getItemState().getClip_list().get(c);
				for(int a=0;a<cc.get_bullet_list().size();a++){
					cc.get_bullet_list().get(a).getItemState().set_current_state("Nothing");
				}
			}
		}
		for(int q=0;q<enemy_smile_list_Max;q++){
			enemy_smile_list.get(q).getItemState().set_current_state("Died");
			
			for(int c=0;c<enemy_smile_list.get(q).getItemState().getClip_list().size();c++){
				Clip cc=enemy_smile_list.get(q).getItemState().getClip_list().get(c);
				for(int a=0;a<cc.get_bullet_list().size();a++){
					cc.get_bullet_list().get(a).getItemState().set_current_state("Nothing");
				}
			}
		}
		
	}
	public boolean checkState(){
		checkBulletState();
		
		boolean g=player.planeState();
		if(g==false){
			gametag=false;
		}
		checkEnemyState();

		return gametag;
	}
	
	public void Stage_run(){		
		//stage_1.Stage_Start();
		//interrupt();.
		//stage_2.Stage_Start();
		
		if(music_tag_lock){
			if(gametag==true){
				if(player.getlife()<=0){
					musicBackground_change(2);
				}else if(stage_1.stage_progress_next==(stage_1.stage_progress.length()-1)
						||
						stage_2.stage_progress_next==(stage_2.stage_progress.length()-1)
				){
					musicBackground_change(1);
				}else{
					musicBackground_change(0);
				}
			}else{
				musicBackground_change(2);
			}
			music_tag_lock=false;
		}

			if(Stage_choose==1){
				
				if(stage_1.Stage_Start()){
					Stage_choose++;
					Stage_clear();
					music_tag_lock=true;
				}
			}else if(Stage_choose==2){
				
				if(stage_2.Stage_Start()){
					Stage_choose++;
					Stage_clear();
					music_tag_lock=true;
					
				}
			}else{
				stage_1.setStagecheck(false);
				stage_2.setStagecheck(false);
				Stage_choose=1;

			}
		
		
	}
	
	public void Dodge(){
		
		
		
	}
	
	public void enemyRocketShoot(){
		for(int q=0;q<enemy_Rocket_list_Max;q++){
			enemy_Rocket_list.get(q).shoot(player);
		}
	}
	public void enemyNormalShoot(){
		for(int q=0;q<enemy_Normal_list_Max;q++){
			enemy_Normal_list.get(q).shoot(player);
		}
	}
	public void playerShoot(){	
		
		player.shoot();
	}
	public void playerShoot2(){
		for(int q=0;q<enemy_Normal_list_Max;q++){
			if(!enemy_Normal_list.get(q).getItemState().get_current_state().equals("Died")){
				player.shoot_type2(enemy_Normal_list.get(q).getItemState());
			}
		}
		for(int c=0;c<enemy_Rocket_list_Max;c++){
			if(!enemy_Rocket_list.get(c).getItemState().get_current_state().equals("Died")){
				player.shoot_type2(enemy_Rocket_list.get(c).getItemState());
			}
		}
		for(int b=0;b<enemy_smile_list_Max;b++){
			if(!enemy_smile_list.get(b).getItemState().get_current_state().equals("Died")){
				player.shoot_type2(enemy_smile_list.get(b).getItemState());
				
			}
		}
	}
	
	public void player_TimeStop(){
		player.player_TimeStop(enemy_Normal_list,enemy_Rocket_list);
	}
	public void checkBoomState(){
		for(int b=0;b<enemy_Normal_list_Max;b++){
			if(enemy_Normal_list.get(b).getItemState().getBoom().getItemState().getAction_CD()>Boom.BOOM_ACTION 
					&&
					enemy_Normal_list.get(b).getItemState().get_current_state().equals("flying")
					){
				
				enemy_Normal_list.get(b).getItemState().getBoom().getItemState().setAction_CD(0.0);
				enemy_Normal_list.get(b).getItemState().getBoom().getItemState().setTresure_chance(0.0);
			}
		}
		for(int b=0;b<enemy_Rocket_list_Max;b++){
			if(enemy_Rocket_list.get(b).getItemState().getBoom().getItemState().getAction_CD()>Boom.BOOM_ACTION 
					&&
					enemy_Rocket_list.get(b).getItemState().get_current_state().equals("flying")
					){
				
				enemy_Rocket_list.get(b).getItemState().getBoom().getItemState().setAction_CD(0.0);
				enemy_Rocket_list.get(b).getItemState().getBoom().getItemState().setTresure_chance(0.0);
			}
		}
		for(int b=0;b<enemy_smile_list_Max;b++){
			if(enemy_smile_list.get(b).getItemState().getBoom().getItemState().getAction_CD()>Boom.BOOM_ACTION 
					&&
					enemy_smile_list.get(b).getItemState().get_current_state().equals("flying")
					){
				
				enemy_smile_list.get(b).getItemState().getBoom().getItemState().setAction_CD(0.0);
				enemy_smile_list.get(b).getItemState().getBoom().getItemState().setTresure_chance(0.0);
			}
		}
	}
	public void checkItemState(){

		Item item=null;
		Model items;
		String b_state_state;
		double b_state_getY;
		double b_state_getX;
		double b_state_getW;
		double b_state_getH;
		for(int q=0;q<enemy_Normal_list_Max;q++){	
			for(int i=0;i<enemy_Normal_list.get(q).getItemState().getItemlist().size();i++){
				if(enemy_Normal_list.get(q).getItemState().getItemlist().get(i).getItemState().get_current_state().equals("flying")){
					item=enemy_Normal_list.get(q).getItemState().getItemlist().get(i);
					items=item.getItemState();
					b_state_state=items.get_current_state();
					b_state_getY=items.get_Y();b_state_getX=items.get_X();
					b_state_getW=items.get_W();b_state_getH=items.get_H();
					//System.out.println("current "+i+" type"+" "+items.getTresure_chance()+" "+b_state_state);
					if(((b_state_getY<-10) || (b_state_getY>930)) && b_state_state.equals("flying")){
						//System.out.println("bottom !!! "+i+" type"+items.getTresure_chance());

						item.changeState("Nothing");
						continue;
					}
					if(item.Item_crash(player)){
						//System.out.println("crash !!! "+i+" type"+items.getTresure_chance());

						item.changeState("Nothing");
						music_manage.playitem();
						(item).Specialtoplane(player);
						continue;
					}
				}
			}
		}
		for(int q=0;q<enemy_Rocket_list_Max;q++){	
			for(int i=0;i<enemy_Rocket_list.get(q).getItemState().getItemlist().size();i++){
				if(enemy_Rocket_list.get(q).getItemState().getItemlist().get(i).getItemState().get_current_state().equals("flying")){
					item=enemy_Rocket_list.get(q).getItemState().getItemlist().get(i);
					items=item.getItemState();
					b_state_state=items.get_current_state();
					b_state_getY=items.get_Y();b_state_getX=items.get_X();
					b_state_getW=items.get_W();b_state_getH=items.get_H();
					if(((b_state_getY<-10) || (b_state_getY>930)) && b_state_state.equals("flying")){
						item.changeState("Nothing");
						continue;
					}
					if(item.Item_crash(player)){
						item.changeState("Nothing");
						music_manage.playitem();

						item.Specialtoplane(player);
						continue;
					}
				}
			}
			
		}
		for(int q=0;q<enemy_smile_list_Max;q++){	
			
			for(int i=0;i<enemy_smile_list.get(q).getItemState().getItemlist().size();i++){
				if(enemy_smile_list.get(q).getItemState().getItemlist().get(i).getItemState().get_current_state().equals("flying")){
					item=enemy_smile_list.get(q).getItemState().getItemlist().get(i);
					items=item.getItemState();
					

					b_state_state=items.get_current_state();
					b_state_getY=items.get_Y();b_state_getX=items.get_X();
					b_state_getW=items.get_W();b_state_getH=items.get_H();
					if(((b_state_getY<-10) || (b_state_getY>930)) && b_state_state.equals("flying")){
						item.changeState("Nothing");

						continue;
					}
					if(item.Item_crash(player)){
						item.changeState("Nothing");
						music_manage.playitem();

						item.Specialtoplane(player);
						continue;
					}
				}
			}			
		}
		
	}
	public void checkBulletState(){
		Bullet b3,b2,b,eb;
		Player p;
		Enemy e,er;
		Model b_state,eb_state,p_state,en_state,er_state;
		ArrayList<Clip> clip_player_list,clip_normal_list,clip_rocket_list;
		Clip cp,cp2,cp3;
		Clip cne;
		Clip cre;
		String b3_state_state,b2_state_state,b_state_state,eb_state_state;
		double b3_state_getY,b2_state_getY,b_state_getY,eb_state_getY;
		double b3_state_getX,b2_state_getX,b_state_getX,eb_state_getX;
		double b3_state_getW,b2_state_getW,b_state_getW,eb_state_getW;
		double b3_state_getH,b2_state_getH,b_state_getH,eb_state_getH;
		
		double e_state_getY,e_state_getX,e_state_getW,e_state_getH;
		double er_state_getY,er_state_getX,er_state_getW,er_state_getH;
		double p_state_getY,p_state_getX,p_state_getW,p_state_getH;;
		p_state=player.getItemState();
		
		clip_player_list=p_state.getClip_list();
		

		cp=p_state.getClip_list().get(0);
		cp2=p_state.getClip_list().get(1);
		cp3=p_state.getClip_list().get(2);
		
		//我方子彈
		for(int c=0;c<clip_player_list.size();c++){
			cp=p_state.getClip_list().get(c);
			for(int i=0;i<cp.bullet_list_MAX;i++){
				b=cp.get_bullet_list().get(i);
				b_state=b.getItemState();b_state_state=b_state.get_current_state();
				b_state_getY=b_state.get_Y();b_state_getX=b_state.get_X();
				b_state_getW=b_state.get_W();b_state_getH=b_state.get_H();
				if(((b_state_getY<-10) || (b_state_getY>930)) && b_state_state.equals("flying")){
					b.changeState("Nothing");
					cp.add_bullet();
					continue;
				}
				for(int q=0;q<enemy_Normal_list_Max;q++){	
					
					e=enemy_Normal_list.get(q);
					e_state_getY=e.getItemState().get_Y();
					e_state_getX=e.getItemState().get_X();
					e_state_getW=e.getItemState().get_W();
					e_state_getH=e.getItemState().get_H();					
					if(b_state_state.equals("flying")){
						 if((b_state_getY>e_state_getY)
								&& (b_state_getY<e_state_getY+((int)(e_state_getH)))
								&& (b_state_getX+((int)(b_state_getW/2))>e_state_getX+10)
								&& (b_state_getX+((int)(b_state_getW/2))<e_state_getX+e_state_getW-3)
								)
						{
							
							b.changeState("Nothing");
							e.gethurt();
							cp.add_bullet();
						}
					}
					
				}
				for(int q=0;q<enemy_Rocket_list_Max;q++){	
					er=enemy_Rocket_list.get(q);
					er_state_getY=er.getItemState().get_Y();
					er_state_getX=er.getItemState().get_X();
					er_state_getW=er.getItemState().get_W();
					er_state_getH=er.getItemState().get_H();					
					if(b_state_state.equals("flying")){
						if((b_state_getY>er_state_getY)
								&& (b_state_getY<er_state_getY+((int)(er_state_getH)))
								&& (b_state_getX+((int)(b_state_getW/2))>er_state_getX)
								&& (b_state_getX+((int)(b_state_getW/2))<er_state_getX+er_state_getW)
								)
						{
							
							b.changeState("Nothing");
							er.gethurt();
							cp.add_bullet();
						}
					}
				}
				for(int q=0;q<enemy_smile_list_Max;q++){	
					
					e=enemy_smile_list.get(q);
					e_state_getY=e.getItemState().get_Y();
					e_state_getX=e.getItemState().get_X();
					e_state_getW=e.getItemState().get_W();
					e_state_getH=e.getItemState().get_H();					
					if(b_state_state.equals("flying")){
						 if((b_state_getY>e_state_getY)
								&& (b_state_getY<e_state_getY+((int)(e_state_getH)))
								&& (b_state_getX+((int)(b_state_getW/2))>e_state_getX+10)
								&& (b_state_getX+((int)(b_state_getW/2))<e_state_getX+e_state_getW-3)
								)
						{
							
							b.changeState("Nothing");
							e.gethurt();
							cp.add_bullet();
						}
					}
					
				}
				e=Boss;
				e_state_getY=e.getItemState().get_Y();
				e_state_getX=e.getItemState().get_X();
				e_state_getW=e.getItemState().get_W();
				e_state_getH=e.getItemState().get_H();					
				if(b_state_state.equals("flying")){
					if(
						(
							(b_state_getY>=e_state_getY)
							&& (b_state_getY<e_state_getY+e_state_getH*0.8625)
						)
						||
						(
							(b_state_getY+b_state_getH>=e_state_getY)
							&& (b_state_getY+b_state_getH<e_state_getY+e_state_getH*0.8625)
								
						)
						
					  ){
						if(
								(
									(b_state_getX>=e_state_getX)
									&& (b_state_getX<e_state_getX+e_state_getW)
								)
								||
								(
										(b_state_getX+b_state_getW>=e_state_getX)
										&& (b_state_getX+b_state_getW<e_state_getX+e_state_getW)	
								)
							 ){
							
							b.changeState("Nothing");
							e.gethurt();
							cp.add_bullet();

						}
						
					}else if(
							((b_state_getY+b_state_getH>=e_state_getY+e_state_getH*0.8625)
							&& (b_state_getY+b_state_getH<=e_state_getY+e_state_getH)
							)
								||
							((b_state_getY>=e_state_getY+e_state_getH*0.8625)
							&& (b_state_getY<=e_state_getY+e_state_getH)
							)
							){
						if(
								(
									(b_state_getX+b_state_getW>=e_state_getX+e_state_getW/2-e_state_getW*0.13)
									&& (b_state_getX+b_state_getW<e_state_getX+e_state_getW/2+e_state_getW*0.213)
								)
								||
								(
									(b_state_getX>=e_state_getX+e_state_getW/2-e_state_getW*0.213)
									&& (b_state_getX<e_state_getX+e_state_getW/2+e_state_getW*0.213)
								)
							 ){
							b.changeState("Nothing");
							e.gethurt();
							cp.add_bullet();
							}
						
					}
				}
				e=Boss2;
				e_state_getY=e.getItemState().get_Y();
				e_state_getX=e.getItemState().get_X();
				e_state_getW=e.getItemState().get_W();
				e_state_getH=e.getItemState().get_H();					
				if(b_state_state.equals("flying")){
					if(
						(
							(b_state_getY>=e_state_getY)
							&& (b_state_getY<e_state_getY+e_state_getH)
						)
						||
						(
							(b_state_getY+b_state_getH>=e_state_getY)
							&& (b_state_getY+b_state_getH<e_state_getY+e_state_getH)
								
						)
						
					  ){
						if(
								(
									(b_state_getX>=e_state_getX)
									&& (b_state_getX<e_state_getX+e_state_getW)
								)
								||
								(
										(b_state_getX+b_state_getW>=e_state_getX)
										&& (b_state_getX+b_state_getW<e_state_getX+e_state_getW)	
								)
							 ){
							
							b.changeState("Nothing");
							e.gethurt();
							cp.add_bullet();

						}
						
					}
				}
				
			}
		}	
		//norma_enemy
		
		for(int q=0;q<enemy_Normal_list_Max;q++){
			e=enemy_Normal_list.get(q);
			en_state=e.getItemState();
			for(int c=0;c<en_state.getClip_list().size();c++){
				cne=en_state.getClip_list().get(c);			
					for(int i=0;i<cne.get_bullet_list_MAX();i++){
						eb=cne.get_bullet_list().get(i);
						eb_state=eb.getItemState();
						eb_state_state=eb_state.get_current_state();
						eb_state_getY=eb_state.get_Y();
						eb_state_getX=eb_state.get_X();
						eb_state_getW=eb_state.get_W();
						eb_state_getH=eb_state.get_H();
						p=player;
						p_state_getY=p.getItemState().get_Y();
						p_state_getX=p.getItemState().get_X();
						p_state_getW=p.getItemState().get_W();
						p_state_getH=p.getItemState().get_H();
							if(eb_state_state.equals("flying")){
								if(eb_state_getY>View.PAINT_HEIGHT ||
								   eb_state_getX<-50 ||
								   eb_state_getY<-50 ||
								   eb_state_getX>View.PAINT_WIDTH ){
									eb.changeState("Nothing");
									cne.add_bullet();
									
								}else if((eb_state_getY>p_state_getY)
										&& (eb_state_getY<p_state_getY+p_state_getH)
										&& (eb_state_getX+((int)(eb_state_getW/2))>p_state_getX)
										&& (eb_state_getX+((int)(eb_state_getW/2))<p_state_getX+p_state_getW)
										)
								{
									
									eb.changeState("Nothing");
									player.gethurt();
									cne.add_bullet();
								}
							}
					}
			}
		}
		for(int q=0;q<enemy_Rocket_list_Max;q++){
			er=enemy_Rocket_list.get(q);
			er_state=er.getItemState();
			for(int c=0;c<er_state.getClip_list().size();c++){
				cre=er_state.getClip_list().get(c);			
				for(int i=0;i<cre.get_bullet_list_MAX();i++){
						eb=cre.get_bullet_list().get(i);
						eb_state=eb.getItemState();
						eb_state_state=eb_state.get_current_state();
						eb_state_getY=eb_state.get_Y();
						eb_state_getX=eb_state.get_X();
						eb_state_getW=eb_state.get_W();
						eb_state_getH=eb_state.get_H();
						p=player;
						p_state_getY=p.getItemState().get_Y();
						p_state_getX=p.getItemState().get_X();
						p_state_getW=p.getItemState().get_W();
						p_state_getH=p.getItemState().get_H();
							if(eb_state_state.equals("flying")){
								if(eb_state_getY>View.PAINT_HEIGHT ||
								   eb_state_getX<-50 ||
								   eb_state_getY<-50 ||
								   eb_state_getX>View.PAINT_WIDTH ){
									eb.changeState("Nothing");
									cre.add_bullet();
									
								}else if((eb_state_getY>p_state_getY)
										&& (eb_state_getY<p_state_getY+p_state_getH)
										&& (eb_state_getX+((int)(eb_state_getW/2))>p_state_getX)
										&& (eb_state_getX+((int)(eb_state_getW/2))<p_state_getX+p_state_getW)
										)
								{
									
									eb.changeState("Nothing");
									player.gethurt();
									cre.add_bullet();
								}
							}
					}
			}
		}
		for(int q=0;q<enemy_smile_list_Max;q++){
			er=enemy_smile_list.get(q);
			er_state=er.getItemState();
			for(int c=0;c<er_state.getClip_list().size();c++){
				cre=er_state.getClip_list().get(c);			
				for(int i=0;i<cre.get_bullet_list_MAX();i++){
						eb=cre.get_bullet_list().get(i);
						eb_state=eb.getItemState();
						eb_state_state=eb_state.get_current_state();
						eb_state_getY=eb_state.get_Y();
						eb_state_getX=eb_state.get_X();
						eb_state_getW=eb_state.get_W();
						eb_state_getH=eb_state.get_H();
						p=player;
						p_state_getY=p.getItemState().get_Y();
						p_state_getX=p.getItemState().get_X();
						p_state_getW=p.getItemState().get_W();
						p_state_getH=p.getItemState().get_H();
							if(eb_state_state.equals("flying")){
								if(eb_state_getY>View.PAINT_HEIGHT ||
								   eb_state_getX<-50 ||
								   eb_state_getY<-50 ||
								   eb_state_getX>View.PAINT_WIDTH ){
									eb.changeState("Nothing");
									cre.add_bullet();
									
								}else if((eb_state_getY>p_state_getY)
										&& (eb_state_getY<p_state_getY+p_state_getH)
										&& (eb_state_getX+((int)(eb_state_getW/2))>p_state_getX)
										&& (eb_state_getX+((int)(eb_state_getW/2))<p_state_getX+p_state_getW)
										)
								{
									
									eb.changeState("Nothing");
									player.gethurt();
									cre.add_bullet();
								}
							}
					}
			}
		}
		e=Boss;
		e_state_getY=e.getItemState().get_Y();
		e_state_getX=e.getItemState().get_X();
		e_state_getW=e.getItemState().get_W();
		e_state_getH=e.getItemState().get_H();
		for(int c=0;c<e.getItemState().getClip_list().size();c++){
		cre=e.getItemState().getClip_list().get(c);			
		for(int i=0;i<cre.get_bullet_list_MAX();i++){
			eb=cre.get_bullet_list().get(i);
			eb_state=eb.getItemState();
			eb_state_state=eb_state.get_current_state();
			eb_state_getY=eb_state.get_Y();
			eb_state_getX=eb_state.get_X();
			eb_state_getW=eb_state.get_W();
			eb_state_getH=eb_state.get_H();
			p=player;
			p_state_getY=p.getItemState().get_Y();
			p_state_getX=p.getItemState().get_X();
			p_state_getW=p.getItemState().get_W();
			p_state_getH=p.getItemState().get_H();
				if(eb_state_state.equals("flying")){
					if(eb_state_getY>View.PAINT_HEIGHT ||
					   eb_state_getX<-50 ||
					   eb_state_getY<-50 ||
					   eb_state_getX>View.PAINT_WIDTH ){
						eb.changeState("Nothing");
						cre.add_bullet();
						
					}
					else{
						boolean check=eb.bullet_crash(player);
						if(check){
							eb.changeState("Nothing");
							player.gethurt();
							cre.add_bullet();
						}
					}
				}
			}	
		}
		e=Boss2;
		e_state_getY=e.getItemState().get_Y();
		e_state_getX=e.getItemState().get_X();
		e_state_getW=e.getItemState().get_W();
		e_state_getH=e.getItemState().get_H();
		for(int c=0;c<e.getItemState().getClip_list().size();c++){
		cre=e.getItemState().getClip_list().get(c);			
		for(int i=0;i<cre.get_bullet_list_MAX();i++){
			eb=cre.get_bullet_list().get(i);
			eb_state=eb.getItemState();
			eb_state_state=eb_state.get_current_state();
			eb_state_getY=eb_state.get_Y();
			eb_state_getX=eb_state.get_X();
			eb_state_getW=eb_state.get_W();
			eb_state_getH=eb_state.get_H();
			p=player;
			p_state_getY=p.getItemState().get_Y();
			p_state_getX=p.getItemState().get_X();
			p_state_getW=p.getItemState().get_W();
			p_state_getH=p.getItemState().get_H();
				if(eb_state_state.equals("flying")){
					if(eb_state_getY>View.PAINT_HEIGHT ||
					   eb_state_getX<-50 ||
					   eb_state_getY<-50 ||
					   eb_state_getX>View.PAINT_WIDTH ){
						eb.changeState("Nothing");
						cre.add_bullet();
						
					}
					else{
						boolean check=eb.bullet_crash(player);
						if(check){
							eb.changeState("Nothing");
							player.gethurt();
							cre.add_bullet();
						}
					}
				}
			}	
		}
	}
	public void musicBackground_change(int tag){
			switch(tag){
				case 0:music_manage.playbackground(0);break;
				case 1:music_manage.playbackground(1);break;
				case 2:music_manage.playbackground(2);break;
			}
	}
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
	}
	public void checkEnemyState(){	
		boolean alldead=true;
		for(int q=0;q<enemy_Normal_list_Max;q++){
			if(enemy_Normal_list.get(q).planeState()==false){
				alldead=false;
			}
			enemy_Normal_list.get(q).plane_crash(player);
		}
		
		for(int q=0;q<enemy_Rocket_list_Max;q++){	
			if(enemy_Rocket_list.get(q).planeState()==false){
				alldead=false;
			}
			enemy_Rocket_list.get(q).plane_crash(player);
			
		}
		for(int q=0;q<enemy_smile_list_Max;q++){	
			if(enemy_smile_list.get(q).planeState()==false){
				alldead=false;
			}
			enemy_smile_list.get(q).plane_crash(player);
			
		}
		Boss.plane_crash(player);
		Boss.planeState();
		Boss2.plane_crash(player);
		Boss2.planeState();
		
		
		if(alldead==true){
			//gameReset();
		}
	}
	public void playerX(Direction d){
		player.moveX(d);
	}
	public void playerY(Direction d){
		player.moveY(d);
	}
	public void player_request(String s){
		
		player.changeState(s);
	}
	public void gameReset(){
		music_tag_lock=true;

		gametag=true;
		stage_1.setStagecheck(false);
		stage_2.setStagecheck(false);
		stage_1.setProgress1(1);
		stage_1.setProgress2(1);
		stage_2.setProgress1(1);
		
		stage_1.Stageclear();
		stage_2.Stageclear();
	
		Stage_choose=1;
		player.getItemState().setLife(5);
		player.getItemState().set_current_state("Nothing");
		player.getItemState().setShootlevel(1);
		player.getItemState().setArea_X(300);
		player.getItemState().setArea_Y(600);
		player.died_time=0.0;
		player.died_lock=true;
		Stage_clear();
		

		
	}
	public void gameStart(){
		if(gamefirststart==false){
			gameReset();
		}
		gametag=true;
	}
	public void gamePause(){
		gametag=false;
		
	}
	public void display(Graphics g){
		if(gametag==true){	
			gamefirststart=false;
			Boss.display(g);
			Boss2.display(g);
			for(int q=0;q<enemy_Rocket_list_Max;q++){
				enemy_Rocket_list.get(q).display(g);;
			}
			for(int q=0;q<enemy_Normal_list_Max;q++){
				enemy_Normal_list.get(q).display(g);
			}
			for(int q=0;q<enemy_smile_list_Max;q++){
				enemy_smile_list.get(q).display(g);
			}
			
			
			player.display(g);
		}else{
			if(gamefirststart==true){
				g.setColor(Color.yellow);
				g.setFont(new Font("consolas", Font.BOLD|Font.PLAIN , 45));
				g.drawString("G1 Shooting game!!!!!!!!!", 30,300);
				g.setColor(Color.yellow);
				g.setFont(new Font("consolas", Font.BOLD|Font.PLAIN , 45));
				g.drawString("Press Enter", 130,700);
				g.setFont(new Font("consolas", Font.BOLD|Font.PLAIN , 30));
				g.setColor(Color.cyan);
				g.drawString("Key    is shooting", 130,500);
				g.setColor(Color.red);
				g.drawString("z", 200,500);
				g.drawString("up down right left", 100,600);
				g.setColor(Color.cyan);
				g.drawString("Key                       are move", 0,600);
			}else if(player.getItemState().getLife()==0){
				g.setColor(Color.cyan);
				g.setFont(new Font("consolas", Font.BOLD|Font.PLAIN , 30));
				g.drawString("You Dead! ", 250, 300);
				g.drawString("press start restart game",100, 450);
			}
		}
	}
	public void createItem(){
		
		player= new Player();
		
		Boss= new Boss();
		Boss2= new Boss2();

		for(int q=0;q<enemy_Rocket_list_Max;q++){
			enemy_Rocket_list.add(new Enemy_Rocket());
		}
		for(int q=0;q<enemy_Normal_list_Max;q++){
			enemy_Normal_list.add(new Enemy_normal());
			
		}
		for(int q=0;q<enemy_smile_list_Max;q++){
			enemy_smile_list.add(new Enemy_smile_face());
		}
	}
	public static void CreateAndShowGUI(){
		Controller controller = new Controller();
		View view = new View(controller);
		//music_manage.playbackground(3);
		
		//controller.start();
	}
	public static void main(String args[]){
     java.awt.EventQueue.invokeLater(new Runnable() {
    	 public void run() {
    		 CreateAndShowGUI();
    	 }
     });
    }
}