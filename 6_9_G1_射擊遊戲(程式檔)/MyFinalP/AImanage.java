 

import javax.swing.Timer;

public class AImanage {
	Enemy b;
	int Enemy_time_delay;
	public int COOLDOWN=100;
	public int cooldown=0;
	public static boolean command_use_nouse=true;
	public static boolean lock=false;
	public AImanage(){
		
	}
	public void Coersion_position(){
		
	}
	public void Enemy_action_pause_regular(Enemy e, double stops){
		
		Model e_state=e.getItemState();
		
		if(e_state.getAction_CD()>stops/2 && e_state.getAction_CD()<stops){
			
			e_state.set_move_offset(0);
			
		}else if(e_state.getAction_CD()<stops/2 && e_state.getAction_CD()>=0.0){
			
			e_state.set_move_offset(5);
			
		}else if(e_state.getAction_CD()>stops){
			e_state.setAction_CD(0.0);
		}
		e_state.setAction_CD(e_state.getAction_CD()+1.0);
		
	}
	public void Enemy_action_pause_regular_shoot(Enemy e, double stops,Player player){
		
		Model e_state=e.getItemState();
		
		if(e_state.getAction_CD()>stops/2 && e_state.getAction_CD()<stops){
			((Enemy_smile_face)e).shoot(player);

			e_state.set_move_offset(0);
			
		}else if(e_state.getAction_CD()<stops/2 && e_state.getAction_CD()>=0.0){
			
			e_state.set_move_offset(5);
			
		}else if(e_state.getAction_CD()>stops){
			e_state.setAction_CD(0.0);
		}
		e_state.setAction_CD(e_state.getAction_CD()+1.0);
		
	}
	public void Enemy_action_stop(Enemy e){
		Model e_state=e.getItemState();
		e_state.set_move_offset(0);
	}
	public void recover(Enemy e){
		Model e_state=e.getItemState();
		e_state.set_move_offset(Enemy.STATIC_OFFSET);
	}
	public void Enemy_Move_down(Enemy e){
		Model e_state=e.getItemState();
		e_state.setDirection_DY(1.0);
		e.moveY();
	}
	public void Enemy_Move_up(Enemy e){
		Model e_state=e.getItemState();
		e_state.setDirection_DY(-1.0);
		e.moveY();
	}
	public void Enemy_Move_left(Enemy e){
		Model e_state=e.getItemState();
		e_state.setDirection_DX(-1.0);
		e.moveX();
	}
	public void Enemy_Move_right(Enemy e){
		Model e_state=e.getItemState();
		e_state.setDirection_DX(1.0);
		e.moveX();
	}
	public void Enemy_Move_diagonal(Enemy e){
		Model e_state=e.getItemState();
		String e_state_state=e.getItemState().get_current_state();
		double e_state_getY=e_state.get_Y();
		double e_state_getX=e_state.get_X();
		double e_state_getW=e_state.get_W();
		double e_state_getH=e_state.get_H();
		
		e.moveX();
		
	}
	public void Enemy_Move_all(Enemy e){
		Model e_state=e.getItemState();
		String e_state_state=e.getItemState().get_current_state();
		double e_state_getY=e_state.get_Y();
		double e_state_getX=e_state.get_X();
		double e_state_getW=e_state.get_W();
		double e_state_getH=e_state.get_H();
		if(e_state_getX>500 || e_state_getX<50){
			if(e_state.getDirection_DX()==-1.0){
				e_state.setDirection_DX(1.0);
			}else{
				e_state.setDirection_DX(-1.0);
			}
		}

		if(e_state_getY>=350.0 ||e_state_getY<=0.0){
			if(e_state.getDirection_DY()==-1.0){
				e_state.setDirection_DY(1.0);
			}else{
				e_state.setDirection_DY(-1.0);
			}
		}
		e.moveX();
		e.moveY();
		//e_state.setArea_X(e_state.get_X()+e_state.get_move_offset()*e_state.getDirectionX().getX());
		//e_state.setArea_Y(e_state.get_Y()+e_state.get_move_offset()*e_state.getDirectionY().getY());
		
	}
	public void Enemy_Move_leftright(Enemy e){
		Model e_state=e.getItemState();
		String e_state_state=e.getItemState().get_current_state();
		double e_state_getY=e_state.get_Y();
		double e_state_getX=e_state.get_X();
		double e_state_getW=e_state.get_W();
		double e_state_getH=e_state.get_H();
		
		if(e_state_getX>550 || e_state_getX<0){
			if(e_state.getDirection_DX()==-1.0){
				e_state.setDirection_DX(1.0);
				
			}else{
				e_state.setDirection_DX(-1.0);
			}
		}
			
		e.moveX();
		
	}
	public void Enemy_Move_updown(Enemy e){
		Model e_state=e.getItemState();
		String e_state_state=e.getItemState().get_current_state();
		double e_state_getY=e_state.get_Y();
		double e_state_getX=e_state.get_X();
		double e_state_getW=e_state.get_W();
		double e_state_getH=e_state.get_H();
		
		if(e_state_getY>550 || e_state_getY<0){
			if(e_state.getDirection_DY()==-1.0){
				e_state.setDirection_DY(1.0);
				
			}else{
				e_state.setDirection_DY(-1.0);
			}
		}
		e.moveY();
		
	}
	public void Enemy_state_clear(Enemy e){
		e.getItemState().setAction_CD(0.0);
		
	}
	public void Enemy_Move_face(Enemy e){
		Model es=e.getItemState();
		
		double Xoffset=(Math.sin(
				Math.toRadians(es.getAngle()+180)
				));
		
	    double Yoffset=(Math.cos(
	    		Math.toRadians(es.getAngle()+180)
	    		));
		es.setDirection_DX(Xoffset);
		es.setDirection_DY(Yoffset);
		e.moveX();
		e.moveY();
	}
	public void add_speed(Enemy e,double add){
		Model e_state=e.getItemState();
		e_state.setAddspeed(e_state.getAddspeed()+add);
	
	}
	public void toWhere_diagonal(Enemy e , double x, double y){
		
	}

