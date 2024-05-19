package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.JTextField;

import object.OBJ_Random;



public class UI {

	GamePanel gp;
	Font arial_15,impactf,couter;

	Graphics2D g2 ;
	public boolean messageOn = false;
	public String message ="";
	int messageCounter=0;
	public boolean gameFinish = false;
	public int commandNum = 10;


	public double playTime = 0;
	DecimalFormat dF = new DecimalFormat("#.##");
	public BufferedImage randomImage;

	//JTextField playerNameTextField;//
	public  boolean isTextFieldAdded = false;
	public  boolean gameEnded= true;
	public boolean shouldClearHighScore = true;



	public UI(GamePanel gp) {
		this.gp = gp;
		//
		arial_15 = new Font("Arial", Font.PLAIN, 15);
		couter = new Font("Courier New",Font.BOLD, 50 );
		impactf = new Font("Impact",Font.BOLD, 50 );

		OBJ_Random randomitem = new OBJ_Random();
		randomImage = randomitem.image;
	}

	public void draw(Graphics2D g2) {
		this.g2 = g2;
		switch (gp.gameState) {
		case 0:
			drawTitleState();
			break;
		case 3:
			drawHightScore();
			break;
		case 2:
			drawPauseScreen();
			break;
		case 4:
			drawFinishGame();
			break;
		case 5:
			drawSourceState();
			break;
		case 6:
			drawSettingState();
			break;
		case 1:
			 gp.highScoreBoard.setVisible(false);
			break;
		default:
			break;
		}
	}


	private void drawFinishGame() {
		gp.highScoreBoard.setVisible(false);

		g2.setColor(new Color(77, 36, 14));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

		String text;
		int textLenght;
		int x;
		int y;

		 g2.setFont(g2.getFont().deriveFont(25));
		 g2.setColor(Color.black);
		 text ="You found the treasure!";
		 textLenght= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 x = gp.screenWidth/2 - textLenght/2;
		 y = gp.screenHeight/2 -(gp.tileSize*3);
		 g2.drawString(text, x, y);

		 g2.setFont(impactf);
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,50));
		 g2.setColor(new Color(86, 214, 214));
		 text ="Congratulations!";
		 textLenght= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 x = gp.screenWidth/2- textLenght/2;
		 y = gp.screenHeight/2 - (gp.tileSize*2)+12;
		 g2.drawString(text, x, y);

		 g2.setFont(arial_15);
		 g2.setColor(Color.white);
		 text ="You time is :"+ dF.format(playTime)+"!";
		 textLenght= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 x = gp.screenWidth/2- textLenght/2;
		 y = gp.screenHeight/2 - (gp.tileSize)+12;
		 g2.drawString(text, x, y);

		 g2.setFont(couter);
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,20));
		 g2.setColor(Color.white);
		 text ="PLAY AGAIN";
		 textLenght= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 x = gp.screenWidth/2- textLenght/2;
		 y = gp.screenHeight/2 + (gp.tileSize*2)+24;
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);
		 if(commandNum == 0) {
				g2.drawString(">", x - gp.tileSize, y);
			}

		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,20));
		 g2.setColor(Color.white);
		 text ="QUIT";
		 textLenght= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 x = gp.screenWidth/2- textLenght/2;
		 y = gp.screenHeight/2 + (gp.tileSize*3)+12;
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);
		 if(commandNum == 1) {
				g2.drawString(">", x - gp.tileSize, y);
			}

		 g2.setFont(arial_15);
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,15));
		 g2.setColor(Color.white);
		 text ="Please leave your name";
		 textLenght= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 x = gp.screenWidth/2- textLenght/2;
		 y = gp.screenHeight/2 - (gp.tileSize/2)+12;
		 g2.drawString(text, x, y);

		if (!isTextFieldAdded && !gameEnded ) {
			gp.playerNameTextField = new JTextField();
		 gp.playerNameTextField.setBounds(gp.screenWidth / 2 - gp.tileSize*2, gp.screenHeight / 2 +12, gp.tileSize*4, gp.tileSize/2);
		 gp.playerNameTextField.setSelectedTextColor(Color.green);
		 gp.playerNameTextField.setOpaque(true);
		 gp.add(gp.playerNameTextField);
		 isTextFieldAdded = true;
		 gp.playerNameTextField.addActionListener(new HandlePlayerName(gp,this));
		}
	}

	public void drawingame(Graphics2D g2) {
		g2.setColor(new Color(229,235,214));
		 g2.setFont(arial_15);
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,15));

		if (gp.gameState == gp.playerState) {
		playTime+=(double)1/60;
		g2.drawString("Time:"+dF.format(playTime),gp.tileSize*10,gp.tileSize);
		}

		g2.drawString("You are holding" ,  gp.tileSize/2,gp.tileSize);
		g2.drawImage(randomImage, gp.tileSize*2+12 + 28,gp.tileSize/2, gp.tileSize, gp.tileSize,null);

	}


	public void drawHightScore() {

		//gp.highScoreBoard.removeAll();
		g2.setColor(new Color(77, 36, 14));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		 g2.setFont(couter);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,40));
		 String text = "HIGH SCORE";
		 int x= getXforCenteredText(text)-gp.tileSize-24;
		 int y = gp.screenHeight/2 - gp.tileSize*2-12;
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);

		 text = "QUIT";
		 x =getXforCenteredText(text)+ gp.tileSize*4+24;
		 y+= gp.tileSize*5+24;
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,20));
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);
		 if(commandNum == 1) {
				g2.drawString(">", x - gp.tileSize, y);
			}

	}
