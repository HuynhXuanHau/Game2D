package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Random;

public class Player extends Entity {
	GamePanel gp;
	Entity entity;
	KeyHandler keyH;
	protected String name;
	
	public final int screenX,screenY;
	public String itemName = " ";
	int shit=0,money=0,gold=0,item4=0,item5=0;


	
//	public Player(GamePanel gp, Entity entity, KeyHandler keyH, String name) {
//		this.gp = gp;
//		this.entity = entity;
//		this.keyH = keyH;
//		this.name = name ;
//
//		screenX = gp.screenWidth/2 -(gp.tileSize/2);
//		screenY = gp.screenHeight/2 -(gp.tileSize/2);
//
//		solidArea = new Rectangle();
//		solidArea.x = 8;
//		solidArea.y = 15;
//		solidAreaDefaultX = solidArea.x;
//		solidAreaDefaultY = solidArea.y;
//		solidArea.width = 31;
//		solidArea.height = 32;
//
//		setDefaultValues();
//		getPlayerImage();
//	}
	public Player(GamePanel gp, Entity entity, KeyHandler keyH) {
		this.gp = gp;
		this.entity = entity;
		this.keyH = keyH;


		screenX = gp.screenWidth/2 -(gp.tileSize/2);
		screenY = gp.screenHeight/2 -(gp.tileSize/2);

		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 15;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 31;
		solidArea.height = 32;

		setDefaultValues();
		getPlayerImage();
	}



	public void setDefaultValues() {
		houseX = gp.tileSize * 7;
		houseY = gp.tileSize * 12;
		speed = 4;
		direction ="down";
	}
	
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Thiefup1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Thiefup2.png"));
			down1= ImageIO.read(getClass().getResourceAsStream("/res/player/Thief1.png"));
			down2= ImageIO.read(getClass().getResourceAsStream("/res/player/Thief2.png"));
			left1= ImageIO.read(getClass().getResourceAsStream("/res/player/Thiefleft1.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/res/player/Thiefleft2.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/res/player/Thief1.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/res/player/Thief1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update() {
		if(keyH.upPressed== true|| keyH.downPressed == true
			|| keyH.leftPressed == true|| keyH.rightPressed == true){
				if ( keyH.downPressed == true) {
					direction = "down";
				}else
				if (keyH.upPressed == true) {
					direction = "up";
				}else
				if (keyH.rightPressed == true) {
					direction = "right";
				}else
				if (keyH.leftPressed == true) {
					direction = "left";
				}else
					direction = "down";
				
				//check tile collision
				collisionOn = false;
				gp.cChecker.checkTile(this);
				
				//Check object collision
				int objIndex = gp.cChecker.checkObject(this, true);
				pickUpObject(objIndex);
				
				if(collisionOn == false) {
					switch (direction) {
				case"up":
					houseY -= speed;
					break;
				case"down":
					houseY +=speed;
					break;
				case"left":
					houseX -=speed;
					break;
				case"right":
					houseX +=speed;
					break;
					}
				}
				spriteCounter ++;
				if (spriteCounter > 12) {
					if (spriteNum == 1) {
						spriteNum = 2;
					}else if (spriteNum == 2) {
						spriteNum = 1;
					}
					spriteCounter = 0;
				}
		}
	}
	
	
	public void pickUpObject(int i) {
		if (i!= 999) {
			String objectName = gp.obj[i].name;
			switch (objectName) {
			case "Random" :
				if (!entity.collisionOn) {
					gp.playSE(1);
					String itemName = gp.oBJ.getRandomItemFromCell();
					if (itemName != "NoItem") {
						switch (itemName) {
						case "Shit":
							shit = 1;
							gp.ui.randomImage = gp.obj[0].image;
							break;
						case "Gold":
							gold = 1;
							gp.ui.randomImage = gp.obj[1].image;
							break;
						case "Money":
							money = 1;
							gp.ui.randomImage = gp.obj[2].image;
							break;
						case "Item4":
							item4 = 1;
							gp.ui.randomImage = gp.obj[3].image;
							break;
						case "Item5":
							item5 = 1;
							gp.ui.randomImage = gp.obj[4].image;
							break;
						}
						this.entity.collisionOn = true;
					} else
					{
						gp.playSE(3);
						gp.gameState = gp.finishState;
						System.out.println("Current gameState: " + gp.gameState);
						gp.stopMusic();
					}
				}
				break;
			case "Shit":
				if (shit == 1) {
					//gp.obj[i].reset();
					gp.ui.randomImage = gp.obj[5].image;
					gp.playSE(5);
					shit = 0;
					this.entity.collisionOn = false;
				}
				break;
			case "Gold":
				if (gold == 1) {
					gp.ui.randomImage = gp.obj[5].image;
					gp.playSE(5);
					gold = 0;
					this.entity.collisionOn = false;
				}
				break;
			case "Money":
				if (money == 1) {
					gp.ui.randomImage = gp.obj[5].image;
					gp.playSE(5);
					money = 0;
					this.entity.collisionOn = false;
				}
				break;
			case "Item4":
				if (item4 == 1) {
					gp.ui.randomImage = gp.obj[5].image;
					gp.playSE(5);
					item4 = 0;
					this.entity.collisionOn = false;
				}
				break;
			case "Item5":
				if (item5 == 1) {
					gp.ui.randomImage = gp.obj[5].image;
					gp.playSE(5);
					item5 = 0;
					this.entity.collisionOn = false;
				}
				break;
			} 
		}
	}
	
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch (direction) {
		case"up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
				}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
				}
			if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
				}
			if (spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}


	public void reset() {
		setDefaultValues();
	    getPlayerImage();
	    this.entity.collisionOn = false;
	    keyH.music = false;
	    itemName = " ";
	    shit = 0;
	    money = 0;
	    gold = 0;
	    item4 = 0;
	    item5 = 0;
		gp.ui.randomImage= gp.obj[5].image;
	    gp.oBJ.availableItems = new ArrayList<>(Arrays.asList("Shit","Gold","Money","Item4","Item5"));
	    gp.ui.gameEnded = true;
	    gp.ui.isTextFieldAdded = false; 
	

	}
	
}
