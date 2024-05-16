package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.*;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	final int originalTileSize =16;
	final int scale =3;
	public final int tileSize = originalTileSize *scale;
	public final int maxScreenCol = 12, maxScreenRow = 8;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize *maxScreenRow;
	
	//HOUSE SETTING
	public final int maxHouseCol = 35;
	public final int maxHouseRow = 35;
	public final int houseWidth = tileSize * maxHouseCol;
	public final int houseHeight = tileSize * maxHouseRow;
	
	//FPS
	int FPS =60;
	//SYSTEM
	TileManager tileM = new TileManager(this);
	Entity entity = new Entity();
	KeyHandler keyH = new KeyHandler(this);
	Sound se = new Sound();
	Sound music = new Sound();



	public Player player = new Player(this, entity, keyH);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	//Entity and object
	public SuperObject obj[] = new SuperObject[10];
	public SuperObject oBJ = new SuperObject();
	
	//Game state
	public int gameState;
	public final int titleState = 0;
	public final int playerState = 1;
	public final int pauseState = 2;
	public final int hightState = 3;
	public final int finishState = 4;
	public final int sourceState = 5;
	public final HightScoreBoard highScoreBoard = new HightScoreBoard();
	public JTextField playerNameTextField = new JTextField();;
	public boolean checkNewGame = false;
	
	//GameNet

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.add(highScoreBoard);
		this.add(playerNameTextField);
	//	playerNameTextField.addActionListener(new HandlePlayerName(ui,playerNameTextField));
		setLayout(null);
		
	}
	
	public void setupGame() {
		aSetter.setObject();
		playMusic(0);
		keyH.music = false;
		gameState = titleState;


	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();

	}
	
	@Override
	public void run() {
		double drawIterval = 1000000000/FPS;
		long lastTime = System.nanoTime();
		long currentTime;
		double delta = 0;

		while(gameThread != null) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime )/ drawIterval;
			lastTime = currentTime;
			if(delta >=1) {
				update();
				repaint();
				delta --;
			}
		}
	}
	public void update() {
		if(gameState == playerState) {
			player.update();
		}
	}
	
	public void resetGame() {
		player.reset();
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	     Image offScreenImage2 = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
	     Image offScreenImage21 = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
	     
	     //high
	    if (gameState == hightState ) {
	        ui.draw((Graphics2D)g);
	        highScoreBoard.setVisible(true);
	    } else 
	    	//finish
	    	if (gameState == finishState) {
	    	   playerNameTextField.setVisible(true);
	    	Graphics2D fsGraphics = (Graphics2D) offScreenImage2.getGraphics();
	    	ui.gameEnded = false;
	        fsGraphics.clearRect(0, 0, getWidth(), getHeight());
	        ui.draw(fsGraphics);
	        g.drawImage(offScreenImage2, 0, 0, this);
	        fsGraphics.dispose();
	    } 
	    else
	    	//soucre
	    	if(gameState==sourceState ) {
	    	highScoreBoard.setVisible(false);
	    	playerNameTextField.setVisible(false);  
	    	Graphics2D fsGraphics = (Graphics2D) offScreenImage21.getGraphics();
	    	ui.g2.clearRect(0, 0, getWidth(), getHeight());
	    	ui.draw(fsGraphics);
	    	g.drawImage(offScreenImage21, 0, 0, this);
	    }else
	    {
	        highScoreBoard.setVisible(false);
	        playerNameTextField.setVisible(false);

	        Graphics2D g2 = (Graphics2D) g;
	        g2.clearRect(0, 0, getWidth(), getHeight());

	        // Tile screen
	        tileM.draw(g2);
	        for (int i = 0; i < obj.length; i++) {
	            if (obj[i] != null) {
	                obj[i].draw(g2, this);
	            }
	        }
	        ui.drawingame(g2);
	        player.draw(g2);
	        ui.draw(g2);
	        g2.dispose();
	    }
	}

	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}
