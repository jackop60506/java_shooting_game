 
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageSequence_enemy extends ImageSequence{
	private static ArrayList<Image> enemy_normal_image_sequence= new ArrayList<Image>();
	
	private static ArrayList<Image> enemy_normals_image_sequence= new ArrayList<Image>();
	private static ArrayList<Image> enemy_rocket_image_sequence= new ArrayList<Image>();
	private static ArrayList<Image> enemy_rockets_image_sequence= new ArrayList<Image>();

	private static ArrayList<Image> enemy_smile_image_sequence= new ArrayList<Image>();
	private static ArrayList<Image> enemy_smiles_image_sequence= new ArrayList<Image>();

	private static ArrayList<Image> enemy_boss_image_sequence= new ArrayList<Image>();
	private static ArrayList<Image> enemy_boss2_image_sequence= new ArrayList<Image>();

	private int Enemy_Normal_Index=-1;
	private int Enemy_Normals_Index=-1;
	
	private int Enemy_Rocket_Index=-1;
	private int Enemy_Rockets_Index=-1;
	private int Enemy_Smile_Index=-1;
	private int Enemy_Smiles_Index=-1;
	private int Enemy_Boss2_Index=-1;

	private int Enemy_Boss_Index=-1;
	public ImageSequence_enemy(){
		try{
			for(int i=0;i<3;i++){
				enemy_boss_image_sequence.add(
						ImageIO.read(new File(path+"boss21_"+i+filename))
						);
				enemy_boss2_image_sequence.add(
						ImageIO.read(new File(path+"boss3_"+i+filename))
						);
				enemy_normal_image_sequence.add(
						ImageIO.read(new File(path+"enemy_1_"+i+filename))
						);
				enemy_normals_image_sequence.add(
						ImageIO.read(new File(path+"enemys_1_"+i+filename))
						);
				enemy_rocket_image_sequence.add(
						ImageIO.read(new File(path+"enemy_2_"+i+filename))
						);
				enemy_rockets_image_sequence.add(
						ImageIO.read(new File(path+"enemys_2_"+i+filename))
						);
				enemy_smile_image_sequence.add(
						ImageIO.read(new File(path+"enemy_3_"+i+filename))
						);
				enemy_smiles_image_sequence.add(
						ImageIO.read(new File(path+"enemys_3_"+i+filename))
						);
			}
		}catch(Exception e){
			System.out.println("no image");
		}
	}
	public Image getNormalsenemyImage(int i){
		return enemy_normals_image_sequence.get(i);
	}
	public Image nextNormalsenemyImage(){
		
		Enemy_Normals_Index++;
		Enemy_Normals_Index=Enemy_Normals_Index%3;
		
		return enemy_normals_image_sequence.get(Enemy_Normals_Index);
	}
	public Image getNormalenemyImage(int i){
		return enemy_normal_image_sequence.get(i);
	}
	public Image nextNormalenemyImage(){
		
		Enemy_Normal_Index++;
		Enemy_Normal_Index=Enemy_Normal_Index%3;
		
		return enemy_normal_image_sequence.get(Enemy_Normal_Index);
	}
	public Image nextBossenemyImage(){
		Enemy_Boss_Index++;
		Enemy_Boss_Index=Enemy_Boss_Index%3;
		
		return enemy_boss_image_sequence.get(Enemy_Boss_Index);
	}
	public Image getBossenemyImage(int i){
		return enemy_boss_image_sequence.get(i);
	}
	public Image nextBoss2enemyImage(){
		Enemy_Boss2_Index++;
		Enemy_Boss2_Index=Enemy_Boss2_Index%3;
		
		return enemy_boss2_image_sequence.get(Enemy_Boss2_Index);
	}
	public Image getBoss2enemyImage(int i){
		return enemy_boss2_image_sequence.get(i);
	}
	public Image getRocketenemyImage(int i){
		return enemy_rocket_image_sequence.get(i);
	}
	
	public Image nextRocketenemyImage(){
		Enemy_Rocket_Index++;
		Enemy_Rocket_Index=Enemy_Rocket_Index%3;
		
		return enemy_rocket_image_sequence.get(Enemy_Rocket_Index);
	}
	public Image getSmilesenemyImage(int i){
		return enemy_smiles_image_sequence.get(i);
	}

	public Image nextSmilesenemyImage(){
		Enemy_Smiles_Index++;
		Enemy_Smiles_Index=Enemy_Smiles_Index%3;
		
		return enemy_smiles_image_sequence.get(Enemy_Smiles_Index);
	}
	public Image getRocketsenemyImage(int i){
		return enemy_rockets_image_sequence.get(i);
	}

	public Image nextRocketsenemyImage(){
		Enemy_Rockets_Index++;
		Enemy_Rockets_Index=Enemy_Rockets_Index%3;
		
		return enemy_rockets_image_sequence.get(Enemy_Rockets_Index);
	}
	public Image getSmileenemyImage(int i){
		return enemy_smile_image_sequence.get(i);
	}

	public Image nextSmileenemyImage(){
		Enemy_Smile_Index++;
		Enemy_Smile_Index=Enemy_Smile_Index%3;
		
		return enemy_smile_image_sequence.get(Enemy_Smile_Index);
	}
}
