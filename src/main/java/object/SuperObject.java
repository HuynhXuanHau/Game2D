package object;

import main.GamePanel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public class SuperObject {
	public BufferedImage image;
	public String name;
	public boolean collistion = false;
	public int houseX,houseY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		int screenX = houseX - gp.player.houseX + gp.player.screenX;
		int screenY = houseY - gp.player.houseY + gp.player.screenY;
		
		
		if (houseX + gp.tileSize > gp.player.houseX - gp.player.screenX &&
			houseX - gp.tileSize < gp.player.houseX + gp.player.screenX &&
			houseY + gp.tileSize > gp.player.houseY - gp.player.screenY &&
			houseY - gp.tileSize < gp.player.houseY + gp.player.screenY) {
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}
	
	//Random
	private Random random = new Random();
	public List<String> availableItems ;
	public boolean touched = false;
	public boolean canAgain = true;
	
	public String getRandomItemFromCell() {
		if(!availableItems.isEmpty()) {
			random = new Random();
			int randomIndex = random.nextInt(availableItems.size());
			String selectedItem = availableItems.get(randomIndex);
	        availableItems.remove(randomIndex);
			return selectedItem;
		}
		else {
			return "NoItem";
		}
	}
	
	public void reset() {
		this.touched = false;
	}


}
