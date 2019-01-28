 

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageSequence_plane extends ImageSequence{
	
	private static ArrayList<Image> fire_bottom_image_sequence= new ArrayList<Image>();
	private static ArrayList<Image> plane_image_sequence= new ArrayList<Image>();
	private int Fire_Bottom_Index=0;
	private int Plane_Index=0;
	public ImageSequence_plane(){
		try{
			for(int i=0;i<3;i++){
				fire_bottom_image_sequence.add(
						ImageIO.read(new File(path+"fire_bottom_"+i+filename))
						);
			}
			for(int i=0;i<3;i++){
				plane_image_sequence.add(
						ImageIO.read(new File(path+"plane2_"+i+filename))
						);
			}
		}catch(Exception e){
			System.out.println("no image");
		}
	}
	public Image getImage(int i){
		return fire_bottom_image_sequence.get(i);
	}
	public Image planegetImage(int i){
		return plane_image_sequence.get(i);
	}
	
	
	
	public Image nextImage(){
		Fire_Bottom_Index++;
		Fire_Bottom_Index=Fire_Bottom_Index%3;
		System.out.println(Fire_Bottom_Index);
		return fire_bottom_image_sequence.get(Fire_Bottom_Index);
	}
	
	public Image PlanenextImage(){
		Plane_Index++;
		Plane_Index=Plane_Index%3;
		return plane_image_sequence.get(Plane_Index);
	}
}
