 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TimerListen implements ActionListener  {
	private Controller ctl;
	private HashMap<Direction,Boolean> dirmap;
	private HashMap<Plane_skill,Boolean> planeskillmap;
	private HashMap<Enum_gamekey,Boolean> gamekeymap;
	private View.PaintPanel paint_p;
	public TimerListen(Controller c,HashMap<Direction,Boolean> d,
			HashMap<Plane_skill,Boolean> ps,HashMap<Enum_gamekey,Boolean> ga,View.PaintPanel p){
		this.ctl=c;
		this.dirmap=d;
		this.paint_p=p;
		this.planeskillmap=ps;
		this.gamekeymap=ga;
	}
	public void actionPerformed(ActionEvent e){
		boolean move =false;		
		boolean RunOrNot=ctl.checkState();
		boolean skillmutex=true;
		if(gamekeymap.get(Enum_gamekey.START)){
			
			if(RunOrNot==false){
				ctl.gameStart();
			}
		}
		if(gamekeymap.get(Enum_gamekey.CLOSE)){
			
			if(RunOrNot==true){
				ctl.gamePause();
			}
		}
		if(RunOrNot){
			ctl.enemyNormalShoot();
			ctl.Stage_run();
			ctl.enemyRocketShoot();
			ctl.checkItemState();
			ctl.checkBoomState();
			for(Direction d :Direction.values()){
				if(dirmap.get(d)){
						ctl.playerX(d);
						ctl.playerY(d);
						move=true;
				}
			}
			for(Plane_skill p :Plane_skill.values()){
				
				if(planeskillmap.get(p)){
					
					if(p.toString().equals("SHOOT")){
						ctl.playerShoot();
					}else if(p.toString().equals("SUPERSHOOT")){
						ctl.playerShoot2();
					}else if(p.toString().equals("TIMESTOP")){
						
						ctl.player_TimeStop();
					}
					
					
				}
				
			}
			if(move){
				ctl.player_request("Flying");
				
			}else{
				ctl.player_request("Nothing");
			}
			
		}		
		paint_p.repaint();
	}
}
