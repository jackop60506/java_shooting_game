 

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageSequence_boom  extends ImageSequence{
	private static ArrayList<Image> Img_boom= new ArrayList<Image>();

	private int Boom_Index=0;

	public ImageSequence_boom(){
		try{
			for(int i=0;i<10;i++){
				Img_boom.add(
						ImageIO.read(new File(path+"boom_bit"+i+filename))
						);
			}
		}catch(Exception e){
			System.out.println("no image");
		}
	}
	public void setIndex(int s){
		Boom_Index=s;
	}
	public Image getBoomImage(int i){
		return Img_boom.get(i);
	}	
	public Image nextBoomImage(){
		Boom_Index++;
		Boom_Index=Boom_Index%10;
		return Img_boom.get(Boom_Index);
	}
	
}
