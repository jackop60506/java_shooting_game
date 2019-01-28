 

import java.util.ArrayList;

public class Model {
	private double area_X,area_Y;
	private double width,height;
	private double move_offset;
	private double ddX,ddY;
	private double shoot_speed;
	private int life;
	private String currentState;
	private String actionState;
	private ImageSequence_plane ims_plane;
	private ImageSequence_enemy ims_enemy;
	private Direction direction;
	private Direction directionX,directionY;
	private Clip clip,clip2,clip3;
	private ArrayList<Clip> clip_list;
	private ArrayList<Item> item_list;
	private int BulletType;
	private double angle;
	private double action_cd;
	private double skill_sshoot_cd;
	private int shoot_level;
	private Shoot_type shoot_type;
	private double cant_attack;
	private double addspeed;
	private double rotate_clock;
	private double tresure_chance;
	private ArrayList<Shadow> shadow;
	private Boom boom;

	//plane
	public Model(Boom bo,ArrayList<Shadow> s,double addspeed,String act_state,double cat,Shoot_type st,int sl,double sss_cd,ArrayList<Clip> cpl,Direction dt,double ss,double move_offset,double X,double Y,double W,
			double H,String cs,ImageSequence_plane imsplane,int lf){
		boom=bo;
		shadow=s;
		actionState=act_state;
		cant_attack=cat;
		shoot_type=st;
		skill_sshoot_cd=sss_cd;
		area_X=X;area_Y=Y;
		width=W;height=H;
		this.move_offset=move_offset;
		currentState=cs;
		ims_plane=imsplane;
		shoot_speed=ss;
		life=lf;
		direction=dt;
		shoot_level=sl;
		this.addspeed=addspeed;
		clip_list=cpl;
	}
	//enemy
	public Model(Boom bo,ArrayList<Shadow> s,Shoot_type shoot_type,double rot_clo,double addspeed,ImageSequence_enemy imse,String act_state,double cat,double action_cd,double an,ArrayList<Clip> cpl,double ss,double move_offset,double X,double Y,double W,double H,
			double dx,double dy,String cs,int lf,ArrayList<Item> i_list){
		shadow=s;
		boom=bo;
		ims_enemy=imse;
		actionState=act_state;
		cant_attack=cat;
		this.action_cd=action_cd;
		area_X=X;area_Y=Y;
		width=W;height=H;
		this.move_offset=move_offset;
		currentState=cs;
		life=lf;
		shoot_speed=ss;
		ddX=dx;
		ddY=dy;
		angle=an;
		this.addspeed=addspeed;
		rotate_clock=rot_clo;
		this.shoot_type=shoot_type;
		item_list= i_list;
		clip_list=cpl;
	}
	//bullet
	public Model(double addspeed,double ane,double move_offset,double X,double Y,double W,double H,
			double dx,double dy,String cs,ImageSequence_plane imsplane,double action_cd){
		area_X=X;area_Y=Y;
		width=W;height=H;
		this.move_offset=move_offset;
		currentState=cs;
		ims_plane=imsplane;
		ddX=dx;
		ddY=dy;
		angle=ane;
		this.addspeed=addspeed;
		this.action_cd=action_cd;

	}
	//item
	public Model(double addspeed,double ane,double move_offset,double X,double Y,double W,double H,
			double dx,double dy,String cs,ImageSequence_plane imsplane,double action_cd,double tch){
		area_X=X;area_Y=Y;
		width=W;height=H;
		this.move_offset=move_offset;
		currentState=cs;
		ims_plane=imsplane;
		ddX=dx;
		ddY=dy;
		angle=ane;
		this.addspeed=addspeed;
		this.action_cd=action_cd;
		tresure_chance=tch;
	}
	public Boom getBoom(){return boom;}
	
	public ArrayList<Shadow>  getShadow(){return shadow;}
	public double    getTresure_chance(){return tresure_chance;}
	public void     setTresure_chance(double tch){tresure_chance=tch;}
	public void    setItemlist(ArrayList<Item> as){item_list=as;}
	public ArrayList<Item>  getItemlist(){return item_list;}
	public double  getRotateclock(){return addspeed;}
	public void    setAddspeed(double as){addspeed=as;}
	public double  getAddspeed(){return addspeed;}
	public void    setAction_state(String as){actionState=as;}
	public String  getAction_state(){return actionState;}
	public void    setCantattack_CD(double a){cant_attack=a;}
	public double  getCantattack_CD(){return cant_attack;}
	public Shoot_type  getShootType(){return shoot_type;}
	public void    setShootType(Shoot_type st){shoot_type=st;}
	public int     getShootlevel(){return shoot_level;}
	public void    setShootlevel(int sl){shoot_level=sl;}
	public double getAction_CD(){return action_cd;}
	public void   setAction_CD(double a){action_cd=a;}
	public double getAngle(){return angle;}
	public void   setAngle(double a){angle=a;}
	public ArrayList<Clip>   getClip_list(){return clip_list;}

	public Clip   getClip(){return clip;}
	public Clip   getClip2(){return clip2;}
	public Clip   getClip3(){return clip3;}
	public int    getBulletType(){return BulletType;}
	public void   setLife(int l){life=l;}
	public int    getLife(){return life;}
	public double    get_shoot_speed(){return shoot_speed;}
	public void   set_shoot_speed(double ss){shoot_speed=ss;}
	public String get_current_state(){return currentState;}
	public void   set_current_state(String s){currentState=s;}
	public double    get_move_offset(){return move_offset;}
	public void   set_move_offset(double s){move_offset=s;}
	
	public ImageSequence_plane getimsPlane(){return ims_plane;}
	public ImageSequence_enemy getimsEnmey(){return ims_enemy;}
	
	
	//bullet
	public void setDirection_DY(double d){ddY=d;}
	public double getDirection_DY(){return ddY;}
	public void setDirection_DX(double d){ddX=d;}
	public double getDirection_DX(){return ddX;}
	//player
	public void setDirection(Direction d){direction=d;}
	public Direction getDirection(){return direction;}
	
	//enemy
	public void setDirectionY(Direction d){directionY=d;}
	public Direction getDirectionY(){return directionY;}
	public void setDirectionX(Direction d){directionX=d;}
	public Direction getDirectionX(){return directionX;}
	
	public void setArea_X(double x){area_X=x;}
	public void setArea_Y(double y){area_Y=y;}
	public void setWidth(double W){width=W;}
	public void setHeight(double H){height=H;}
	public double get_X(){return area_X;}
	public double get_Y(){return area_Y;}
	public double get_W(){return width;}
	public double get_H(){return height;}
}
