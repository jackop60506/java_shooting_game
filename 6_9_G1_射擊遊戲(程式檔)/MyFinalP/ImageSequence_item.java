 

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageSequence_item extends ImageSequence{

	private static ArrayList<Image> power_up_image_sequence= new ArrayList<Image>();
	private static ArrayList<Image> life_up_image_sequence= new ArrayList<Image>();

	private int power_up_Index=0;
	private int life_up_Index=0;

	public ImageSequence_item(){
		try{
			for(int i=0;i<3;i++){
				power_up_image_sequence.add(
						ImageIO.read(new File(path+"power_upitem_"+i+filename))
						);
				life_up_image_sequence.add(
						ImageIO.read(new File(path+"life_upitem_"+i+filename))
						);
			}
		}catch(Exception e){
			System.out.println("no image");
		}
	}
	public Image getpowerupImage(int i){
		return power_up_image_sequence.get(i);
	}	
	public Image nextpowerupImage(){
		power_up_Index++;
		power_up_Index=power_up_Index%3;
		return power_up_image_sequence.get(power_up_Index);
	}
	public Image getlifeupImage(int i){
		return life_up_image_sequence.get(i);
	}	
	public Image nextlifeupImage(){
		life_up_Index++;
		life_up_Index=life_up_Index%3;
		return life_up_image_sequence.get(life_up_Index);
	}
	
}
