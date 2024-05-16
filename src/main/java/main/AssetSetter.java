package main;

import object.OBJ_Gold;
import object.OBJ_Item4;
import object.OBJ_Item5;
import object.OBJ_Money;
import object.OBJ_Random;
import object.OBJ_Shit;

public class AssetSetter {
	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {

		gp.obj[5] = new OBJ_Random();
		gp.obj[5].houseX = 5 * gp.tileSize;
		gp.obj[5].houseY = 12 * gp.tileSize;
		
		gp.obj[0] =new OBJ_Shit();
		gp.obj[0].houseX = 28*gp.tileSize;
		gp.obj[0].houseY =18*gp.tileSize;
		
		gp.obj[3] = new OBJ_Item4();
		gp.obj[3].houseX = 22*gp.tileSize;
		gp.obj[3].houseY =8*gp.tileSize;
		
		gp.obj[4] = new OBJ_Item5();
		gp.obj[4].houseX = 21*gp.tileSize;
		gp.obj[4].houseY = 12*gp.tileSize;
		
		gp.obj[1] = new OBJ_Gold();
		gp.obj[1].houseX = 18*gp.tileSize;
		gp.obj[1].houseY = 18*gp.tileSize;
		
		gp.obj[2] = new OBJ_Money();
		gp.obj[2].houseX = 12*gp.tileSize;
		gp.obj[2].houseY = 9*gp.tileSize;
		
	}
	
}