public void drawSourceState() {
	g2.setColor(Color.white);
	g2.drawRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setColor(new Color(77, 36, 14));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,40));
		g2.setFont(impactf);
		 String text = "SOURCE";
		 int x= getXforCenteredText(text)-gp.tileSize-12;
		 int y = gp.screenHeight/2 - gp.tileSize*2;
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);

		 text = "QUIT";
		 x =getXforCenteredText(text)+ gp.tileSize*4;
		 y+= gp.tileSize*5;
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,20));
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);

		 if(commandNum == 1) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			g2.setFont(arial_15);
		 text = "The game idea and graphics are inspired by the game Un Thief by Dan or Daniel";
		 x =getXforCenteredText(text)+ gp.tileSize;
		 y-= gp.tileSize*3 +24;
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,12));
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);

		 text = "Background music from YouTube RyiSnow";
		 x =getXforCenteredText(text)+ gp.tileSize;
		 y+= 36;
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,12));
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);

		 text = "The game is made by Hau 23AI014 who takes care of the code and interface... ";
		 x =getXforCenteredText(text);
		 y+= 36;
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,12));
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);

		 text = "and Huy 23AI016 takes care of the graphics.";
		 x =getXforCenteredText(text)+ gp.tileSize;
		 y+= 36;
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,12));
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);
}

	 public void drawTitleState() {
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

		g2.setFont(impactf);
	//	 g2.setFont(couter);
		String text = "THIEVES' JUSTICE";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2 - gp.tileSize*2;

		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		g2.setColor(Color.white);
		g2.drawString(text, x, y);


		g2.setColor(new Color(0,0,0,70));
		int squareWidth = gp.getWidth();
		 int squareHeight = gp.tileSize*4;
		 //int squareX = gp.getWidth()  ;
		 int squareY = gp.screenHeight/2 +20 ;
		 g2.fillRect(0, squareY, squareWidth, squareHeight);

		//Thief
			x = gp.screenWidth/2 - (gp.tileSize*2)/2;
			y+= gp.tileSize;
			g2.drawImage(gp.player.down1, x, y, gp.tileSize*2 ,gp.tileSize*2 ,null);


		 g2.setColor(Color.white);
		//menu
		 g2.setFont(couter);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,20));
		text ="New Game";
		x = getXforCenteredText(text);
		y+= gp.tileSize*2.5;
		g2.setColor(Color.black);
		g2.drawString(text, x+2, y+2);
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x - gp.tileSize, y);
		}

		text ="Load Game";
		x = getXforCenteredText(text);
		y+= gp.tileSize/2;
		g2.setColor(Color.black);
		g2.drawString(text, x+2, y+2);
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x - gp.tileSize, y);
		}

		text ="High Score";
		x = getXforCenteredText(text);
		y+= gp.tileSize/2;
		g2.setColor(Color.black);
		g2.drawString(text, x+2, y+2);
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		if(commandNum == 2) {
			g2.drawString(">", x - gp.tileSize, y);
		}

		text ="Source";
		x = getXforCenteredText(text);
		y+= gp.tileSize/2;
		g2.setColor(Color.black);
		g2.drawString(text, x+2, y+2);
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		if(commandNum == 3) {
			g2.drawString(">", x - gp.tileSize, y);
		}

		text ="Exit";
		x = getXforCenteredText(text);
		y+= gp.tileSize/2;
		g2.setColor(Color.black);
		g2.drawString(text, x+2, y+2);
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		if(commandNum == 4) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		 int buttonWidth = gp.tileSize /2;
		 int buttonHeight = gp.tileSize/2;
		 int buttonX = gp.screenWidth - buttonWidth - gp.tileSize/4;
		 int buttonY = gp.tileSize/4;

		 // Draw button background (adjust color and style as desired)
		 g2.setColor(Color.lightGray);
		 g2.fillRect(buttonX, buttonY, buttonWidth, buttonHeight);


		 //set icon cho cài đặt
		 BufferedImage settingsIcon = null;
		 try {
			 settingsIcon = ImageIO.read(getClass().getResourceAsStream("/res/objects/icon.png"));  // Replace with your image path
		 } catch (IOException e) {
			 // Handle image loading error (e.g., print message)
			 e.printStackTrace();
		 }

		 if (settingsIcon != null) {
			 int iconWidth = settingsIcon.getWidth();
			 int iconHeight = settingsIcon.getHeight();
			 int iconX = buttonX + (buttonWidth - iconWidth) / 2;  // Center the icon
			 int iconY = buttonY + (buttonHeight - iconHeight) / 2;  // Center the icon
			 g2.drawImage(settingsIcon, iconX, iconY, null);
		 }

		 if(commandNum == 5) {
			 g2.drawString(">", buttonX - gp.tileSize/2, buttonY*3);
		 }

	 }

	public void drawSettingState() {
		// Vẽ nền cho màn hình cài đặt
		g2.setColor(new Color(77, 36, 14));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

		// Thiết lập font và màu cho tiêu đề
		g2.setFont(impactf);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));
		g2.setColor(Color.white);

		// Vẽ tiêu đề
		String title = "SETTINGS";
		int titleX = getXforCenteredText(title);
		int titleY = gp.tileSize * 2;
		g2.setColor(Color.black);
		g2.drawString(title, titleX + 5, titleY + 5);
		g2.setColor(Color.white);
		g2.drawString(title, titleX, titleY);

		// Vẽ các lựa chọn bản đồ\
		g2.setFont(arial_15);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));
		String mapText = "Please choose one map: ";
		int mapX = getXforCenteredText(mapText);
		int mapY = titleY + gp.tileSize +gp.tileSize/2;
		g2.setColor(Color.black);
		g2.drawString(mapText, mapX + 5, mapY + 5);
		g2.setColor(Color.white);
		g2.drawString(mapText, mapX, mapY);

		g2.setFont(arial_15);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));
		String map1Text = "Map 1";
		int map1X = getXforCenteredText(map1Text);
		int map1Y = mapY + gp.tileSize;
		g2.setColor(Color.black);
		g2.drawString(map1Text, map1X + 5, map1Y + 5);
		g2.setColor(Color.white);
		g2.drawString(map1Text, map1X, map1Y);

		String map2Text = "Map 2";
		int map2X = getXforCenteredText(map2Text);
		int map2Y = map1Y +gp.tileSize/2+gp.tileSize/3;
		g2.setColor(Color.black);
		g2.drawString(map2Text, map2X + 5, map2Y + 5);
		g2.setColor(Color.white);
		g2.drawString(map2Text, map2X, map2Y);

		// Vẽ các nút Save và Cancel
		String text = "QUIT";
		int x =getXforCenteredText(text)+ gp.tileSize*4+24;
		int y = map2Y+ gp.tileSize*1+24  ;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,20));
		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		g2.setColor(Color.white);
		g2.drawString(text, x, y);




		// Vẽ con trỏ lựa chọn (dấu >) cho các lựa chọn
		switch (commandNum) {
			case 0:
				g2.drawString(">", map1X - gp.tileSize, map1Y);
				break;
			case 1:
				g2.drawString(">", map2X - gp.tileSize, map2Y);
				break;
			case 2:
				g2.drawString(">", x - gp.tileSize, y);
				break;
		}
	}


	public void drawPauseScreen() {

		 int squareWidth = gp.getWidth();
		 int squareHeight = gp.getHeight();

		 g2.setColor(new Color(0,0,0,150));
		 g2.fillRect(0, 0, squareWidth, squareHeight);
		 g2.setFont(couter);
		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,50));
		 String text = "PAUSE";
		 int x= getXforCenteredText(text);;
		 int y = gp.screenHeight/2- gp.tileSize;
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);


		 g2.setFont(g2.getFont().deriveFont(Font.BOLD,20));
		 text = "RESUME";
		 x =getXforCenteredText(text);
		 y+= gp.tileSize*1;
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);
		 if(commandNum == 0) {
				g2.drawString(">", x - gp.tileSize, y);
			}

		 text = "QUIT";
		 x =getXforCenteredText(text);
		 y+= gp.tileSize*1;
		 g2.setColor(Color.black);
		 g2.drawString(text, x+5, y+5);
		 g2.setColor(Color.white);
		 g2.drawString(text, x, y);
		 if(commandNum == 1) {
				g2.drawString(">", x - gp.tileSize, y);
			}
	 }
	 public int getXforCenteredText(String text) {
		 int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 int x= gp.screenWidth /2 - length/2;
		 return x;
	 }

}
