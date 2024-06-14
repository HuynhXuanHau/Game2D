package main;

import entity.Entity;

public class CollisionChecker {
	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftHouseX = entity.houseX + entity.solidArea.x;
		int entityRightHouseX = entity.houseX + entity.solidArea.x + entity.solidArea.width;
		int entityTopHouseY = entity.houseY + entity.solidArea.y;
		int entityBottomHouseY = entity.houseY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftHouseX/gp.tileSize;
		int entityRightCol = entityRightHouseX/gp.tileSize;
		int entityTopRow = entityTopHouseY/gp.tileSize;
		int entityBottomRow = entityBottomHouseY/gp.tileSize;
		int tileNum1, tileNum2;
		switch (entity.direction) {
		case "up":
			entityTopRow = (entityTopHouseY - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow =( entityBottomHouseY + entity.speed)/ gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftHouseX = (entityLeftHouseX - entity.speed);
			entityLeftCol = entityLeftHouseX /gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision==true|| gp.tileM.tile[tileNum2].collision==true) {
				entity.collisionOn =true;
			}
			break;
		case "right":
			entityRightHouseX =(entityRightHouseX + entity.speed);
			entityRightCol = entityRightHouseX / gp.tileSize;			
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;
		}
	}
		
		public int checkObject(Entity entity, boolean player) {
			int index = 999;
			for (int i=0; i<gp.obj.length; i++) {
				if (gp.obj[i] != null) {
					entity.solidArea.x = entity.houseX + entity.solidArea.x;
					entity.solidArea.y = entity.houseY + entity.solidArea.y;
					
					gp.obj[i].solidArea.x = gp.obj[i].houseX + gp.obj[i].solidArea.x;
					gp.obj[i].solidArea.y = gp.obj[i].houseY + gp.obj[i].solidArea.y;
					
					switch(entity.direction) {
					case "up":
						entity.solidArea.y -= entity.speed;
						if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].collistion == true) {
								entity.collisionOn = true;
							}
							if (player == true) {
								index = i;
							}
						}
						break;
					case "down":
						entity.solidArea.y += entity.speed;
						if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].collistion == true) {
								entity.collisionOn = true;
							}
							if (player == true) {
								index =i;
							}
						}
						break;
					case"right":
						entity.solidArea.x +=entity.speed;
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if(gp.obj[i].collistion==true) {
								entity.collisionOn=true;
							}
							if (player==true) {
								index=i;
							}
						}
						break;
					case"left":
						entity.solidArea.x -=entity.speed;
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if(gp.obj[i].collistion== true) {
								entity.collisionOn= true;
							}
							if(player ==true ) {
								index =i;
							}
						}
						break;
					}
					entity.solidArea.x = entity.solidAreaDefaultX;
					entity.solidArea.y = entity.solidAreaDefaultY;
					gp.obj[i].solidArea.x= gp.obj[i].solidAreaDefaultX;
					gp.obj[i].solidArea.y= gp.obj[i].solidAreaDefaultY;
				}
			}
			return index;
		}
	
}