	public void Current_rotate(Enemy e,double sep){
		
		Model es=e.getItemState();
		double Xoffset,Yoffset,bsetx,bsety,prex,prey,angle;	
		 prex=es.get_X()+(es.get_W()/2);	 
		 prey=es.get_Y()+(es.get_H()/2);
		// bsetx=es.get_X()+(es.get_W()/2)+0.01;	 
		 //bsety=es.get_Y()+(es.get_H()/2)+0.01;
									
		
		if(es.getAngle()>360){
			es.setAngle(es.getAngle()%360);
		}
		 es.setAngle(es.getAngle()+sep*es.getRotateclock());
		
		//System.out.println(es.getAngle());
		//只差方向設定
		Xoffset=(Math.sin(
				Math.toRadians(es.getAngle()+180)
				));
		
	    Yoffset=(Math.cos(
	    		Math.toRadians(es.getAngle()+180)
	    		));
		 	es.setDirection_DX(Xoffset);
	 		es.setDirection_DY(Yoffset);
	    
		//e.moveX();
		//e.moveY();
	
	}
	
	public void Dynamic_look(Enemy e,Player p){
		 Model es=e.getItemState();
		 Model ps=p.getItemState();
		double bsetx=es.get_X()+es.get_W()/2;
		double bsety=es.get_Y()+es.get_H()/2;
			
		double angle=get_Angle(
				bsetx,
				bsety,
				ps.get_X()+ps.get_W()/2,
				ps.get_Y()+ps.get_H()/2);
		es.setAngle(angle);
	}	
	
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
	}
	public boolean tosomewhere(Enemy e,double ex,double ey,double X,double Y,double speed,boolean slow){
		boolean check=true;
		Model es=e.getItemState();
		 double bullet_angle=get_Angle(ex,ey,X,Y);

		double Xoffset=(Math.sin(
				Math.toRadians(bullet_angle+180)
				));
		
	    double Yoffset=(Math.cos(
	    		Math.toRadians(bullet_angle+180)
	    		));	    
	    if((((double)Math.abs(ex-X))<=12.0)
	    	&&
	    	(((double)Math.abs(ey-Y))<=12.0)
	    	){
	    	e.getItemState().setArea_X(X);
	    	e.getItemState().setArea_Y(Y);

	    }else
	    {
	    	
	    	if(Math.abs(ex-X)>100.0 
	    			||
	    	   Math.abs(ey-Y)>100.0
	    			){
		    	e.getItemState().setAddspeed(speed);

	    	}else if(Math.abs(ex-X)<100.0
	    			||
	 	    	   Math.abs(ey-Y)<100.0){
	    		if(slow==true){
		    		e.getItemState().setAddspeed(speed/8);

	    		}else{
		    		e.getItemState().setAddspeed(speed);

	    		}
	    	}
	    	if(Math.abs(ex-X)>12.0){
	    		e.getItemState().setDirection_DX(Xoffset);
				e.moveX();
	    	}
	    	if( Math.abs(ey-Y)>12.0){
	    		e.getItemState().setDirection_DY(Yoffset);
				e.moveY();
	    	}
	    	
	    	  
	    	
			
	    	check=false;
	    	
	    }
		return check;
	}
	public boolean tosomewhere(Shadow e,double ex,double ey,double X,double Y,double speed,boolean slow){
		boolean check=true;
		Model es=e.getItemState();
		 double bullet_angle=get_Angle(ex,ey,X,Y);

		double Xoffset=(Math.sin(
				Math.toRadians(bullet_angle+180)
				));
		
	    double Yoffset=(Math.cos(
	    		Math.toRadians(bullet_angle+180)
	    		));	    
	    if((((double)Math.abs(ex-X))<=12.0)
	    	&&
	    	(((double)Math.abs(ey-Y))<=12.0)
	    	){
	    	e.getItemState().setArea_X(X);
	    	e.getItemState().setArea_Y(Y);

	    }else
	    {
	    	
	    	if(Math.abs(ex-X)>100.0 
	    			||
	    	   Math.abs(ey-Y)>100.0
	    			){
		    	e.getItemState().setAddspeed(speed);

	    	}else if(Math.abs(ex-X)<100.0
	    			||
	 	    	   Math.abs(ey-Y)<100.0){
	    		if(slow==true){
		    		e.getItemState().setAddspeed(speed/8);

	    		}else{
		    		e.getItemState().setAddspeed(speed);

	    		}
	    	}
	    	if(Math.abs(ex-X)>12.0){
	    		e.getItemState().setDirection_DX(Xoffset);
				e.moveX();
	    	}
	    	if( Math.abs(ey-Y)>12.0){
	    		e.getItemState().setDirection_DY(Yoffset);
				e.moveY();
	    	}
	    	
	    	  
	    	
			
	    	check=false;
	    	
	    }
		return check;
	}
	public boolean tosomeangle(Enemy e,double angle){
		boolean check=true;
		Model es=e.getItemState();
	   
		return check;
	}
	
	public void Time_delay(){
		
	}
	
}
