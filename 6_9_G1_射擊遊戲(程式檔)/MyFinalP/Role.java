 
import java.awt.*;
import java.util.ArrayList;

public abstract class Role {
	Model model;
	double X,Y,Width,Height,angle;
	String CurrentState;
	double addspeed=1.0;
	protected double dx;
	protected double dy;
	public ArrayList<Shadow> shadow_list = new ArrayList<Shadow>();
	protected Music_Manage music_manage;
	public abstract void display(Graphics g);
	
	public Model getItemState(){
		return model;
	}
	public void changeState(String s){
		model.set_current_state(s);
	}
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
	}
	public void moveX(){		
		double x=model.get_X()+model.getDirectionX().getX()*model.get_move_offset();
		model.setArea_X(x);
		
	}
	public void moveY(){
		model.setArea_Y(model.get_Y()+model.getDirectionY().getY()*model.get_move_offset());

	}
	public int getlife(){
		return model.getLife();
	}
	public void gethurt(){
		int i=getlife();
		i=i-1;
		model.setLife(i);
	}
	
}

